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
package com.example.my_city.ui

import androidx.lifecycle.ViewModel
import com.example.my_city.data.Category
import com.example.my_city.data.Recommendation
import com.example.my_city.data.local.DataProvider

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CategoryViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CityUiState(currentCategory = null, currentRecommendation = null))
    val uiState: StateFlow<CityUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val categories =
            DataProvider.categories
        _uiState.value =
            CityUiState(categories = categories,
                currentCategory = categories[0],
                currentRecommendation = null,
                isShowingHomepage = true )
    }

//    fun updateDetailsScreenStates(email: Email) {
//        _uiState.update {
//            it.copy(
//                currentSelectedEmail = email,
//                isShowingHomepage = false
//            )
//        }
//    }
}
