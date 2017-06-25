package com.kushal.chatapp.ui.chatscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kushal.chatapp.R;

/**
 * Created by kusha on 6/25/2017.
 */

public class ChatScreenFragment extends Fragment {

  public static ChatScreenFragment newInstance(){
      Bundle argument = new Bundle();
      ChatScreenFragment chatScreenFragment = new ChatScreenFragment();
      chatScreenFragment.setArguments(argument);
      return chatScreenFragment;

  }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_chatscreen, container , false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
