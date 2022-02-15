package com.example.finalandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalandroid.R
import com.example.finalandroid.adapters.CelularListAdapter
import com.example.finalandroid.entities.Celular
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ListFragment : Fragment(), CelularListAdapter.OnItemClickListener {
    val db = Firebase.firestore
    private lateinit var v : View

    private var celularArrayList : ArrayList<Celular> = arrayListOf()
    private lateinit var btnAdd : FloatingActionButton
    private lateinit var recCelulares : RecyclerView

    lateinit var adapter : CelularListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val query : CollectionReference = db.collection("celulares")
        val options = FirestoreRecyclerOptions.Builder<Celular>()
            .setQuery(query, Celular::class.java)
            .build()

        adapter = CelularListAdapter(options, this)
        recCelulares.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_list, container, false)
        btnAdd = v.findViewById(R.id.btn_add)

        recCelulares = v.findViewById(R.id.recyclerView)
        recCelulares.setHasFixedSize(true)
        recCelulares.adapter = adapter
        recCelulares.layoutManager = LinearLayoutManager(context)
        return v
    }

    override fun onItemClick(celular: Celular) {
        val action = ListFragmentDirections.actionListFragmentToinfoFragment(celular)
        v.findNavController().navigate(action)
    }
}