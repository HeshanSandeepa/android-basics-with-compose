package com.example.my_city.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Category(val id: Long,
                    val icon: ImageVector,
                    val name: Int,
                    val description: Int,
                    val recommendations: List<Recommendation>)