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
    private val cardDeck = arrayListOf<Int>(
        R.drawable.ac, R.drawable.ad, R.drawable.ah, R.drawable.aspade,
        R.drawable.twoc, R.drawable.twod, R.drawable.twoh, R.drawable.twos,
        R.drawable.threec, R.drawable.threed, R.drawable.threeh, R.drawable.threes,
        R.drawable.fourc, R.drawable.fourd, R.drawable.fourh, R.drawable.fours,
        R.drawable.fivec, R.drawable.fived, R.drawable.fiveh, R.drawable.fives,
        R.drawable.sixc, R.drawable.sixd, R.drawable.sixh, R.drawable.sixs,
        R.drawable.sevenc, R.drawable.sevend, R.drawable.sevenh, R.drawable.sevens,
        R.drawable.eightc, R.drawable.eightd, R.drawable.eighth, R.drawable.eights,
        R.drawable.ninec, R.drawable.nined, R.drawable.nineh, R.drawable.nines,
        R.drawable.tenc, R.drawable.tend, R.drawable.tenh, R.drawable.tens,
        R.drawable.jc, R.drawable.jd, R.drawable.jh, R.drawable.js,
        R.drawable.qc, R.drawable.qd, R.drawable.qh, R.drawable.qs,
        R.drawable.kc, R.drawable.kd, R.drawable.kh, R.drawable.ks
        )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cardDeck.shuffle()
        cardButton.setOnClickListener {
            drawCard()
        }
        resetButton.setOnLongClickListener{
            resetDeck()
        }
        resetButton.setOnClickListener {
            var toast = Toast.makeText(this, "Hold to reset deck", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP, 0, 200)
            toast.show()
        }
    }

    private fun drawCard() {
        count++
        if(count > 52){
            count = 0
            cardDeck.shuffle()
            cardButton.setBackgroundResource(R.drawable.back)
            lastCardImage.visibility = View.GONE
            secondLastCardImage.visibility = View.GONE
            thirdLastCardImage.visibility = View.GONE
        }
        else {
            cardButton.setBackgroundResource(cardDeck[count - 1])
            if(count == 2){
                lastCardImage.setImageResource(cardDeck[count - 2])
                lastCardImage.visibility = View.VISIBLE
            }
            else if(count == 3){
                lastCardImage.setImageResource(cardDeck[count - 2])
                secondLastCardImage.setImageResource(cardDeck[count - 3])
                secondLastCardImage.visibility = View.VISIBLE
            }
            else if(count == 4){
                lastCardImage.setImageResource(cardDeck[count - 2])
                secondLastCardImage.setImageResource(cardDeck[count - 3])
                thirdLastCardImage.setImageResource(cardDeck[count - 4])
                thirdLastCardImage.visibility = View.VISIBLE
            }
            else if(count > 4){
                lastCardImage.setImageResource(cardDeck[count - 2])
                secondLastCardImage.setImageResource(cardDeck[count-3])
                thirdLastCardImage.setImageResource(cardDeck[count-4])
            }
        }
        countText.text = "$count/52"
    }

    private fun resetDeck(): Boolean {
        count = 0
        cardDeck.shuffle()
        cardButton.setBackgroundResource(R.drawable.back)
        lastCardImage.visibility = View.GONE
        secondLastCardImage.visibility = View.GONE
        thirdLastCardImage.visibility = View.GONE
        return true
    }
}