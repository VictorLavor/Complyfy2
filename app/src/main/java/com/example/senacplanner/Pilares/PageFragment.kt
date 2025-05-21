package com.example.senacplanner.Pilares

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.senacplanner.DatabaseHelper
import com.example.senacplanner.R

class PageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewAtividades)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val dbHelper = DatabaseHelper(requireContext())
        val atividades = dbHelper.listarAtividades()

        recyclerView.adapter = AtividadeAdapter(atividades)
    }
}




