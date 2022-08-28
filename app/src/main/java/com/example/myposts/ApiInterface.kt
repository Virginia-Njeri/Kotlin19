package com.example.myposts


import org.w3c.dom.Comment
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call
//
interface ApiInterface {
    @GET("/posts")
    fun getPosts():retrofit2.Call<List<Post>>
    @GET("/post/{id}")
    fun getPostsById(@Path("postId")postId:Int): Call<Post>
    @GET("/posts/{postId}/comments")
    fun getComments(@Path("postId")comments:Int):Call<List<Comment>>
}


