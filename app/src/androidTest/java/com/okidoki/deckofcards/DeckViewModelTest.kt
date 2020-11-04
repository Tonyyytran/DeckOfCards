package com.okidoki.deckofcards

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class DeckViewModelTest{
    private var viewModel = DeckViewModel()

    @Test
    fun  resetDeck() {
        assertEquals(0, viewModel.cardIndex.value)
        viewModel.drawCard()
        viewModel.resetDeck()
        assertEquals(0, viewModel.cardIndex.value)
    }
}