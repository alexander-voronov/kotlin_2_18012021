package ru.geekbrains.kotlin_2_18012021.data.provider

import androidx.lifecycle.LiveData
import ru.geekbrains.kotlin_2_18012021.data.model.Note
import ru.geekbrains.kotlin_2_18012021.data.model.NoteResult

interface RemoteDataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
    fun saveNote(note: Note): LiveData<NoteResult>
}