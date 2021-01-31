package ru.geekbrains.kotlin_2_18012021.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.kotlin_2_18012021.R
import ru.geekbrains.kotlin_2_18012021.data.model.Color
import ru.geekbrains.kotlin_2_18012021.data.model.Note
import ru.geekbrains.kotlin_2_18012021.databinding.ItemNoteBinding

interface OnItemClickListener {
    fun onItemClick(note: Note)
}

class MainAdapter(private val OnItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<MainAdapter.NoteViewHolder>() {
    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) =
        holder.bind(notes[position])

    override fun getItemCount() = notes.size


    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ui: ItemNoteBinding = ItemNoteBinding.bind(itemView)

        fun bind(note: Note) {
            ui.title.text = note.title
            ui.body.text = note.note

            val color = when (note.color) {
                Color.WHITE -> R.color.color_white
                Color.VIOLET -> R.color.color_violet
                Color.YELLOW -> R.color.color_yello
                Color.RED -> R.color.color_red
                Color.PINK -> R.color.color_pink
                Color.GREEN -> R.color.color_green
                Color.BLUE -> R.color.color_blue
            }

            itemView.setBackgroundResource(color)
            itemView.setOnClickListener { OnItemClickListener.onItemClick(note) }
        }
    }
}