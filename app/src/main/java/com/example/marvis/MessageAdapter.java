package com.example.marvis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    private List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (message != null) {
            if (Message.SENT_BY_ME.equals(message.getSentBy())) {
                holder.leftChatView.setVisibility(View.GONE);
                holder.rightChatView.setVisibility(View.VISIBLE);
                holder.rightTextView.setText(message.getMessage());
            } else {
                holder.rightChatView.setVisibility(View.GONE);
                holder.leftChatView.setVisibility(View.VISIBLE);
                holder.leftTextView.setText(message.getMessage());
            }
        }
    }

    @Override
    public int getItemCount() {
        return messageList != null ? messageList.size() : 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftChatView;
        LinearLayout rightChatView;
        TextView leftTextView;
        TextView rightTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            leftChatView = itemView.findViewById(R.id.left_chat_view);
            rightChatView = itemView.findViewById(R.id.right_chat_view);
            leftTextView = itemView.findViewById(R.id.left_chat_text_view);
            rightTextView = itemView.findViewById(R.id.right_chat_text_view);
        }
    }
}
