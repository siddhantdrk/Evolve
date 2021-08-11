package com.app.evolve.adapter.AddVibesAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.evolve.R
import android.view.ViewGroup as ViewGroup1

class AddVibesAdapter (val context: Context) : RecyclerView.Adapter<AddVibesAdapter.ViewHolder>() {
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){

    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return 5
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.interests_items, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}