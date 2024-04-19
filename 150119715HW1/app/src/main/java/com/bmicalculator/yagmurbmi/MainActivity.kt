package com.bmicalculator.yagmurbmi
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bmicalculator.yagmurbmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val weightEditText = findViewById<EditText>(R.id.editTextWeight)
        val heightEditText = findViewById<EditText>(R.id.editTextHeight)

        calculateButton.setOnClickListener {
            val weightText = weightEditText.text.toString()
            val heightText = heightEditText.text.toString()

            if (weightText.isNotEmpty() && heightText.isNotEmpty()) {181
                val weight = weightText.toDouble()
                val height = heightText.toDouble() / 100

                val bmi = calculateBMI(weight, height)
                val bmiString = String.format("%.1f", bmi)

                val intent = Intent(this, CalculationActivity::class.java)
                intent.putExtra("BMI", bmiString)
                startActivity(intent)
            } else {
                val resultTextView = findViewById<TextView>(R.id.result1textView)
                resultTextView.text = "Invalid input. Please enter a valid weight and height."
            }
        }
    }

    private fun calculateBMI(weight: Double, height: Double): Double {
        return weight / (height * height)
    }
}
