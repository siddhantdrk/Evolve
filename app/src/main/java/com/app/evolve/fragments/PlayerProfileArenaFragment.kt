package com.app.evolve.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.evolve.R
import com.app.evolve.adapter.AddEducationAdapter
import com.app.evolve.adapter.AddEndorsementsAdapter
import com.app.evolve.adapter.AddSkillsAdapter
import com.app.evolve.adapter.HighlightsRvAdapter
import com.app.evolve.databinding.FragmentPlayerProfileArenaBinding

class PlayerProfileArenaFragment :Fragment() {

    lateinit var binding: FragmentPlayerProfileArenaBinding

    lateinit var rvSkills: RecyclerView
    lateinit var rvEndorsements: RecyclerView
    lateinit var rvPlayingStyle: RecyclerView
    lateinit var rvHighLights: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerProfileArenaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSkills = view.findViewById(R.id.rvSkills)
        rvEndorsements = view.findViewById(R.id.rvEndorsements)
        rvPlayingStyle = view.findViewById(R.id.rvPlayingStyle)
        rvHighLights = view.findViewById(R.id.rvHighlights)

        rvHighLights.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )

        rvSkills.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
        rvEndorsements.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
        rvPlayingStyle.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )

        rvSkills.adapter = AddSkillsAdapter(requireContext())
        rvEndorsements.adapter = AddEndorsementsAdapter(requireContext())
        rvPlayingStyle.adapter = AddEducationAdapter(requireContext())
        rvHighLights.adapter = HighlightsRvAdapter(requireContext())
    }

    override fun onResume() {
        super.onResume()
        binding.root.requestLayout()
    }
}