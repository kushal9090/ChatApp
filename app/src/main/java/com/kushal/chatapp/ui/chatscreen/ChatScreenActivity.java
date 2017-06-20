package com.kushal.chatapp.ui.chatscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kushal.chatapp.R;
import com.kushal.chatapp.ui.chatscreen.models.Chat;

public class ChatScreenActivity extends AppCompatActivity {

    public static final String  EXTRAS_CHAT = "chat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);
        init();
    }

    private void init(){

       setArguments();
        initView();
    }
    private void  initView(){

    }

    private Chat mChat;
    private void setArguments(){
      Bundle bundle = getIntent().getExtras();
      mChat = bundle.getParcelable(EXTRAS_CHAT);

        if (mChat != null){

      setTitle(mChat.getUser().getName());
        }

    }
}
