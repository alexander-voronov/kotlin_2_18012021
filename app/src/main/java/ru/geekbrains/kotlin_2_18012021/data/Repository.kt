package ru.geekbrains.kotlin_2_18012021.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.geekbrains.kotlin_2_18012021.data.provider.FireStoreProvider
import ru.geekbrains.kotlin_2_18012021.data.provider.RemoteDataProvider
import java.util.*

object Repository {

    private val remoteProvider: RemoteDataProvider = FireStoreProvider()

    fun getNotes() = remoteProvider.subscribeToAllNotes()

    fun saveNote(note: Note) = remoteProvider.saveNote(note)

    fun getNoteById(id: String) = remoteProvider.getNoteById(id)

}