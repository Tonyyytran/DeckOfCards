package com.okidoki.deckofcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: DeckViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        model = ViewModelProviders.of(this).get(DeckViewModel::class.java)
        model.getDeckIndex().observe(this,Observer<Int>{
            // observed data
            setCards(it)
        })

        setOnClickListener()
    }

    private fun setOnClickListener() {
        cardButton.setOnClickListener {
            model.drawCard()
        }
        resetButton.setOnLongClickListener{
            model.resetDeck()
            true
        }
        resetButton.setOnClickListener {
            val toast = Toast.makeText(this, "Hold to reset deck", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP, 0, 200)
            toast.show()
        }
    }


    private fun setCards(index: Int) {
        countText.text = String.format("${index}/52")
        when (model.getDeckIndex().value) {
            0 -> {
                cardButton.setImageResource(R.drawable.back)
                lastCardImage_holder.visibility = View.INVISIBLE
                secondLastCardImage_holder.visibility = View.INVISIBLE
                thirdLastCardImage_holder.visibility = View.INVISIBLE
            }
            1 -> {
                cardButton.setImageResource(model.getCardButton())
                lastCardImage_holder.visibility = View.INVISIBLE
                secondLastCardImage_holder.visibility = View.INVISIBLE
                thirdLastCardImage_holder.visibility = View.INVISIBLE
            }
            2 -> {
                cardButton.setImageResource(model.getCardButton())
                lastCardImage.setImageResource(model.getLastCard())

                lastCardImage_holder.visibility = View.VISIBLE
                secondLastCardImage_holder.visibility = View.INVISIBLE
                thirdLastCardImage_holder.visibility = View.INVISIBLE
            }
            3 -> {
                cardButton.setImageResource(model.getCardButton())
                lastCardImage.setImageResource(model.getLastCard())
                secondLastCardImage.setImageResource(model.getSecondLastCard())

                lastCardImage_holder.visibility = View.VISIBLE
                secondLastCardImage_holder.visibility = View.VISIBLE
                thirdLastCardImage_holder.visibility = View.INVISIBLE
            }
            else -> {
                cardButton.setImageResource(model.getCardButton())
                lastCardImage.setImageResource(model.getLastCard())
                secondLastCardImage.setImageResource(model.getSecondLastCard())
                thirdLastCardImage.setImageResource(model.getThirdLastCard())

                lastCardImage_holder.visibility = View.VISIBLE
                secondLastCardImage_holder.visibility = View.VISIBLE
                thirdLastCardImage_holder.visibility = View.VISIBLE
            }
        }
    }
}