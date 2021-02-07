package ru.geekbrains.kotlin_2_18012021.ui.note

import ru.geekbrains.kotlin_2_18012021.data.model.Note
import ru.geekbrains.kotlin_2_18012021.ui.base.BaseViewState

class NoteViewState (note: Note? = null, error: Throwable? = null) :
BaseViewState<Note?>(note, error)
