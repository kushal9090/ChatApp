package com.kushal.chatapp.ui.chatscreen;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.kushal.chatapp.R;
import com.kushal.chatapp.ui.chatscreen.models.Chat;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatScreenActivity extends AppCompatActivity {

    public static final String  EXTRAS_CHAT = "chat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();
    }

    private void init(){

       setArguments();
        initView();
    }
    private void  initView(){
      initToolbar();
      showFragment();
    }

    private void showFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout , ChatScreenFragment.newInstance());
        ft.commit();

    }

    private Chat mChat;
    private void setArguments(){
      Bundle bundle = getIntent().getExtras();
      mChat = bundle.getParcelable(EXTRAS_CHAT);

        if (mChat != null){

      setTitle(mChat.getUser().getName());
        }

    }
    private void initToolbar(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView nameTV = (TextView) findViewById(R.id.nameTV);
        nameTV.setText(mChat.getUser().getName());

        CircleImageView userIV = (CircleImageView) findViewById(R.id.userIV);
        Picasso.with(this).load(mChat.getUser().getProfilePicUrl()).into(userIV);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Toolbar","Clicked");
            }
        });



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat , menu);
        return true;
    }
}
