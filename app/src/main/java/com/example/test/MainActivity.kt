package com.example.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.test.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonClear.setOnClickListener {
            binding.input.text = ""
            binding.output.text = "0"
        }

        binding.buttonBracketLeft.setOnClickListener {
            binding.input.text = addToInput("(")
        }

        binding.buttonBracketRight.setOnClickListener {
            binding.input.text = addToInput(")")
        }

        binding.button0.setOnClickListener {
            binding.input.text = addToInput("0")
        }

        binding.button1.setOnClickListener {
            binding.input.text = addToInput("1")
        }

        binding.button2.setOnClickListener {
            binding.input.text = addToInput("2")
        }

        binding.button3.setOnClickListener {
            binding.input.text = addToInput("3")
        }

        binding.button4.setOnClickListener {
            binding.input.text = addToInput("4")
        }

        binding.button5.setOnClickListener {
            binding.input.text = addToInput("5")
        }

        binding.button6.setOnClickListener {
            binding.input.text = addToInput("6")
        }

        binding.button7.setOnClickListener {
            binding.input.text = addToInput("7")
        }

        binding.button8.setOnClickListener {
            binding.input.text = addToInput("8")
        }

        binding.button9.setOnClickListener {
            binding.input.text = addToInput("9")
        }

        binding.buttonDot.setOnClickListener {
            binding.input.text = addToInput(".")
        }

        binding.buttonPlus.setOnClickListener {
            binding.input.text = addToInput("+")
        }

        binding.buttonMinus.setOnClickListener {
            binding.input.text = addToInput("-")
        }

        binding.buttonMultiply.setOnClickListener {
            binding.input.text = addToInput("×")
        }

        binding.buttonDivide.setOnClickListener {
            binding.input.text = addToInput("÷")
        }

        binding.buttonEqual.setOnClickListener {
            showResults()
        }

    }

    private fun addToInput(string: String): String {
        return binding.input.text.toString() + string
    }

    @SuppressLint("SetTextI18n")
    private fun showResults(){
        var expression = binding.input.text.replace(Regex("×"), "*")
        expression = expression.replace(Regex("÷"), "/")

        try {
            val results = Expression(expression).calculate()

            if(results.isNaN()){
                binding.output.text = "Error"
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }else{
                binding.output.text = DecimalFormat("0.######").format(results).toString()
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        }catch (e: Exception){
            binding.output.text = "Error"
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}