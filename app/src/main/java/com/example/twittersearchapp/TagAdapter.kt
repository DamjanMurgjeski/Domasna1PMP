package com.example.twittersearchapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView


class TagAdapter(private val tags: MutableList<String>) : RecyclerView.Adapter<TagAdapter.TagViewHolder>() {


    class TagViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val btnTag: Button = view.findViewById(R.id.btnTagName)
        val btnEdit: Button = view.findViewById(R.id.btnEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return TagViewHolder(view)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {

        holder.btnTag.text = tags[position]
    }

    override fun getItemCount(): Int {
        return tags.size
    }
}