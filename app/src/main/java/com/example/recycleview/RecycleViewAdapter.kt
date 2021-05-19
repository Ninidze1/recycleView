package com.example.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recycleview.databinding.ItemLayoutBinding

class RecycleViewAdapter(private val items: MutableList<ItemModel>, var clickedListener: onCarItemClickedListener): RecyclerView.Adapter<RecycleViewAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: ItemModel

        fun bind() {
            model = items[adapterPosition]
            val url: String? = model.url

            Glide.with(binding.imageView.context)
                .load(url)
                .centerCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(binding.imageView)

            binding.title.text = model.title
            binding.turboCharged.text = model.turboCharged
            binding.engine.text = model.engine
            binding.horsePower.text = model.horsePower
        }

        fun initialize(model: ItemModel, action: onCarItemClickedListener) {
            itemView.setOnClickListener {
                action.onItemClick(model, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemView = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
        holder.initialize(items.get(position), clickedListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

interface onCarItemClickedListener {
    fun onItemClick(model: ItemModel, position: Int)
}