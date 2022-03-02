package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceTop = Dice(6)
        val diceRoll = dice.roll()
        val diceTopRoll = diceTop.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceTopImage: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        //Update the content description
        diceImage.contentDescription = diceRoll.toString()

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResourceTop = when (diceTopRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceTopImage.setImageResource(drawableResourceTop)

        //Update the content description
        diceTopImage.contentDescription = diceTopRoll.toString()

        // Update the screen with the dice roll - textView deleted, replaced with dice pictures
        ///val resultTextView: TextView = findViewById(R.id.textView)
       // resultTextView.text = diceRoll.toString()

        //toast is used for a quick pop up message, falls behind if too many at a time
        /*
        val message = when (diceRoll) {
            1 -> "You Won"
            2 -> "Sorry you lost"
            3 -> "Try again"
            4 -> "Better luck next time"
            5 -> "You win some you lose some"
            6 -> "Nope, Come back again"
            else -> ""
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
         */
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}