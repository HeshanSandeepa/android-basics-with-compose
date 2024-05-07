package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel: ViewModel() {

    // UI state
    private val _uiState = MutableStateFlow(DessertUIState())
    val uiState: StateFlow<DessertUIState> = _uiState.asStateFlow()

    // Set of words used in the game
    private var desserts: MutableSet<Dessert> = mutableSetOf()

    init {
        resetGame()
    }

    fun resetGame() {
        _uiState.value = DessertUIState()
    }

    /**
     * Determine which dessert to show.
     */
    fun determineDessertToShow(dessertsSold: Int){
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                break
            }
        }
        _uiState.update {
            it.copy(currentDessertImageId = dessertToShow.imageId)
        }
    }
}