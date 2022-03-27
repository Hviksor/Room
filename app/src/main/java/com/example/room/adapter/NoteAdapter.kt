package com.example.room.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.databinding.ItemLayoutBinding
import com.example.room.model.NoteModel
import com.example.room.screens.start.StartFragment

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var listAd = ArrayList<NoteModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<NoteModel>) {
        listAd.clear()
        listAd.addAll(newList)
        notifyDataSetChanged()

    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemLayoutBinding.bind(itemView)
        fun setData(note: NoteModel) {
            binding.itemTitle.text = note.title

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteViewHolder(view)

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = listAd[position]
        holder.setData(note)
    }

    override fun getItemCount(): Int {
        return listAd.size
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickNote(listAd[holder.adapterPosition])

        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}