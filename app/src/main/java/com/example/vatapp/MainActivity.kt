package com.example.vatapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vatapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button.setOnClickListener {
            calculateVat()
        }
    }

    private fun calculateVat() {

        val stringinedittext = binding.price.text.toString()
        val cost = stringinedittext.toDouble()


        val selectedid = binding.radiogroup.checkedRadioButtonId


        val Percentage = when (selectedid) {
            R.id.ten -> 0.10
            R.id.fiften -> 0.15
            else -> 0.20
        }

        var vat = Percentage * cost

        var total = cost + vat


        val roundVat = binding.switch1.isChecked

        if (roundVat) {
            total = kotlin.math.ceil(total)
        }


        val formattedTotal = NumberFormat.getCurrencyInstance().format(total)
        binding.txtCostTotal.text = getString(R.string.total_amount, formattedTotal)


    }

}