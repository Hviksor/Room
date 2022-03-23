package com.example.room.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.databinding.ItemLayoutBinding
import com.example.room.model.NoteModel

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private val listAd = ArrayList<NoteModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return listAd.size
    }


    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemLayoutBinding.bind(itemView)
        fun setData(item: NoteModel) {
            binding.itemTitle.text = item.title
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newlists: ArrayList<NoteModel>) {
        listAd.clear()
        listAd.addAll(newlists)
        notifyDataSetChanged()
    }
}