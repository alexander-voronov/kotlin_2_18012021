package ru.geekbrains.kotlin_2_18012021.data.provider

import com.google.firebase.firestore.FirebaseFirestore

private const val NOTES_COLLECTION = "notes"

class FireStoreProvider {
    private val TAG = "${FireStoreProvider::class.java.simpleName} :"
    private val db = FirebaseFirestore.getInstance()
    private val notesReference = db.collection(NOTES_COLLECTION)
}