package com.example.primerparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetalleReceta : AppCompatActivity() {
    private lateinit var tvNombreReceta: TextView
    private lateinit var tvIngredientes: TextView
    private lateinit var imPlato: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receta)

        val receta = intent.getParcelableExtra<Receta>("receta")

        tvNombreReceta = findViewById(R.id.tvNombreReceta)
        tvIngredientes = findViewById(R.id.tvIngredientes)
        imPlato = findViewById(R.id.imPlato)

        tvNombreReceta.text = receta?.nombre
        tvIngredientes.text = receta?.ingredientes

        Glide.with(this).load(receta?.plato).centerCrop().into(imPlato)

    }
}