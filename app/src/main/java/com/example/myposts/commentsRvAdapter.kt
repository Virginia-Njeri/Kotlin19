package com.example.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.CommentListItemBinding


class commentsRvAdapter (var comments:List<Comment>):RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding = CommentListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CommentsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment =comments.get(position)
        with(holder.binding){
            tvpostId.text = currentComment.postId.toString()
            tvId.text = currentComment.id.toString()
            tvpostId.text = currentComment.name
            tvpostId.text = currentComment.email
            tvpostId.text = currentComment.body

        }

    }

    override fun getItemCount(): Int {
        return comments.size
    }

}


class CommentsViewHolder(val binding: CommentListItemBinding):RecyclerView.ViewHolder(binding.root)