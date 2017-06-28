package com.kushal.chatapp.ui.chatscreen.userlist;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kushal.chatapp.R;

import com.kushal.chatapp.ui.chatscreen.models.User;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kusha on 6/28/2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    public ImageView mUserIV;
    public TextView mUSerNameIV;
    public TextView mStatus;

    public UserViewHolder(View itemView) {
        super(itemView);
       mUserIV = (ImageView) itemView.findViewById(R.id.userIV);
        mUSerNameIV = (TextView) itemView.findViewById(R.id.userNameIV);
        mStatus = (TextView) itemView.findViewById(R.id.statusIV);
    }
    public void bindToUser(User user, View.OnClickListener starClickListener) {

    }
}
