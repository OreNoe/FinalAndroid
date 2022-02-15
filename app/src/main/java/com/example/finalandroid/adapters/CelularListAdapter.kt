package com.example.finalandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalandroid.R
import com.example.finalandroid.entities.Celular
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class CelularListAdapter(val options: FirestoreRecyclerOptions<Celular>, val listener : OnItemClickListener) :
    FirestoreRecyclerAdapter<Celular, CelularListAdapter.CelularViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelularViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_celular, parent, false)
        return CelularViewHolder(itemView, listener)

    }

    override fun onBindViewHolder(viewHolder: CelularViewHolder, position: Int, celular: Celular) {
        viewHolder.setName(celular.marca)
        viewHolder.celular = celular
    }

    fun interface OnItemClickListener {
        fun onItemClick(celular: Celular)
    }

    class CelularViewHolder(val v: View, val listener: OnItemClickListener) : RecyclerView.ViewHolder(v) {
        lateinit var celular: Celular

        fun setName(name: String) {
            val txt: TextView = v.findViewById(R.id.txt_name_item)
            txt.text = name
        }

        init {
            val boton = v.findViewById<Button>(R.id.btn_info)
            boton.setOnClickListener {
                listener.onItemClick(celular)
            }
        }
    }


}