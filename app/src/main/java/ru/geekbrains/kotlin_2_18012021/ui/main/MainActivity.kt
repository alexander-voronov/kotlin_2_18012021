package ru.geekbrains.kotlin_2_18012021.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.kotlin_2_18012021.R
import ru.geekbrains.kotlin_2_18012021.data.model.Note
import ru.geekbrains.kotlin_2_18012021.ui.base.BaseActivity
import ru.geekbrains.kotlin_2_18012021.ui.note.NoteActivity


class MainActivity : BaseActivity<List<Note>?, MainViewState>() {

    override val viewModel: MainViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    override val layoutRes: Int = R.layout.activity_main
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        adapter = MainAdapter(object : OnItemClickListener {
            override fun onItemClick(note: Note) {
                openNoteScreen(note)
            }
        })

        mainRecycler.adapter = adapter

        fab.setOnClickListener { openNoteScreen(null) }
    }

    private fun openNoteScreen(note: Note? = null) {
        val intent = NoteActivity.getStartIntent(this, note?.id)
    }

    override fun renderData(data: List<Note>?) {
        if (data == null) return
        adapter.notes = data
    }

}
