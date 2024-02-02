package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var db: NotesDatabseHelper
    private var noteId: Int= -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabseHelper(this)

        noteId = intent.getIntExtra("note_id",-1)
        if(noteId == -1){
            finish()
            return
        }

        val note = db.getNoteByID(noteId)
        binding.updatetitleEditText.setText(note.title)
        binding.updatecontentEditText.setText(note.title)

        binding.updateSaveButton.setOnClickListener{
            val newTitle = binding.updatetitleEditText.text.toString()
            val newContent = binding.updatecontentEditText.text.toString()
            val updatedNote = Note(noteId, newTitle, newContent)
            db.updateNote(updatedNote)
            finish()
            Toast.makeText(this,"Changes Saved", Toast.LENGTH_LONG).show()
        }
    }
}