package com.example.my_city.data

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class Category(val id: Long,
                    val icon: ImageVector,
                    @StringRes val name: Int,
                    @StringRes val description: Int,
                    val recommendations: List<Recommendation>)