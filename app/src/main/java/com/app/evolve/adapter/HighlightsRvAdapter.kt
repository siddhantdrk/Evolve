package com.app.evolve.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.evolve.R
import kotlinx.android.synthetic.main.highlights_rv_item.view.*

class HighlightsRvAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.highlights_rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.insideHighlightsRv.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL, false
        )
        holder.itemView.insideHighlightsRv.adapter = InsideHighlightsRvAdapter(context)
    }

    override fun getItemCount(): Int {
        return 2
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}