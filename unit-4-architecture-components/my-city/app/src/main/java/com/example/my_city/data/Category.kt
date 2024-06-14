package com.example.my_city.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Category(val id: Long,
                    val icon: ImageVector,
                    val name: String,
                    val description: String,
                    val recommendations: List<Recommendation>)