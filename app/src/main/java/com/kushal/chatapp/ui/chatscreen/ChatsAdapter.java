package com.kushal.chatapp.ui.chatscreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kushal.chatapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kusha on 6/18/2017.
 */

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatViewHolder> {
    private List<Chat> mChats;
    private Context mContext;

    public ChatsAdapter(Context context ,List<Chat> chats)
    {
        mChats = chats;
        mContext = context;
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
           holder.textView5.setVisibility(View.VISIBLE);
           holder.textView5.setText(chat.getMessage().getUnreadMessageCount());
       }
    }

    @Override
    public int getItemCount() {
        return mChats.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        RelativeLayout chatrLayout;
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
             chatrLayout =(RelativeLayout) itemView.findViewById(R.id.chatrLayout);
             chatrLayout.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

        int position = getAdapterPosition();
        if(position != RecyclerView.NO_POSITION){
         Chat chat = mChats.get(position);
            Intent intent = new Intent(mContext , ChatScreenActivity.class);
            mContext.startActivity(intent);
        }

        }
    }
}
