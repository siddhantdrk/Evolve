package com.app.evolve.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.evolve.R
import com.app.evolve.adapter.AddExperienceAdapter;
import com.app.evolve.adapter.AddEducationAdapter;
import com.app.evolve.adapter.AddAccomplishmentsAdapter;
import com.app.evolve.adapter.AddAthletesAdapter;
import com.app.evolve.adapter.AddContactAdapter;


class PlayerProfileInfoFragment:Fragment(){

    lateinit var rvExperience : RecyclerView
    lateinit var rvEducation : RecyclerView
    lateinit var rvAccomplishments: RecyclerView
    lateinit var rvAthletes : RecyclerView
    lateinit var rvContact : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player_profile_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvExperience = view.findViewById(R.id.rvExperience)
        rvEducation = view.findViewById(R.id.rvEducation)
        rvAccomplishments = view.findViewById(R.id.rvAccomplishments)
        rvAthletes = view.findViewById(R.id.rvAthletes)
        rvContact = view.findViewById(R.id.rvContact)

        rvExperience.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL ,false)
        rvEducation.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL ,false)
        rvAccomplishments.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL ,false)
        rvAthletes.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL ,false)
        rvContact.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL ,false)

        rvExperience.adapter = AddExperienceAdapter(requireContext())
        rvEducation.adapter = AddEducationAdapter(requireContext())
        rvAccomplishments.adapter = AddAccomplishmentsAdapter(requireContext())
        rvAthletes.adapter = AddAthletesAdapter(requireContext())
        rvContact.adapter = AddContactAdapter(requireContext())
    }
}