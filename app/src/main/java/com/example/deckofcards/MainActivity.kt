package com.example.deckofcards

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.ResourceManagerInternal.get
import androidx.lifecycle.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var count: Int = 0
    //

    private lateinit var model: DeckViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProviders.of(this).get(DeckViewModel::class.java)
        model.getDeckIndex().observe(this,Observer<Int>{
            ///// observed data
        })
        setCards()
        cardButton.setOnClickListener {
            model.drawCard()
            setCards()
        }
        resetButton.setOnLongClickListener{
            model.resetDeck()
            setCards()
            true
        }
        resetButton.setOnClickListener {
            var toast = Toast.makeText(this, "Hold to reset deck", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP, 0, 200)
            toast.show()
        }
    }
    private fun setCards() {
        countText.text = "${model.getDeckIndex().value}/52"
        when (model.getDeckIndex().value) {
            0 -> {
                cardButton.setBackgroundResource(R.drawable.back)
                lastCardImage.visibility = View.INVISIBLE
                secondLastCardImage.visibility = View.INVISIBLE
                thirdLastCardImage.visibility = View.INVISIBLE
            }
            1 -> {
                cardButton.setBackgroundResource(model.getCardButton())
                lastCardImage.visibility = View.INVISIBLE
                secondLastCardImage.visibility = View.INVISIBLE
                thirdLastCardImage.visibility = View.INVISIBLE
            }
            2 -> {
                cardButton.setBackgroundResource(model.getCardButton())
                lastCardImage.setImageResource(model.getLastCard())
                lastCardImage.visibility = View.VISIBLE
                secondLastCardImage.visibility = View.INVISIBLE
                thirdLastCardImage.visibility = View.INVISIBLE
            }
            3 -> {
                cardButton.setBackgroundResource(model.getCardButton())
                lastCardImage.setImageResource(model.getLastCard())
                lastCardImage.visibility = View.VISIBLE
                secondLastCardImage.setImageResource(model.getSecondLastCard())
                secondLastCardImage.visibility = View.VISIBLE
                thirdLastCardImage.visibility = View.INVISIBLE
            }
            else -> {
                cardButton.setBackgroundResource(model.getCardButton())
                lastCardImage.setImageResource(model.getLastCard())
                lastCardImage.visibility = View.VISIBLE
                secondLastCardImage.setImageResource(model.getSecondLastCard())
                secondLastCardImage.visibility = View.VISIBLE
                thirdLastCardImage.setImageResource(model.getThirdLastCard())
                thirdLastCardImage.visibility = View.VISIBLE
            }
        }
    }
}