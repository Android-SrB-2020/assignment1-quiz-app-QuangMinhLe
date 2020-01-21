package com.example.android.quiz

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )

    private var questionIndex = 0

    private lateinit var questionView: TextView

    private lateinit var nextButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionView = findViewById(R.id.question_view)
        nextButton = findViewById(R.id.next_button)
        backButton = findViewById(R.id.back_button)
        val trueButton: Button = findViewById(R.id.true_button)
        val falseButton: Button = findViewById(R.id.false_button)

        questionView.setText(questionBank[questionIndex].textResId)
        nextButton.setOnClickListener {
            questionIndex = (questionIndex + 1) % 20
            questionView.setText(questionBank[questionIndex].textResId)
        }

        backButton.setOnClickListener{
            questionIndex = (questionIndex - 1)
            questionView.setText(questionBank[questionIndex].textResId)
        }

        trueButton.setOnClickListener(){
            val toast = Toast.makeText(applicationContext, "CORRECT", Toast.LENGTH_SHORT)
            toast.show()}
        falseButton.setOnClickListener(){
            val toast = Toast.makeText(applicationContext, "WRONG", Toast.LENGTH_SHORT)
            toast.show()}

    }

    /*private fun ansReview (ans: Boolean){
        if(ans && ans == questionBank[questionIndex].answer) {
            val toast = Toast.makeText(applicationContext, "CORRECT", Toast.LENGTH_SHORT)
            toast.show()
        } else if (!ans && ans == questionBank[questionIndex].answer) {
            val toast = Toast.makeText(applicationContext, "CORRECT", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast = Toast.makeText(applicationContext, "WRONG", Toast.LENGTH_SHORT)
            toast.show()
        }
    }*/
}
