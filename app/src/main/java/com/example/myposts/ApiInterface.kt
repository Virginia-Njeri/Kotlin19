package com.example.myposts


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call
//
interface ApiInterface {
    @GET("/posts")
    fun getPosts():retrofit2.Call<List<Post>>
    @GET("/post/{id}")
    fun getPostsById(@Path("postId")postId:Int): Call<Post>

}

