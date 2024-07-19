package com.example.applemarketclone

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarketclone.databinding.ItemRecyclerviewBinding

class MyAdapter(
    private val mItems: List<MyItem>,
    private val onItemClicked: (MyItem, Int) -> Unit) : RecyclerView.Adapter<MyAdapter.Holder>() {

    companion object {
        private const val TAG = "MyAdapter"
    }

    inner class Holder(private val binding: ItemRecyclerviewBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:MyItem){
            Log.d(TAG, "Holder bind() $item")
            binding.apply {
            ivImage.setImageResource(item.image)
            tvTitle.text = item.title
            tvAddress.text = item.address
            tvPrice.text = item.price
            tvRepliesNum.text = item.replies.toString()
            tvLikesNum.text = item.likes.toString()
            tvSeller.text = item.seller
            tvPostDetail.text = item.postDetail

                root.setOnClickListener {
                    onItemClicked(item, adapterPosition)
                }
            }

//            binding.itemViewLayout.setOnClickListener {
//                itemLongClickListener(item, adapterPosition)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.d(TAG, "onCreateViewHolder")
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MyAdapter.Holder, position: Int) {
        Log.d(TAG, "onBindViewHolder position: $position")
        holder.bind(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }
}