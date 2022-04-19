package com.okidoki.deckofcards

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeckViewModel : ViewModel() {

    private val totalCards = 52

    private val cardDeck = arrayListOf(
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

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val cardIndex: MutableLiveData<Int>  = MutableLiveData()

    init {
        resetDeck()
    }

    fun getDeckIndex(): LiveData<Int> {
        return cardIndex
    }

    fun resetDeck(){
        cardIndex.value = -1
        cardDeck.shuffle()
    }

    fun drawCard() {
        cardIndex.value?.let {
            if (it.plus(1) >= totalCards) {
                resetDeck()
            } else {
                cardIndex.value = it.plus(1)
            }
        }
    }

    fun getCardButton() : Int {
        return cardDeck[cardIndex.value!!]
    }

    fun getLastCard() : Int {
        return cardDeck[cardIndex.value!! - 1]
    }

    fun getSecondLastCard() : Int {
        return cardDeck[cardIndex.value!! - 2]
    }

    fun getThirdLastCard() : Int {
        return cardDeck[cardIndex.value!! - 3]
    }

}