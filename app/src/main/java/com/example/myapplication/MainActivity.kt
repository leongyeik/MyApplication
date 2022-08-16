package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var diceImg: ImageView
    lateinit var numberText: TextView
    lateinit var editPlayerName: EditText
    lateinit var playerNameTV: TextView
    lateinit var binding: ActivityMainBinding
    private val gameInfo: MyName = MyName("Leng", "0")
    private var totalScore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /* diceImg = findViewById(R.id.diceImg)
         numberText = findViewById(R.id.numberText)
         editPlayerName = findViewById(R.id.editPlayerName)
         playerNameTV = findViewById(R.id.playerName) */
        /*  val rollButton: Button = findViewById(R.id.rollButton) */
        binding.gameInfo = gameInfo
        binding.rollButton.setOnClickListener { rollDice() }
/* val updateButton = findViewById<Button>(R.id.updatePlayerNameBtn) */
        binding.updatePlayerNameBtn.setOnClickListener { updatePlayerName(it) }
    }

    private fun updatePlayerName(view: View) {
        binding.apply {
            gameInfo?.playerName = binding.editPlayerName.text.toString()
            invalidateAll()
        }

// binding.playerNameTV.text = editPlayerName.text

        editPlayerName.setText(" ")
        editPlayerName.clearFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun rollDice() {
        val randomNum = (1..6).random()
        //val numberText: TextView = findViewById(R.id.numberText)
        //val diceImg: ImageView = findViewById(R.id.diceImg)
        totalScore += randomNum
        binding.numberText.text = totalScore.toString()

        val imgSrc = when (randomNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImg.setImageResource(imgSrc)
    }


}
