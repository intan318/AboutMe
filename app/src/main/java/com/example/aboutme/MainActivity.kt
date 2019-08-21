package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Intan Yoshana")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)
        binding.myName = myName

//        findViewById<Button>(R.id.buttonDone).setOnClickListener {
//            addNickName(it) //it refers to the done button
//        }
        binding.buttonDone.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View){
//        val editText = findViewById<EditText>(R.id.editNickname)
//        val nicknameTextView = findViewById<TextView>(R.id.textNickname)
//
//        //set text in nicknametextview to the text in the nicknameedittext
//        nicknameTextView.text = editText.text
//        //hide the editText and the Button
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        //make the textview visible
//        nicknameTextView.visibility = View.VISIBLE


        binding.apply {
//            textNickname.text = binding.editNickname.text
            myName?.nickname = editNickname.text.toString()
            invalidateAll()
            editNickname.visibility = View.GONE
            buttonDone.visibility = View.GONE
            textNickname.visibility = View.VISIBLE
        }

        //hide the keyboard after we're done
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
