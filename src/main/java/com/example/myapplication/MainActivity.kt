package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val intentMain = Intent(this, SubActivity::class.java)
        val openSub = findViewById<Button>(R.id.button_1)

        val text_1 = findViewById<TextView>(R.id.number_1)
        val text_2 = findViewById<TextView>(R.id.number_2)



        openSub.setOnClickListener {
            intentMain.putExtra("num1", text_1.text.toString().toInt())
            intentMain.putExtra("num2", text_2.text.toString().toInt())
            Log.d("DKMobile", "OPEN SUB button pressed.")
            startActivity(intentMain)
        }
    }
}