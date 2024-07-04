package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var submitteButton: Button
    lateinit var cancelButton: Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editText = findViewById(R.id.editText)
        submitteButton = findViewById(R.id.button_1)
        cancelButton = findViewById(R.id.button_2)




        editText.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {



            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

               val checkText = editText.text.toString()

                if (checkText.isNotEmpty()) {
                    submitteButton.isEnabled = true
                }

            }

            override fun afterTextChanged(s: Editable?) {

                if (s?.isEmpty() == true) {
                    submitteButton.isEnabled = false
                }

            }
        })




        submitteButton.setOnClickListener {

            val enteredText = editText.text.toString()

            if (enteredText.isEmpty()) Toast.makeText(this@MainActivity,"Input field is empty!",Toast.LENGTH_SHORT).show()
            else Toast.makeText(this@MainActivity,enteredText,Toast.LENGTH_SHORT).show()

        }

        cancelButton.setOnClickListener {
            editText.text.clear()
        }
    }
}