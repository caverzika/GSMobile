package com.example.gsmobile.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gsmobile.data.model.Event
import com.example.gsmobile.data.repository.FirebaseService

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val firebaseService = FirebaseService()
    private val _events = MutableLiveData<List<Event>>()
    val events: LiveData<List<Event>> get() = _events

    fun loadEvents() {
        firebaseService.getEvents(
            onSuccess = { eventList -> _events.value = eventList },
            onFailure = { exception ->  }
                )
            }

            fun addEvent(event: Event) {
                firebaseService.addEvent(event,
                    onSuccess = { loadEvents() },
                    onFailure = { exception ->  }
                        )
                    }

                    fun deleteEvent(eventId: String) {
                        firebaseService.deleteEvent(eventId,
                            onSuccess = { loadEvents() },
                            onFailure = { exception ->  }
                                )
                            }
                    }