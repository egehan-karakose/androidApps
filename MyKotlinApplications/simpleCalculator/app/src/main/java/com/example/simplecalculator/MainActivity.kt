package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun sum(view: View){
        var a = firstText.text.toString().toInt()
        var b = secondText.text.toString().toInt()

        var res = a+b
        resultText.text = "Result : $res"

    }
    fun sub(view: View){
        var a = firstText.text.toString().toInt()
        var b = secondText.text.toString().toInt()

        var res = a-b
        resultText.text = "Result : $res"

    }
    fun mult(view: View){
        var a = firstText.text.toString().toInt()
        var b = secondText.text.toString().toInt()

        var res = a*b
        resultText.text = "Result : $res"

    }
    fun div(view: View){
        var a = firstText.text.toString().toInt()
        var b = secondText.text.toString().toInt()

        var res = a/b
        resultText.text = "Result : $res"

    }
}
