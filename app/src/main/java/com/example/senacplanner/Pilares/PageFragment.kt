package com.example.senacplanner.Pilares

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.example.senacplanner.R
import com.example.senacplanner.DatabaseHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager



override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewAtividades)
    recyclerView.layoutManager = LinearLayoutManager(requireContext())

    val dbHelper = DatabaseHelper(requireContext())
    val atividades = dbHelper.listarAtividades()

    recyclerView.adapter = AtividadeAdapter(atividades)
}



