package com.kushal.chatapp.ui.chatscreen;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kushal.chatapp.R;
import com.kushal.chatapp.ui.chatscreen.models.Chat;
import com.kushal.chatapp.ui.chatscreen.models.Message;
import com.kushal.chatapp.ui.chatscreen.models.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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
    public void onBindViewHolder(ChatViewHolder holder, int position) {

        Chat chat = mChats.get(position);
        User user = chat.getUser();
        Message message = chat.getMessage();

        if(!TextUtils.isEmpty(user.getProfilePicUrl())){

            Picasso.with(holder.userIV.getContext()).load(user.getProfilePicUrl()).into(holder.userIV);
        }

        holder.nameTV.setText(user.getName());
        holder.messageTV.setText(message.getLastMessage());
        holder.lastMessageTimeTV.setText(message.getLastMessageTime());

       if(TextUtils.isEmpty(message.getUnreadMessageCount())){

           holder.textView5.setVisibility(View.GONE);
       }
       else{
           holder.textView5.setText(chat.getMessage().getUnreadMessageCount());
       }
    }

    @Override
    public int getItemCount() {
        return mChats.size();
    }

    public static  class ChatViewHolder extends RecyclerView.ViewHolder{


        CircleImageView userIV;
        TextView nameTV;
        TextView messageTV;
        TextView lastMessageTimeTV;
        TextView textView5;

        public ChatViewHolder(View itemView) {
            super(itemView);

           userIV = (CircleImageView) itemView.findViewById(R.id.userIV);
            nameTV = (TextView) itemView.findViewById(R.id.nameTV);
            messageTV =(TextView) itemView.findViewById(R.id.messageTV);
            lastMessageTimeTV =(TextView) itemView.findViewById(R.id.lastMessageTV);
             textView5 = (TextView) itemView.findViewById(R.id.textView5);

        }
    }
}
