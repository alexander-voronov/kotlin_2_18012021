package ru.geekbrains.kotlin_2_18012021.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.kotlin_2_18012021.data.model.Repository

class MainViewModel : ViewModel() {

    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        Repository.getNotes().observeForever {
            viewStateLiveData.value = viewStateLiveData.value?.copy(notes = it) ?: MainViewState(it)
        }

    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData
}