package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.notes.databinding.ActivityAddNewBinding

class AddNewActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddNewBinding
    private lateinit var db:NotesDatabseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewBinding.inflate(layoutInflater)
        setContentView(binding.root)



        db = NotesDatabseHelper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Note Saved",Toast.LENGTH_SHORT).show()

        }
    }
}