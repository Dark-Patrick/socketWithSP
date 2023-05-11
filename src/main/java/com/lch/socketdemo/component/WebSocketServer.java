package com.lch.socketdemo.component;

import com.alibaba.fastjson.JSON;
import com.lch.socketdemo.entity.Model;
import com.lch.socketdemo.web.service.FileService;
import com.lch.socketdemo.web.service.UserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/server/{username}")
@RestController
public class WebSocketServer {
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    /**
     * 记录当前在线连接数
     */
    public static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    @Resource
    private FileService fileService;
    @Resource
    private UserService userService;

//    @Transactional
    @RequestMapping(value = "/db/update", method = RequestMethod.GET)
    public void updateDb(@RequestParam("name") String name, @RequestParam("camera")String camera){
        System.out.println("员工ID" + name + "摄像头：" + camera);
        //onMessage("数据库更新", null, "lch");
//        Model testModel = new Model();
//        testModel.setCl("2022-2-24");
//        testModel.setDes("测试用数据");
//        testModel.setId(1003);
//
//        JSONObject result = new JSONObject();
//        result.put("cl", testModel.getCl());
//        result.put("des", testModel.getDes());
//        result.put("id", testModel.getId());

        /*        接收到模型的的数据：员工id， 摄像头id，插入记录表
          根据id查询两表，对比两者级别 反馈给前端员工信息，识别地点，识别时间，行为分析
        * */
            Model model = userService.getModelRec(Integer.parseInt(camera), name);
            userService.insertRecord(camera, name, model.getDes());
            String json = JSON.toJSONString(model);
            sendAllMessage(json);
            System.out.println(json);
//            测试用句
//            Model modelTest = fileService.listRecord();
//            String test = JSON.toJSONString(modelTest);
//            System.out.println(test);
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        sessionMap.put(username, session);
        log.info("有新用户加入，username={}, 当前在线人数为：{}", username, sessionMap.size());
//        JSONObject result = new JSONObject();
//        JSONArray array = new JSONArray();
//        result.set("users", array);
//        for (Object key : sessionMap.keySet()) {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.set("username", key);
//            // {"username", "zhang", "username": "admin"}
//            array.add(jsonObject);
//        }
////        {"users": [{"username": "zhang"},{ "username": "admin"}]}
//        sendAllMessage(JSONUtil.toJsonStr(result));  // 后台发送消息给所有的客户端
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        sessionMap.remove(username);
        log.info("有一连接关闭，移除username={}的用户session, 当前在线人数为：{}", username, sessionMap.size());
    }

    /**
     * 收到客户端消息后调用的方法
     * 后台收到客户端发送过来的消息
     * onMessage 是一个消息的中转站
     * 接受 浏览器端 socket.send 发送过来的 json数据
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("username") String username) {
        log.info("服务端收到用户username={}的消息:{}", username, message);
        System.out.println("onMessage: 更新数据！！");
//        sendAllMessage("调用了接口，刷新前端数据！！");
//        JSONObject obj = JSONUtil.parseObj(message);
//        String toUsername = obj.getStr("to"); // to表示发送给哪个用户，比如 admin
//        String text = obj.getStr("text"); // 发送的消息文本  hello
//        // {"to": "admin", "text": "聊天文本"}
//        Session toSession = sessionMap.get(toUsername); // 根据 to用户名来获取 session，再通过session发送消息文本
//        if (toSession != null) {
//            // 服务器端 再把消息组装一下，组装后的消息包含发送人和发送的文本内容
//            // {"from": "zhang", "text": "hello"}
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.set("from", username);  // from 是 zhang
//            jsonObject.set("text", text);  // text 同上面的text
//            this.sendMessage(jsonObject.toString(), toSession);
//            log.info("发送给用户username={}，消息：{}", toUsername, jsonObject.toString());
//        } else {
//            log.info("发送失败，未找到用户username={}的session", toUsername);
//        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 服务端发送消息给客户端
     */
    private void sendMessage(String message, Session toSession) {
        try {
            log.info("服务端给客户端[{}]发送消息{}", toSession.getId(), message);
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败", e);
        }
    }

    /**
     * 服务端发送消息给所有客户端
     */
    private void sendAllMessage(String message) {
        try {
            for (Session session : sessionMap.values()) {
                log.info("服务端给客户端[{}]发送消息{}", session.getId(), message);
                session.getBasicRemote().sendText(message);
            }
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败", e);
        }
    }
}
