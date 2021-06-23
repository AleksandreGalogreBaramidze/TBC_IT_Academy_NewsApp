package com.example.newsapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.databinding.ItemBinding
import com.example.newsapplication.extension.loadImage
import com.example.newsapplication.model.SpaceNewsModel

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    val data: MutableList<SpaceNewsModel> = mutableListOf()
    private lateinit var spaceNewsModel: SpaceNewsModel
    fun dataSetter(data: MutableList<SpaceNewsModel>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }
    override fun getItemCount() = data.size
    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind() {
            spaceNewsModel = data[adapterPosition]
            binding.NewsImageView.loadImage(spaceNewsModel.imageUrl)
            binding.NewsDateTextView.text = spaceNewsModel.updatedAt
            binding.NewsTitleTextView.text = spaceNewsModel.title
            binding.NewsDescriptionTextView.text = spaceNewsModel.summary
            if (spaceNewsModel.providers?.isNotEmpty() == true) {
                binding.NewsTimelineTextvIew.text = spaceNewsModel.providers?.elementAt(adapterPosition)?.provider
            } else {
                binding.NewsTimelineTextvIew.text = "Nothing To Say"
            }
        }
    }
}