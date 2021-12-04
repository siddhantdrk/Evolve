package com.app.evolve

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.evolve.adapter.EditHighlightsRvAdapter
import kotlinx.android.synthetic.main.fragment_player_profile_edit_highlights.*

class PlayerProfileEditHighlightsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_player_profile_edit_highlights)
        editHighlightsRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        editHighlightsRv.adapter = EditHighlightsRvAdapter()
    }
}