package com.example.applemarketclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarketclone.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MyAdapter(private val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        holder.ivImage.setImageResource(mItems[position].image)
        holder.tvTitle.text = mItems[position].title
        holder.tvAddress.text = mItems[position].address

        val price = mItems[position].price
        holder.tvPrice.text = DecimalFormat("#,###").format(price) + "원"

        holder.tvReplies.text = mItems[position].replies.toString()
        holder.tvLikes.text = mItems[position].likes.toString()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(private val binding: ItemRecyclerviewBinding):RecyclerView.ViewHolder(binding.root) {
        val ivImage = binding.ivImage
        val tvTitle = binding.tvTitle
        val tvAddress = binding.tvAddress
        val tvPrice = binding.tvPrice
        val tvReplies = binding.tvRepliesNum
        val tvLikes = binding.tvLikesNum
    }
}