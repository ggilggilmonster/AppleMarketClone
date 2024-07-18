package com.example.applemarketclone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applemarketclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dataList = mutableListOf<MyItem>().apply {
            add(MyItem(R.drawable.sample1, "산진 한달된 선풍기 팝니다", "서울 서대문구 창천동", "1,000원"))
            add(MyItem(R.drawable.sample2, "김치 냉장고", "인천 계양구 귤현동", "20,000원"))
            add(MyItem(R.drawable.sample3, "샤넬 카드지갑", "수성구 범어동", "10,000원"))
            add(MyItem(R.drawable.sample4, "금고", "해운대구 우제2동", "10,000원"))
            add(MyItem(R.drawable.sample5, "갤럭시Z플립3 팝니다", "연제구 연산제8동", "150,000원"))
            add(MyItem(R.drawable.sample6, "프라다 복조리백", "수원시 영통구 원천동", "50,000원"))
            add(MyItem(R.drawable.sample7, "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장", "남구 옥동", "150,000원"))
            add(MyItem(R.drawable.sample8, "샤넬 탑핸들 가방", "동래구 온천제2동", "180,000원"))
            add(MyItem(R.drawable.sample9, "4행정 엔진분무기 판매합니다.", "원주시 명륜2동", "30,000원"))
            add(MyItem(R.drawable.sample10, "셀린느 버킷 가방", "중구 동화동", "190,000원"))
        }

        adapter = MyAdapter(dataList,
            itemClickListener = { item, position ->
                Toast.makeText(this, "${item.title} clicked", Toast.LENGTH_SHORT).show()
            })

        binding.apply {
            recyclerList.adapter = adapter
            recyclerList.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}