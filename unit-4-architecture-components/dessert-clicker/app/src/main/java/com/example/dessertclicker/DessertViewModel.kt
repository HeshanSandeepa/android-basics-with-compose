package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
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
    fun determineDessertToShow(currentDessertIndex: Int){

        val nextDessert = Datasource.dessertList[currentDessertIndex]

        var revenue = _uiState.value.revenue + nextDessert.price
        var currentDessertPrice =  nextDessert.price
        var dessertsSold = _uiState.value.dessertsSold + 1

        _uiState.update {
            it.copy(currentDessertImageId = nextDessert.imageId,
                revenue = revenue,
                currentDessertPrice = currentDessertPrice.toDouble(),
                dessertsSold = dessertsSold,
                currentDessertIndex = _uiState.value.currentDessertIndex +1
            )
        }
    }
}