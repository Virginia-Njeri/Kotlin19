package com.example.myposts

import android.telecom.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/post")
    fun getPosts():retrofit2.Call<List<Post>>



}