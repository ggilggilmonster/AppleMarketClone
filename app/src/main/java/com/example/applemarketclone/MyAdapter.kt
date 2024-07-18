package com.example.applemarketclone

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarketclone.databinding.ItemRecyclerviewBinding

class MyAdapter(
    private val mItems: List<MyItem>,
    private val itemClickListener: (MyItem, Int) -> Unit
) : RecyclerView.Adapter<MyAdapter.Holder>() {

    companion object {
        private const val TAG = "MyAdapter"
    }

    inner class Holder(private val binding: ItemRecyclerviewBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:MyItem){
            Log.d(TAG, "Holder bind() $item")
            binding.iconItem.setImageResource(item.image)
            binding.tvTitle.text = item.title
            binding.tvAddress.text = item.address
            binding.tvPrice.text = item.price

            binding.itemViewLayout.setOnClickListener {
                Log.d(TAG, "itemViewLayout clicked position: ${item.title}")
                itemClickListener(item, adapterPosition)
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