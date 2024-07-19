package com.example.applemarketclone

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applemarketclone.databinding.ActivityDetailBinding

@Parcelize
data class MyItem(val image: Int, var title: String, val address: String, val price: String, val seller: String, val postDetail: String, val replies: Int, val likes: Int) : Parcelable

annotation class Parcelize

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val item = intent.getParcelableExtra<MyItem>("item")
        item?.let {
            binding.ivImage.setImageResource(it.image)
            binding.tvTitle.text = it.title
            binding.tvAddress.text = it.address
            binding.tvPrice.text = it.price
            binding.tvSeller.text = it.seller
            binding.tvPostDetail.text = it.postDetail
        }

        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}