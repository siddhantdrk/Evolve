package com.app.evolve.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.evolve.R

class AddSkillsAdapter (val context: Context) : RecyclerView.Adapter<AddSkillsAdapter.ViewHolder>() {
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){

    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.added_skills_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}