package com.example.diceroll

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupEdgeToEdgeDisplay()
        setContentView(R.layout.activity_main)
        applyInsetsToView(findViewById(R.id.mainLayout))

        val diceRollButton: Button = findViewById(R.id.diceRollButton)
        val diceImageView: ImageView = findViewById(R.id.diceImageView)

        diceRollButton.setOnClickListener {
            val diceImageResource = getDiceImageResource()
            diceImageView.setImageResource(diceImageResource)
        }
    }

    private fun setupEdgeToEdgeDisplay() {
        enableEdgeToEdge()
    }

    private fun applyInsetsToView(view: View) {
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getDiceImageResource(): Int {
        val randomNumber = Random.nextInt(6) + 1
        return when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}