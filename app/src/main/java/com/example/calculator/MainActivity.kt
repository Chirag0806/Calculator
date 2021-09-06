package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNum = ""
    var op  = "?"
    lateinit var buClick : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         buClick = ""

    }

    fun numberEvent(view: View) {
        if (isNewOp)
            textView.setText("")
        isNewOp = false
         buClick = textView.text.toString()
         val buSelect = view as Button
        when(buSelect.id){
            bu0.id -> {buClick += "0"}
            bu1.id -> {buClick += "1"}
            bu2.id -> {buClick += "2"}
            bu3.id -> {buClick += "3"}
            bu4.id -> {buClick += "4"}
            bu5.id -> {buClick += "5"}
            bu6.id -> {buClick += "6"}
            bu7.id -> {buClick += "7"}
            bu8.id -> {buClick += "8"}
            bu9.id -> {buClick += "9"}
        }
        textView.setText(buClick)
    }

    fun operatorEvent(view: View) {
          isNewOp = true
          oldNum = textView.text.toString()
        textView.setText("")
          var buselect = view as Button
        when(buselect.id){
            buPlus.id -> {op = "+"}
            buMinus.id -> {op = "-"}
            buMultiply.id -> {op = "*"}
            buDivide.id -> {op = "/"}
            buModulus.id -> {op ="%"}
        }
        textView.setText(op)
    }

    fun equalEvent(view: View) {
       val newNum = textView.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNum.toDouble() + newNum.toDouble()}
            "-" -> {result = oldNum.toDouble() - newNum.toDouble()}
            "*" -> {result = oldNum.toDouble() * newNum.toDouble()}
            "/" -> {result = oldNum.toDouble() / newNum.toDouble()}
            "%" -> {result = oldNum.toDouble() % newNum.toDouble()}
        }
        if (result.toString() == "0.0"){
            textView.setText("0")
        }
        else
        textView.setText(result.toString())
    }

    fun acEvent(view: View) {
        textView.setText("0")
        isNewOp=true
    }

    fun back(view: View) {
        val string = textView.text.toString()
        if (string.isNotEmpty()){
            textView.setText(string.substring(0,string.length-1))
        }
    }



    fun numberPlusMinus(view: View) {
        val buselect = view as Button
        val text = textView.text.toString()

        if (text.contains("-") && op =="?"){
            buClick += ""
        }
        else if (text == "0"){
            when(buselect.id){
                buPlusMinus.id -> {buClick = "-$buClick"}
            }
        }
        else if (text.contains("-") && op == "+"){
            buClick += ""
        }
        else if (text.contains("-") && op == "-"){
            buClick += ""
        }
        else if (text.contains("-") && op == "*"){
            buClick += ""
        }
        else if (text.contains("-") && op == "/"){
            buClick += ""
        }
        else if (text.contains("-") && op == "%"){
            buClick += ""
        }
        else{
            when(buselect.id){
                buPlusMinus.id -> {buClick = "-$buClick"}
            }
            textView.setText(buClick)
        }

    }

    fun dot(view: View) {
        val buselect = view as Button
        val string = textView.text.toString()
        if (string.contains(".") && op == "?"){
             buClick += ""
        }
        else if (string.contains(".") && op =="+") {
           buClick += ""
        }
        else if (string.contains(".") && op =="-") {
            buClick += ""
        }
        else if (string.contains(".") && op =="*") {
            buClick += ""
        }
        else if (string.contains(".") && op =="/") {
            buClick += ""
        }
        else if (string.contains(".") && op =="%") {
            buClick += ""
        }
        else{
            when (buselect.id) {
                buPoint.id -> { buClick += "." }
            }
            textView.setText(buClick)
        }
    }

}