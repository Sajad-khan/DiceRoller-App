package com.example.dicerollerii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // reference to roll button
        val rollButton: Button = findViewById(R.id.button)

        // reference to restart button
        val restartButton: Button = findViewById(R.id.button2)

        // click listener for roll button
        rollButton.setOnClickListener{
            rollDice()
        }

        // click listener for restart button
        restartButton.setOnClickListener{
            restart()
        }
    }

    // this function sets the image to dice_roll.png and text to empty string
    private fun restart() {
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceText: TextView = findViewById(R.id.textView)
        diceImage.setImageResource(R.drawable.dice_roll)
        diceText.text = ""
    }

    // function that takes care of what happens when we roll the die
    private fun rollDice() {
        val dice = Dice(6)
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceText: TextView = findViewById(R.id.textView)
        when(dice.roll()){
            1 -> {
                diceImage.setImageResource(R.drawable.dice_1)
                diceText.text = "1"
            }
            2 -> {
                diceImage.setImageResource(R.drawable.dice_2)
                diceText.text = "2"
            }
            3 -> {
                diceImage.setImageResource(R.drawable.dice_3)
                diceText.text = "3"
            }
            4 -> {
                diceImage.setImageResource(R.drawable.dice_4)
                diceText.text = "4"
            }
            5 -> {
                diceImage.setImageResource(R.drawable.dice_5)
                diceText.text = "5"
            }
            6 -> {
                diceImage.setImageResource(R.drawable.dice_6)
                diceText.text = "6"
            }
        }
    }
}

// Dice class
class Dice(private val maxNo: Int){
    // return a random number between maxNo and 1
    fun roll(): Int{
        return (1..maxNo).random()
    }
}