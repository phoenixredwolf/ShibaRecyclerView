package com.example.shibarecyclerview.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.shibarecyclerview.R


class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        recyclerView = view.findViewById(R.id.recycler)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shibaData.observe(viewLifecycleOwner, Observer
        {
            val adapter = MainRecyclerAdapter(requireContext(), it)
            recyclerView.adapter = adapter
        })

        return inflater.inflate(R.layout.main_fragment, container, false)
    }


}