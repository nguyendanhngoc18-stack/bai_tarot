package com.example.mtngtarot

data class TarotCard(
        val id: Int,
        val name: String,
        val imageResId: Int,      // ID của ảnh trong thư mục res/drawable
        val meaning: String,      // Ý nghĩa chung của lá bài
        val prediction: String
    )
