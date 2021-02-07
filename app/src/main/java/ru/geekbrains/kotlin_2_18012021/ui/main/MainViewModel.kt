package ru.geekbrains.kotlin_2_18012021.ui.main

import androidx.lifecycle.Observer
import ru.geekbrains.kotlin_2_18012021.data.model.Note
import ru.geekbrains.kotlin_2_18012021.data.model.NoteResult
import ru.geekbrains.kotlin_2_18012021.data.model.Repository
import ru.geekbrains.kotlin_2_18012021.ui.base.BaseViewModel

class MainViewModel(val repository: Repository = Repository) :
    BaseViewModel<List<Note>?, MainViewState>() {

    private val repositoryNotes = repository.getNotes()
    private val notesObserver = object : Observer<NoteResult> {
        override fun onChanged(t: NoteResult?) {
            if (t == null) return

            when (t) {
                is NoteResult.Success<*> -> {
                    viewStateLiveData.value = MainViewState(notes = t.data as? List<Note>)
                }
                is NoteResult.Error -> {
                    viewStateLiveData.value = MainViewState(error = t.error)
                }
            }
        }
    }

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever(notesObserver)
    }

    override fun onCleared() {
        repositoryNotes.removeObserver(notesObserver)
    }
}