package hu.agta.websocket.library;


import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import hu.agta.websocket.library.entities.SocketEvent;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.ws.RealWebSocket;

public class WebSocketOnSubscribe implements FlowableOnSubscribe<SocketEvent> {

    private final OkHttpClient client;
    private final Request request;

    public WebSocketOnSubscribe(@NonNull String url) {
        client = new OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .build();

        request = new Request.Builder()
                .url(url)
                .build();
    }

    public WebSocketOnSubscribe(@NonNull OkHttpClient client, @NonNull String url) {
        this.client = client;
        request = new Request.Builder()
                .url(url)
                .build();
    }

    @Override
    public void subscribe(FlowableEmitter<SocketEvent> emitter) throws Exception {
        client.newWebSocket(request, new WebSocketEventRouter(emitter));
    }
}

