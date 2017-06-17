package com.kushal.chatapp.ui.chatscreen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kushal.chatapp.R;
import com.kushal.chatapp.ui.chatscreen.models.Chat;

import java.util.List;

/**
 * Created by kusha on 6/18/2017.
 */

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatViewHolder> {
    private List<Chat> mChats;

    public ChatsAdapter(List<Chat> chats) {
        mChats = chats;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chats , parent ,false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatsAdapter.ChatViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mChats.size();
    }

    public static  class ChatViewHolder extends RecyclerView.ViewHolder{
        public ChatViewHolder(View itemView) {
            super(itemView);
        }
    }
}
