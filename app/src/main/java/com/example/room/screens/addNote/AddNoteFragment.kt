package com.example.room.screens.addNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.room.APP
import com.example.room.R
import com.example.room.databinding.FragmentAddNoteBinding
import com.example.room.model.NoteModel

class AddNoteFragment : Fragment() {
    lateinit var binding: FragmentAddNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inite()
    }

    private fun inite() {
        val viewModel = ViewModelProvider(this)[AddNoteViewModel::class.java]
        binding.apply {
            btnAddSave.setOnClickListener {
                val title = etAddTitle.text.toString()
                val description = etAddDescription.text.toString()
                val note = NoteModel(title = title, description = description)
                viewModel.insert(note)
                APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
            }
            btnAddBack.setOnClickListener {
                APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)

            }

        }
    }

}