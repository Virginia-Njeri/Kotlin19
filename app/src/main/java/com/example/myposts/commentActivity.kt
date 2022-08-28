package com.example.myposts


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myposts.databinding.ActivityDisplayBinding
import com.example.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class commentActivity : AppCompatActivity() {
    lateinit var binding: ActivityDisplayBinding
    var postId= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
         obtainPostID()
         fetchPostId()
        fetchComments()
    }
    fun obtainPostID(){
        postId = intent.extras?.getInt("POST_ID")?:0
    }

    fun fetchPostId(){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostsById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post = response.body()
                    binding.tvPostBody.text = post?.body
                    binding.tvPostTitle.text = post?.title

                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }

    fun fetchComments(){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getComments(postId)
        request.enqueue(object:Callback<List<Comment>>{
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
              if (response .isSuccessful){
                  var comment = response.body()
                  binding.rvcomments.adapter = comment?.let { commentsRvAdapter(it) }
                  binding.rvcomments.layoutManager = LinearLayoutManager(baseContext)
              }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_SHORT).show()

            }

        })
    }
}

