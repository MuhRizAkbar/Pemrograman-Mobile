package com.example.helloui
import android.os.Bundle
import android.graphics.Color
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = findViewById<LinearLayout>(R.id.mainLayout)
        val inputName = findViewById<EditText>(R.id.etName) // Komponen Input
        val btnSapa = findViewById<Button>(R.id.btnSapa)    // Tombol Sapa
        val textGreeting = findViewById<TextView>(R.id.tvGreeting)
        val btnLight = findViewById<Button>(R.id.btnLight)
        val btnDark = findViewById<Button>(R.id.btnDark)

        btnSapa.setOnClickListener {
            val namaUser = inputName.text.toString()

            textGreeting.text = "Hello $namaUser!"
        }
        btnLight.setOnClickListener {
            layout.setBackgroundColor(Color.WHITE)
            textGreeting.setTextColor(Color.BLACK)
            inputName.setHintTextColor(Color.GRAY)
            inputName.setTextColor(Color.BLACK)
        }

        btnDark.setOnClickListener {
            layout.setBackgroundColor(Color.BLACK)
            textGreeting.setTextColor(Color.WHITE)
            inputName.setHintTextColor(Color.LTGRAY)
            inputName.setTextColor(Color.WHITE)
        }
    }
}