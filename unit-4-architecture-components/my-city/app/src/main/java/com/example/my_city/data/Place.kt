package com.example.my_city.data

import androidx.annotation.DrawableRes

data class Place(val id: Long,
                 val categoryId: Long,
                 @DrawableRes val image: Int,
                 val name: String,
                 val description: String)