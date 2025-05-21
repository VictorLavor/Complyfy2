package com.example.senacplanner.Pilares

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.senacplanner.R
import com.example.senacplanner.DatabaseHelper
import android.util.Log


class ListaAtividadesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_atividades)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAtividades)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dbHelper = DatabaseHelper(this)
        val atividades = dbHelper.listarAtividades()

        val adapter = AtividadeAdapter(atividades)
        recyclerView.adapter = adapter

        val btnAdicionarAtividade: Button = findViewById(R.id.btnAdicionarAtividade)
        btnAdicionarAtividade.setOnClickListener {
            startActivity(android.content.Intent(this, CriarAtividadeActivity::class.java))
        }
    }
    override fun onResume() {
        super.onResume()

        val dbHelper = DatabaseHelper(this)
        val atividades = dbHelper.listarAtividades()

        Log.d("Atividades", "Total de atividades: ${atividades.size}")
        atividades.forEachIndexed { index, nome ->
            Log.d("Atividades", "[$index] $nome")
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAtividades)
        recyclerView.adapter = AtividadeAdapter(atividades)
    }

}

