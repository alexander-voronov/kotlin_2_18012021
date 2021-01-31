package ru.geekbrains.kotlin_2_18012021.ui.note

import androidx.lifecycle.ViewModel
import ru.geekbrains.kotlin_2_18012021.data.model.Note
import ru.geekbrains.kotlin_2_18012021.data.model.Repository

class NoteViewModel(private val repository: Repository = Repository) :
    ViewModel() {
    private var pendingNote: Note? = null
    fun saveChanges(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        if (pendingNote != null) {
            repository.saveNote(pendingNote!!)
        }
    }
}