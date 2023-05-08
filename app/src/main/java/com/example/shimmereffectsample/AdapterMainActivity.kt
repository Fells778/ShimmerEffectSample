package com.example.shimmereffectsample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shimmereffectsample.databinding.CustomRecyclerViewBinding
import com.example.shimmereffectsample.helpers.Characters

class AdapterMainActivity(
    private val charactersList: MutableList<Characters> = ArrayList(),
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = CustomRecyclerViewBinding.inflate(LayoutInflater.from(context), parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MainViewHolder -> {
                holder.bind(charactersList[position])
            }
        }
    }

    override fun getItemCount() = charactersList.size

    inner class MainViewHolder(binding: CustomRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val image = binding.imageView
        private val name = binding.textViewName
        private val description = binding.textViewDescription

        fun bind(charactersList: Characters) {
            Glide.with(itemView)
                .load(charactersList.image)
                .placeholder(R.drawable.icons8_loading_sign_48)
                .error(R.drawable.image_not_found__scaled)
                .into(image)
            name.text = charactersList.name
            description.text = charactersList.description
        }
    }
}