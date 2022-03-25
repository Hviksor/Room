package com.example.room.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.room.APP
import com.example.room.R
import com.example.room.adapter.NoteAdapter
import com.example.room.databinding.FragmentStartBinding
import com.example.room.model.NoteModel

class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inite()
        binding.btNext.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }

    private fun inite() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        recyclerView = binding.rcView
        adapter = NoteAdapter()
        recyclerView.adapter = adapter

        viewModel.getDatabase()
        viewModel.getAllNotes().observe(viewLifecycleOwner) { noteList ->
            noteList.asReversed()
            adapter.updateAdapter(noteList as ArrayList<NoteModel>)
        }


    }

}