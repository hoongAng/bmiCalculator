package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSubmit.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI (){
        val name = editName.text
        val weight = editWeight.text.toString().toFloat()
        val height = editHeight.text.toString().toDouble()

        val image = imageResult

        val heightInM = height/100.0
        val bmi = weight/(Math.pow(heightInM,2.0))
        val strBMI = String.format("%.2f",bmi)

        if (bmi <18.5)
        {
            textResult.text = name.toString() + " " + getString(R.string.stringResult)+ strBMI +"." + "\n" + getString(R.string.underweight)
            image.visibility = View.VISIBLE
            image.setImageResource(R.drawable.underweight)
        }

        else if (bmi > 25.0)
        {
            textResult.text = name.toString() + " " + getString(R.string.stringResult)+ strBMI +"." + "\n" + getString(R.string.overweight)
            image.visibility = View.VISIBLE
            image.setImageResource(R.drawable.overweight)
        }

        else
        {
            textResult.text = name.toString() + " " + getString(R.string.stringResult)+ strBMI +"." + "\n" + getString(R.string.normal)
            image.visibility = View.VISIBLE
            image.setImageResource(R.drawable.normal)
        }
    }

    fun resetInput(view: View){
        editName.setText("")
        editWeight.setText("")
        editHeight.setText("")
        imageResult.visibility = View.GONE
        textResult.text = ""
    }
}
