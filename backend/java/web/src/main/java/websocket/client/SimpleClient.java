package websocket.client;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
/**
 * Created by Administrator on 2016/4/17.
 */
@ClientEndpoint
public class SimpleClient {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to endpoint:"+ session.getBasicRemote());
        try {
            session.getBasicRemote().sendText("Hello");
        } catch (IOException ex) {
        }
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println(message);
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    public static void main(String[] args)throws Exception{
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri ="ws://localhost:8077/web/SimpleWebSocket";
        System.out.println("Connecting to"+ uri);
        Session session = container.connectToServer(SimpleClient.class, URI.create(uri));

        session.getBasicRemote().sendText("这是从java客户端发送的消息 。。。");
    }
}

