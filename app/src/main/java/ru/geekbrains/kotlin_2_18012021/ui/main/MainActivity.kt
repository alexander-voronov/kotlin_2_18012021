package ru.geekbrains.kotlin_2_18012021.ui.main

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.kotlin_2_18012021.R
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.kotlin_2_18012021.data.model.Note
import ru.geekbrains.kotlin_2_18012021.databinding.ActivityMainBinding
import ru.geekbrains.kotlin_2_18012021.ui.note.NoteActivity

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainAdapter
    lateinit var ui: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        setSupportActionBar(ui.toolbar)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        adapter = MainAdapter(object : OnItemClickListener {
            override fun onItemClick(note: Note) {
                openNoteScreen(note)
            }
        })
        ui.mainRecycler.adapter = adapter

        viewModel.viewState().observe(this, Observer<MainViewState> { t ->
            t?.let { adapter.notes = it.notes }
        })

        ui.fab.setOnClickListener { openNoteScreen() }
    }

    private fun openNoteScreen(note: Note? = null) {
        startActivity(NoteActivity.getStartIntent(this, note))
    }

}
