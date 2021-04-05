package com.example.timer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val SP_NAME = "my_sp_storage"
    var total = 0
    var started = false
    var count = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pre = readSharedPreference("time")
        Log.d("Preference", "time = $pre")
        if (pre != null) {
            textTimer.text = formatTime(pre.toInt())
        }
        if (pre != null) {
            total = pre.toInt()
        }

        buttonStart.setOnClickListener {
            start()
        }

        buttonPause.setOnClickListener {
            pause()
            writeSharedPreference("time", total.toString())

        }

        buttonStop.setOnClickListener {
            stop()
        }
    }


    fun start(){
        started = true
        // sub thread
        thread(start = true){
            while(true){
                Thread.sleep(1000) //1초당 한번씩 증가하게
                if(!started) break
                total = total + 1
                runOnUiThread{
                    textTimer.text = formatTime(total)
                }
            }
        }
    }

    fun pause(){
        if(count%2 == 1) {
            started = false
        }
        else if(count%2 == 0){
            start()
        }
        count = count +1
    }

    fun stop(){
        started = false
        total = 0
        textTimer.text = "00 : 00"
    }

    fun formatTime(time:Int) : String{
        val minite = String.format("%02d", time/60)
        val second = String.format("%02d",time%60)
        return "$minite : $second"

    }

    fun writeSharedPreference(key:String, value:String){
        val sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun readSharedPreference(key:String) : String?{
        val sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        return sp.getString("time","")
    }



}