package com.example.gsmobile.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.gsmobile.R
import com.example.gsmobile.data.model.Event
import com.example.gsmobile.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.saveButton.setOnClickListener {
            val event = Event(
                name = binding.nameEditText.text.toString(),
                location = binding.locationEditText.text.toString(),
                date = binding.dateEditText.text.toString(),
                description = binding.descriptionEditText.text.toString()
            )
            detailViewModel.addEvent(event)
        }

        return binding.root
    }
}