package com.alecbrando.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alecbrando.recyclerview.databinding.ViewHolderBinding


class Adapter(private var list: MutableList<Int>) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(private val binding: ViewHolderBinding) : RecyclerView.ViewHolder(binding.root) {

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
        holder.binding(list[position])
    }



    override fun getItemCount() = list.size

}