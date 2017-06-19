package com.kushal.chatapp.ui.chatscreen.models;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vihaan on 21/05/17.
 */

public interface ApiInterface {

    @GET("https://api.myjson.com/bins/gi0dj")
    Call<ArrayList<Chat>> getChats();
}
