package com.example.foodapp.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemHomeBinding
import com.example.foodapp.domain.RecipeCardModel

class HomeViewAdapter(
    data: List<RecipeCardModel>,
    private val onClick: (Int, List<RecipeCardModel>) -> Unit,
    private val onClickCard: (RecipeCardModel) -> Unit
) :
    RecyclerView.Adapter<HomeViewAdapter.CardViewHolder>() {
    private var list: List<RecipeCardModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class CardViewHolder(
        val binding: ItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeBinding.inflate(inflater, parent, false)

        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = list[position]

        holder.binding.ivImage.setImageResource(item.image)
        holder.binding.tvTitle.setText(item.title)
        holder.binding.tvGroup.setText(item.group)
        holder.binding.tvTime.text = "${item.time} min."
        holder.binding.btnFavourite.setImageResource(item.favourite)
        holder.binding.btnFavourite.setOnClickListener {
            if (item.favourite == R.drawable.icon_favourites_false) {
                Log.d("test", "sdfsd")
                item.favourite = R.drawable.icon_favourite_true
                onClick(position, list)
            } else {
                item.favourite = R.drawable.icon_favourites_false
                onClick(position, list)
            }
        }
        holder.binding.ivImage.setOnClickListener {
            onClickCard(list[position])
        }
    }
}

