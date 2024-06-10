/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.my_city.data.local

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.ShoppingCart
import com.example.my_city.R
import com.example.my_city.data.Category
import com.example.my_city.data.Recommendation


/**
 * An static data store of [Account]s. This includes both [Account]s owned by the current user and
 * all [Account]s of the current user's contacts.
 */
object DataProvider {

    private val categories = listOf(
        Category(id = 2L,
            icon =  Icons.Outlined.Home,
            name = R.string.category_coffee,
            description = R.string.category_coffee,
            recommendations = listOf(
                Recommendation(id = 21L,
                    categoryId = 2L,
                    image = R.drawable.coffee,
                    name = "Vindy's Coffee",
                    description = "Vindy's"),
                Recommendation(id = 22L,
                    categoryId = 2L,
                    image = R.drawable.coffee,
                    name = "Black Coffee",
                    description = "Black Coffee"),)),
        Category(id = 3L,
            icon =  Icons.Outlined.AccountCircle,
            name = R.string.category_restaurant,
            description = R.string.category_coffee,
            recommendations = listOf(
                Recommendation(id = 31L,
                    categoryId = 3L,
                    image = R.drawable.restaurant,
                    name = "Red Rice",
                    description = "Red Rice"),
                Recommendation(id = 32L,
                    categoryId = 3L,
                    image = R.drawable.restaurant,
                    name = "Rice & Curry",
                    description = "Rice & Curry"),)),
        Category(id = 4L,
            icon =  Icons.Outlined.AccountCircle,
            name = R.string.category_kids,
            description = R.string.category_coffee,
            recommendations = listOf(
                Recommendation(id = 41L,
                    categoryId = 4L,
                    image = R.drawable.kids,
                    name = "Kid's Park",
                    description = "Vindy's"),
                Recommendation(id = 42L,
                    categoryId = 4L,
                    image = R.drawable.kids,
                    name = "Central Park",
                    description = "Central Park"),)),
        Category(id = 5L,
            icon =  Icons.Outlined.LocationOn,
            name = R.string.category_parks,
            description = R.string.category_coffee,
            recommendations = listOf(
                Recommendation(id = 51L,
                    categoryId = 5L,
                    image = R.drawable.parks,
                    name = "Yala",
                    description = "Yala Park"),
                Recommendation(id = 52L,
                    categoryId = 5L,
                    image = R.drawable.parks,
                    name = "Haggala",
                    description = "Haggala Park"),)),
        Category(id = 6L,
            icon =  Icons.Outlined.ShoppingCart,
            name = R.string.category_shopping,
            description = R.string.category_coffee,
            recommendations = listOf(
                Recommendation(id = 61L,
                    categoryId = 6L,
                    image = R.drawable.shoppin,
                    name = "Keels",
                    description = "Keels"),
                Recommendation(id = 62L,
                    categoryId = 6L,
                    image = R.drawable.shoppin,
                    name = "Arpico",
                    description = "Arpico")))
    )

//    /**
//     * Get the contact of the current user with the given [accountId].
//     */
//    fun getContactAccountById(accountId: Long): Account {
//        return allUserContactAccounts.firstOrNull { it.id == accountId }
//            ?: allUserContactAccounts.first()
//    }
}
