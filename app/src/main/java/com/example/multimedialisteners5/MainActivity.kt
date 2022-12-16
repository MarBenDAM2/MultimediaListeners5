package com.example.multimedialisteners5

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.example.multimedialisteners5.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Hazme un arrayList de binding.EditText1 y binding.EditText2
        val editTexts = arrayListOf(binding.EditText1, binding.EditText2)

        for (editText in editTexts) {

            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    comprobarletras()
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })

        }

        binding.EditText1.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.textView.text = binding.EditText1.tag.toString()
            }
        }
        binding.EditText2.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.textView.text = binding.EditText2.tag.toString()
            }
        }

        binding.button.setOnClickListener{
            val text1 = binding.EditText1.text.toString()
            val text2 = binding.EditText2.text.toString()
            val text3 = StringBuilder()

            text3.append(text1).append(text2)

            binding.EditText1.setText(text3.toString())

            binding.EditText2.text.clear()
        }


    }


    fun comprobarletras(){
        binding.button.isEnabled = binding.EditText1.text.isNotEmpty() && binding.EditText2.text.isNotEmpty()
    }
}