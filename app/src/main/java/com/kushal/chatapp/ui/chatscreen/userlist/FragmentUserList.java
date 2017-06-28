package com.kushal.chatapp.ui.chatscreen.userlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.kushal.chatapp.R;
import com.kushal.chatapp.ui.chatscreen.Database;
import com.kushal.chatapp.ui.chatscreen.models.User;

/**
 * Created by kusha on 6/28/2017.
 */

public class FragmentUserList extends Fragment {
    public static FragmentUserList newInstance(){

        Bundle args = new Bundle();
        FragmentUserList fragment = new FragmentUserList();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View view = inflater.inflate(R.layout.fragment_user_list , container , false);
        return view ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        getUsers();

    }



    private void initViews() {
        initRecyclerViewI();
    }


    private RecyclerView mRecyclerview;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<User , UserViewHolder> mAdapter;
    private void initRecyclerViewI() {
     mRecyclerview = (RecyclerView) getView().findViewById(R.id.usersRecyclerView);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

    }


    private void getUsers() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Query userQuery = mDatabase.child(Database.NODE_USERS);

        mAdapter = new FirebaseRecyclerAdapter<User, UserViewHolder>(User.class , R.layout.item_user_list , UserViewHolder.class , userQuery) {
            @Override
            protected void populateViewHolder(final UserViewHolder viewHolder,final User model,final int position) {
                  final DatabaseReference postRef = getRef(position);
                  final String postKey = postRef.getKey();
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                viewHolder.bindToUser(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View starView) {

                    }
                });
            }
        };
      mRecyclerview.setAdapter(mAdapter);
    }
}
