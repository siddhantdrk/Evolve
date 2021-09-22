package com.app.evolve

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.evolve.adapter.AddVibesAdapter.AddVibesAdapter

class AddVides : AppCompatActivity() {

    private lateinit var rvExplore : RecyclerView
    lateinit var rvAmericanSport : RecyclerView
    lateinit var rvHangout : RecyclerView
    lateinit var rvNature : RecyclerView
    lateinit var rvShopping : RecyclerView
    lateinit var rvOther : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vibes)

        rvExplore  =findViewById(R.id.rvExplore)
        rvAmericanSport = findViewById(R.id.rvAmericanSport)
        rvHangout  =findViewById(R.id.rvHangout)
        rvNature  =findViewById(R.id.rvNature)
        rvShopping  =findViewById(R.id.rvShopping)
        rvOther  =findViewById(R.id.rvOther)

        rvExplore.layoutManager = GridLayoutManager(this, 3)
        rvAmericanSport.layoutManager = GridLayoutManager(this, 3)
        rvHangout.layoutManager = GridLayoutManager(this, 3)
        rvNature.layoutManager = GridLayoutManager(this, 3)
        rvShopping.layoutManager = GridLayoutManager(this, 3)
        rvOther.layoutManager = GridLayoutManager(this, 3)

        rvExplore.adapter = AddVibesAdapter(this@AddVides)
        rvAmericanSport.adapter = AddVibesAdapter(this@AddVides)
        rvHangout.adapter = AddVibesAdapter(this@AddVides)
        rvNature.adapter = AddVibesAdapter(this@AddVides)
        rvShopping.adapter = AddVibesAdapter(this@AddVides)
        rvOther.adapter = AddVibesAdapter(this@AddVides)
    }
}