package com.example.mtngtarot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imgCard: ImageView
    private lateinit var tvCardTitle: TextView
    private lateinit var tvCardKeywords: TextView
    private lateinit var tvCardDescription: TextView
    private lateinit var btnDrawCard: Button
    private lateinit var btnCardList: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        // Binding views
        imgCard = findViewById(R.id.imgCard)
        tvCardTitle = findViewById(R.id.tvCardTitle)
        tvCardKeywords = findViewById(R.id.tvCardKeywords)
        tvCardDescription = findViewById(R.id.tvCardDescription)
        btnDrawCard = findViewById(R.id.btnDrawCard)
        btnCardList = findViewById(R.id.btnCardList)


        // rút bài
        btnDrawCard.setOnClickListener {
            drawRandomCard()
        }

        // Mở màn hình danh sách thẻ bài
        btnCardList.setOnClickListener {
            val intent = Intent(this, CardListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun drawRandomCard() {
        val cardsList = TarotRepository.cards
        if (cardsList.isNotEmpty()) {
            val randomCard = cardsList.random()
            displayCard(randomCard)
        }
    }

    private fun displayCard(card: TarotCard) {
        imgCard.setImageResource(card.imageResId)
        tvCardTitle.text = card.name
        tvCardKeywords.text = card.meaning
        tvCardDescription.text = card.prediction
    }

}