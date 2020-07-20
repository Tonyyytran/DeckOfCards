package com.example.deckofcards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DeckViewModel {
    private val cardIndex: MutableLiveData<Int>  = MutableLiveData<Int>()

//    Init {
//        cardIndex.value = 0
//    }

    fun getDeckIndex(): LiveData<Int> {
        return cardIndex
    }

    fun resetCardIndex() {
        cardIndex.value = 0
    }

}