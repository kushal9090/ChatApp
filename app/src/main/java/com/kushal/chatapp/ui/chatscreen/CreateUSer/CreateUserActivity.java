package com.kushal.chatapp.ui.chatscreen.CreateUSer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kushal.chatapp.R;
import com.kushal.chatapp.ui.chatscreen.MainActivity;
import com.kushal.chatapp.ui.chatscreen.models.User;

public class CreateUserActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String tag = CreateUserActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        findViewById(R.id.nextbtn).setOnClickListener(this);
        
        initView();
 }
    private Button mNextButton;
    private EditText mUsernameET;
    private void initView() {
        mNextButton = (Button) findViewById(R.id.nextbtn);
        mUsernameET = (EditText) findViewById(R.id.userNameET);
        mNextButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nextbtn:
                onNextButtonClicked();
                break;
        }

    }
    String mUserName;
    private void onNextButtonClicked() {
        mUserName = mUsernameET.getText().toString();
        if (!TextUtils.isEmpty(mUserName)) {
            createUser();
        } else {
            Toast.makeText(this, "User name can not be blank", Toast.LENGTH_LONG).show();
        }
    }
   private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private void createUser() {
      mAuth = FirebaseAuth.getInstance();
        String email = mUserName + "@gmail.com";
        mAuth.createUserWithEmailAndPassword(email , mUserName).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                  if(task.isSuccessful()){
                      hideProgressDialog();


                      Toast.makeText(CreateUserActivity.this , "Successful...." , Toast.LENGTH_LONG).show();
                      onAuthSuccess(task.getResult().getUser());
                      return;

                  }else{
                      try {
                          Exception e = task.getException();
                          e.printStackTrace();
                          Log.d("exception:", e.getMessage());
                          Toast.makeText(CreateUserActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                      } catch (Exception e) {
                          e.printStackTrace();
                          Log.d("exception:", e.getMessage());
                      }

                  }

            }
        });

    }

    private void onAuthSuccess(FirebaseUser firebaseUser) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        User user = new User();
        user.setName(usernameFromEmail(firebaseUser.getEmail()));
        mDatabase.child("users").child(firebaseUser.getUid()).setValue(user);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }


}
