package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val intentSub = intent

        var num3 : Int

        val num1 = intentSub.getIntExtra("num1", 0)
        val num2 = intentSub.getIntExtra("num2", 0)

        num3 = num1 + num2

        val textView1 = findViewById<TextView>(R.id.textView1)
        textView1.setText("$num1 + $num2 = $num3")





        val backBtn = findViewById<Button>(R.id.button_2)
        backBtn.setOnClickListener {
            Log.d("DKMobile", "BACK button pressed.")
            finish()
        }
    }
}