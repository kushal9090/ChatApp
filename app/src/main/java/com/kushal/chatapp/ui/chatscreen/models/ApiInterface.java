package com.kushal.chatapp.ui.chatscreen.models;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vihaan on 21/05/17.
 */

public interface ApiInterface {

   // @GET("https://api.myjson.com/bins/18j0iz")
   // https://api.myjson.com/bins/1eh55t
    @GET("https://api.myjson.com/bins/ilabv")
    Call<ArrayList<Chat>> getChats();
}
