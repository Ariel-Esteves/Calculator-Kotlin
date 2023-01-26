package eu.tutorials.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var displayValue : TextView? = null
    private var lastNumeric : Boolean = false
    private var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayValue = findViewById(R.id.inputDisplay)
    }

    fun startOperation(view: View){
      when{
          displayValue!!.text.contains("/") -> {
              var values = displayValue!!.text.split("/")
              var value0 = values[0]
              var value1 = values[1]
              displayValue?.text = (value0.toDouble() / value1.toDouble()).toString()
          }

          displayValue!!.text.contains("*") -> {
              var values = displayValue!!.text.split("*")
              var value0 = values[0]
              var value1 = values[1]
              displayValue?.text = (value0.toDouble() * value1.toDouble()).toString()
          }
          displayValue!!.text.contains("-") -> {
              var values = displayValue!!.text.split("-")
              var value0 = values[0]
              var value1 = values[1]
              displayValue?.text = (value0.toDouble() - value1.toDouble()).toString()
          }
          displayValue!!.text.contains("+") -> {
              var values = displayValue!!.text.split("+")
              var value0 = values[0]
              var value1 = values[1]
              displayValue?.text = (value0.toDouble() + value1.toDouble()).toString()
          }
      }
        lastDot = false
        lastNumeric = false

    }
    fun btnOperation(view: View){
        if(!lastDot && lastNumeric){
            displayValue?.append((view as Button).text)
        }
        lastDot = true
        lastNumeric = false

    }
    fun btnValue(view:View){
            if(!lastNumeric && !lastDot){
                displayValue?.text = ((view as Button).text)
            }else{
                displayValue?.append((view as Button).text)
            }

            lastNumeric = true
            lastDot = false

    }

    fun erase(view: View){
        if(lastNumeric && displayValue!!.text.length > 1){
            var display = displayValue!!.text
            displayValue?.text = display.subSequence(0, display.length -1);
        }else{
            displayValue?.text = "0"
            lastNumeric = false
        }
    }

}