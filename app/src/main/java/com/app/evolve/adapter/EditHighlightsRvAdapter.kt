package com.app.evolve.adapter

import android.content.Context
import android.view.*
import android.widget.PopupWindow
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.evolve.R
import kotlinx.android.synthetic.main.edit_highlights_rv_item.view.*

class EditHighlightsRvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.edit_highlights_rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.edit_inside_highlight_rv.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.VERTICAL, false)
        holder.itemView.edit_inside_highlight_rv.adapter = EditInsideHighlightsRvAdapter()
        holder.itemView.highlightAddIv.setOnClickListener {
            val popUp = showAlertFilter(holder.itemView.context)
            popUp.isOutsideTouchable = true
            if (!popUp.isShowing) {
                popUp.showAsDropDown(holder.itemView.highlightAddIv, 0, 20, Gravity.END)
//                dimBehind(popUp)
            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    private fun showAlertFilter(context: Context): PopupWindow {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.add_highlights_item_pop_up, null)
        return PopupWindow(
            view,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }


    private fun dimBehind(popupWindow: PopupWindow) {
        val container = popupWindow.contentView.rootView
        val context = popupWindow.contentView.context
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val p = container.layoutParams as WindowManager.LayoutParams
        p.flags = p.flags or WindowManager.LayoutParams.FLAG_DIM_BEHIND
        p.dimAmount = 0.8f
        wm.updateViewLayout(container, p)
    }
}