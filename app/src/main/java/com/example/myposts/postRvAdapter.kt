package com.example.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.PostListItemBinding
import org.w3c.dom.Comment

class PostRvAdapter(var postList: List<Post>) :
    RecyclerView.Adapter<RetrofitViewHolder>() {

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)
        with(holder.bindingView) {
            tvID.text = currentItem.id.toString()
            tvUserId.text = currentItem.userId.toString()
            tvTitle.text = currentItem.title
            tvBody.text = currentItem.body
            val context = holder.itemView.context
            holder.bindingView.cvPost.setOnClickListener {
                val intent = Intent(context,Comment::class.java)
               intent.putExtra("POST_ID",currentItem.id)
                context.startActivity(intent)
            }

        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RetrofitViewHolder(binding)
    }
}

class RetrofitViewHolder(var bindingView: PostListItemBinding) : RecyclerView.ViewHolder(bindingView.root)