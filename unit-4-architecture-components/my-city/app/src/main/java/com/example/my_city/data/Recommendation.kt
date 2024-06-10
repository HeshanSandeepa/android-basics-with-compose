package com.example.my_city.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(val id: Long,
                          val categoryId: Long,
                          @DrawableRes val image: Int,
                          val name: String,
                          val description: String)