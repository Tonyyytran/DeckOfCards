package com.okidoki.deckofcards

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*

class DeckOfCardsViewModelUnitTest {
    private var viewModel = mockk<DeckViewModel>()

    @Test
    fun  resetDeck() {
        every { viewModel.cardIndex }.returns(MutableLiveData())
        assertEquals(0, viewModel.cardIndex.value)
        viewModel.drawCard()
        viewModel.resetDeck()
        assertEquals(0, viewModel.cardIndex.value)
    }

}
// test zero case
// empty case
// null case
// out of bounds
// one or more