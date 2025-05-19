package com.example.senacplanner.Pilares

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.senacplanner.DatabaseHelper
import com.example.senacplanner.R


class ListaAtividadesActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAtividades)
    recyclerView.layoutManager = LinearLayoutManager(this)

    val dbHelper = DatabaseHelper(this)
    val atividades = dbHelper.listarAtividades() // método que vamos criar

    val adapter = AtividadeAdapter(atividades)
    recyclerView.adapter = adapter

}
