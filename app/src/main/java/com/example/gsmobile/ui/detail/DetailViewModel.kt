package com.example.gsmobile.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.gsmobile.data.model.Event
import com.example.gsmobile.data.repository.FirebaseService

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val firebaseService = FirebaseService()

    fun addEvent(event: Event) {
        firebaseService.addEvent(event,
            onSuccess = { /* Handle success */ },
            onFailure = { exception -> /* Handle error */ }
        )
    }
}