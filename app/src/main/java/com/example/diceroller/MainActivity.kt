package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        //toast is used for a quick pop up message, falls behind if too many at a time
        when (diceRoll) {
            1 -> Toast.makeText(this, "You Won", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, "Sorry you lost", Toast.LENGTH_SHORT).show()
            3 -> Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show()
            4 -> Toast.makeText(this, "Better luck next time", Toast.LENGTH_SHORT).show()
            5 -> Toast.makeText(this, "You win some you lose some", Toast.LENGTH_SHORT).show()
            6 -> Toast.makeText(this, "Nope, Come back again", Toast.LENGTH_SHORT).show()
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}