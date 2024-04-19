package com.bmicalculator.yagmurbmi

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bmicalculator.yagmurbmi.databinding.ActivityCalculationBinding

class CalculationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmi = intent.getStringExtra("BMI")
        binding.resultTextView.text = "Your BMI: $bmi"

        val bmiValue = bmi?.toDoubleOrNull()

        if (bmiValue != null) {
            val bmiCategory = getBMICategory(bmiValue)
            binding.categoryTextView.text = "Category: $bmiCategory"
        }
    }

    private fun getBMICategory(bmi: Double): String {
        return when {
            bmi < 18.5 -> " You Have an Underweight"
            bmi in 18.5..24.9 -> "You Have a Normal Weight"
            bmi in 25.0..29.9 -> "You Have an Overweight"
            bmi >= 30.0 -> "You Have an Obese"
            else -> "Unknown"
        }
    }

}