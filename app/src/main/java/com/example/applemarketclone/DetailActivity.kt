package com.example.applemarketclone

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.applemarketclone.databinding.ActivityDetailBinding
import java.text.DecimalFormat


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private val item: MyItem? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Const.ITEM_OBJECT, MyItem::class.java)
        } else {
            intent.getParcelableExtra<MyItem>(Const.ITEM_OBJECT)
        }
    }

    private val itemPosition: Int by lazy {
        intent.getIntExtra(Const.ITEM_INDEX, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivImage.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(resources, it.image, null)
        })

        binding.tvSeller.text = item?.seller
        binding.tvAddress.text = item?.address
        binding.tvTitle.text = item?.title
        binding.tvPostDetail.text = item?.postDetail
        binding.tvPrice.text = DecimalFormat("#,###").format(item?.price) + "원"

        binding.ivBack.setOnClickListener {
            exit()
        }
    }

    private fun exit() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("itemIndex", itemPosition)
        }
        setResult(RESULT_OK, intent)
        if (!isFinishing) finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        exit()
    }
}