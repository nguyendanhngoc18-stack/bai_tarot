package com.example.mtngtarot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(
    private val cards: List<TarotCard>
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCardItem: ImageView = itemView.findViewById(R.id.imgCardItem)
        val tvCardName: TextView = itemView.findViewById(R.id.tvCardName)
        val tvCardMeaning: TextView = itemView.findViewById(R.id.tvCardMeaning)
        val tvCardPrediction: TextView = itemView.findViewById(R.id.tvCardPrediction)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]
        holder.imgCardItem.setImageResource(card.imageResId)
        holder.tvCardName.text = card.name
        holder.tvCardMeaning.text = card.meaning
        holder.tvCardPrediction.text = card.prediction
    }

    override fun getItemCount(): Int = cards.size
}
