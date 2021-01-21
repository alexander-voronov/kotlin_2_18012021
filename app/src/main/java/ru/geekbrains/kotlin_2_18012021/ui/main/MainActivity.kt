package ru.geekbrains.kotlin_2_18012021.ui.main

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import ru.geekbrains.kotlin_2_18012021.R
import java.util.Observer

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        viewModel = ViewModelProviders.of( this ). get (MainViewModel:: class . java )
        adapter = MainAdapter()
        mainRecycler.adapter = adapter
        viewModel.viewState().observe( this , Observer<MainViewState> { t ->
            t?.let { adapter.notes = it.notes }
        })
    }
}