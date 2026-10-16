package com.example.mtngtarot

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CardListActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var rvCardList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card_list)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainCardList)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBack = findViewById(R.id.btnBack)
        rvCardList = findViewById(R.id.rvCardList)

        btnBack.setOnClickListener {
            finish()
        }

        rvCardList.layoutManager = LinearLayoutManager(this)
        rvCardList.adapter = CardAdapter(TarotRepository.cards)
    }
}
