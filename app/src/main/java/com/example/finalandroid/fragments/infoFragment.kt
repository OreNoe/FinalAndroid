package com.example.finalandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.finalandroid.R

class infoFragment : Fragment() {
    lateinit var v: View
    lateinit var txtModelo: TextView
    lateinit var txtMarca: TextView
    lateinit var txtTamano: TextView
    lateinit var imgCelular: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_info, container, false)
        txtMarca = v.findViewById(R.id.txtMarca)
        txtModelo = v.findViewById(R.id.txtModelo)
        txtTamano = v.findViewById(R.id.txtTamaño)
        imgCelular = v.findViewById(R.id.imgFrag2)

        // Inflate the layout for this fragment
        return v
    }

    override fun onStart() {
        super.onStart()
        val celularesList = infoFragmentArgs.fromBundle(requireArguments()).celular
        txtMarca.text = celularesList.marca
        txtModelo.text = celularesList.modelo
        txtTamano.text = celularesList.tamano.toString()
        Glide
            .with(this)
            .load(celularesList.urlImage)
            .into(imgCelular)
    }
}