package com.example.room.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.room.APP
import com.example.room.R
import com.example.room.databinding.FragmentDetailBinding
import com.example.room.model.NoteModel

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inite()
    }

    private fun inite() {
        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        val note = arguments?.getSerializable("note") as NoteModel
        binding.apply {
            tvTitleDetail.text = note.title
            tvDescDetail.text = note.description
            btnDetailDelete.setOnClickListener {
                viewModel.delete(note) { }
                APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
            }

            btnDetailBack.setOnClickListener {

                APP.navController.navigate(R.id.action_detailFragment_to_startFragment)

            }
        }
    }

}