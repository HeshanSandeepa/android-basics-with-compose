package com.example.dessertclicker

data class DessertUIState(val revenue: Double = 0.0,
                          val currentDessertPrice: Double = 0.0,
                          val dessertsSold: Int = 0,
                          val currentDessertImageId: Int = 0,
                          val currentDessertIndex: Int = 0,) {
}
