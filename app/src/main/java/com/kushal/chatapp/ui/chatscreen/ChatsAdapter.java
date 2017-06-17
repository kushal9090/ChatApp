package com.kushal.chatapp.ui.chatscreen;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kusha on 6/18/2017.
 */

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatViewHolder> {

    @Override
    public ChatsAdapter.ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ChatsAdapter.ChatViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static  class ChatViewHolder extends RecyclerView.ViewHolder{
        public ChatViewHolder(View itemView) {
            super(itemView);
        }
    }
}
