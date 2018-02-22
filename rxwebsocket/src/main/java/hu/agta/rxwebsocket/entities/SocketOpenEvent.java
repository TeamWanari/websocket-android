package hu.agta.rxwebsocket.entities;


import hu.agta.rxwebsocket.SocketEventTypeEnum;
import okhttp3.Response;
import okhttp3.WebSocket;

public class SocketOpenEvent extends SocketEvent {

    private WebSocket webSocket;
    private Response response;

    public SocketOpenEvent(WebSocket webSocket, Response response) {
        super(SocketEventTypeEnum.OPEN);
        this.webSocket = webSocket;
        this.response = response;
    }

    public WebSocket getWebSocket() {
        return webSocket;
    }

    public Response getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "SocketOpenEvent{" +
                "webSocket=" + webSocket +
                ", response=" + response.toString() +
                '}';
    }
}
