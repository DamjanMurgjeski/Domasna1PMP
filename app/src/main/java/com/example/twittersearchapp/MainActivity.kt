package com.example.twittersearchapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private val tagsList = mutableListOf("AndroidFP", "Deitel", "Google", "iPhoneFP", "JavaFP", "JavaHTP")
    private lateinit var adapter: TagAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = TagAdapter(tagsList)
        recyclerView.adapter = adapter


        val btnSave = findViewById<Button>(R.id.btnSave)
        val etTag = findViewById<EditText>(R.id.etTag)
        val etQuery = findViewById<EditText>(R.id.etQuery)

        btnSave.setOnClickListener {
            val newTag = etTag.text.toString()
            if (newTag.isNotEmpty()) {
                tagsList.add(0, newTag) // Додај го на почеток на листата
                adapter.notifyItemInserted(0)
                recyclerView.scrollToPosition(0)


                etTag.text.clear()
                etQuery.text.clear()
            } else {
                Toast.makeText(this, "Please enter a tag", Toast.LENGTH_SHORT).show()
            }
        }


        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener {
            tagsList.clear()
            adapter.notifyDataSetChanged()
        }
    }
}