package hu.agta.rxwebsocket;

import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import hu.agta.rxwebsocket.entities.SocketMessageEvent;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<Pair<String, String>> messages = new ArrayList<>();
    private SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pair<String, String> pair = messages.get(position);
        holder.timeStamp.setText(pair.first);
        holder.text.setText(pair.second);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public void addMessage(SocketMessageEvent event) {
        messages.add(new Pair<>(simpleDateFormat.format(new Date()), event.getText()));
        notifyItemInserted(messages.size() - 1);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView timeStamp;
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            timeStamp = itemView.findViewById(R.id.messageTimeStamp);
            text = itemView.findViewById(R.id.text);
        }
    }
}
