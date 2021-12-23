package com.app.evolve

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_player_profile_about_edit1.*

class PlayerProfileAboutEdit1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_player_profile_about_edit1)
        aboutTie.setHint(R.string.let_the_community_know_who_you_are_without_the_athlete_identity_we_are_all_champions_mvps_and_top_scorers_here)
    }
}