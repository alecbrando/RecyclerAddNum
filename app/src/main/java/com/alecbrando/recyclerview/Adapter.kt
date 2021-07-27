package com.alecbrando.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alecbrando.recyclerview.databinding.ViewHolderBinding


class Adapter(private val listener: clickListener) : ListAdapter<Int,Adapter.ViewHolder>(DiffCallBack()){

    inner class ViewHolder(private val binding: ViewHolderBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    listener.itemClicked(getItem(position))
                }
            }
        }

        fun binding(num : Int){
            binding.apply {
                listItem.text = num.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(getItem(position))
    }

    interface clickListener {
        fun itemClicked(num: Int)
    }


    class DiffCallBack : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem
        }

    }
