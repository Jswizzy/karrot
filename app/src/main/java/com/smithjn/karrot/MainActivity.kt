package com.smithjn.karrot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.lang.IllegalStateException
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        setOnClickListeners()
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> throw IllegalStateException()
        }
        diceImage.setImageResource(drawableResource)
    }

    private fun bindViews() {
        diceImage = findViewById(R.id.result_image)
        rollButton = findViewById(R.id.roll_btn)
    }

    private fun setOnClickListeners() {
        rollButton.apply {
            text = context.getString(R.string.roll_text)
            setOnClickListener {
                rollDice()
            }
        }
    }
}
