package com.app.evolve.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.evolve.R
import kotlinx.android.synthetic.main.athletes_rv_item.view.*

class AthletesRvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.athletes_rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) {
            holder.itemView.TrustedProCv.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}