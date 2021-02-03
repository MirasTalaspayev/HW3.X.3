package com.example.hw3x3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val RANDOM_SIZE = 20
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val outputNumbers = HashMap<Int, Int>()

        findViewById<Button>(R.id.btn_generate).setOnClickListener() {
            val temp = getRandomInt()
            if (outputNumbers.containsKey(temp)) {
                findViewById<TextView>(R.id.text_from_btn).text = outputNumbers[temp].toString()
                return@setOnClickListener
            }
            outputNumbers[temp] = someHeavyComputation(temp)
            findViewById<TextView>(R.id.text_from_btn).text = outputNumbers[temp].toString()
        }

    }

    fun getRandomInt() = (0..RANDOM_SIZE).random()
    fun someHeavyComputation(num: Int): Int {
        try {
            Thread.sleep(2000)
        } catch(e: Exception) {}
        return num*num;
    }
}