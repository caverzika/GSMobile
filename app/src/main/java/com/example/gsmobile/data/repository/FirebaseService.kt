package com.example.gsmobile.data.repository

import com.example.gsmobile.data.model.Event
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseService {
    private val db = FirebaseFirestore.getInstance()
    private val eventsCollection = db.collection("events")

    fun addEvent(event: Event, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        event.id = eventsCollection.document().id
        eventsCollection.document(event.id).set(event)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { exception -> onFailure(exception) }
    }

    fun getEvents(onSuccess: (List<Event>) -> Unit, onFailure: (Exception) -> Unit) {
        eventsCollection.get()
            .addOnSuccessListener { result ->
                val events = result.map { document -> document.toObject(Event::class.java) }
                onSuccess(events)
            }
            .addOnFailureListener { exception -> onFailure(exception) }
    }

    fun deleteEvent(eventId: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        eventsCollection.document(eventId).delete()
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { exception -> onFailure(exception) }
    }
}