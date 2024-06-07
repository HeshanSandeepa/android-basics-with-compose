/*
 * Copyright (c) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sports.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.sports.R
import com.example.sports.model.Sport
import com.example.sports.utils.SportsContentType

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */

@Composable
fun SportsScreen(
    contentType: SportsContentType,
    sportsUiState: SportsUiState,
    onBackPressed: () -> Unit,
    onSportsClicked: (Sport) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
    ) {
        if (contentType == SportsContentType.ListAndDetail) {
            Row(modifier = modifier,
                horizontalArrangement = Arrangement.SpaceEvenly) {
                SportsList(
                    sportsUiState = sportsUiState,
                    onClick = onSportsClicked,
                    onBackPressed = onBackPressed,
                    contentPadding = WindowInsets.statusBars.asPaddingValues(),
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            top = dimensionResource(R.dimen.padding_medium),
                            start = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium),
                        )
                )
                SportsDetail(
                    selectedSport = sportsUiState.currentSport,
                    contentPadding = contentPadding,
                    onBackPressed = onBackPressed,
                    modifier = Modifier
                        .padding(top = dimensionResource(R.dimen.padding_medium))
                        .weight(1f),
                )
            }

        } else {

            if(sportsUiState.isShowingListPage) {
                SportsList(
                    sportsUiState = sportsUiState,
                    onClick = onSportsClicked,
                    onBackPressed = onBackPressed,
                    contentPadding = WindowInsets.statusBars.asPaddingValues(),
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            top = dimensionResource(R.dimen.padding_medium),
                            start = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium),
                        )
                )
            } else {
                SportsDetail(
                    selectedSport = sportsUiState.currentSport,
                    contentPadding = contentPadding,
                    onBackPressed = onBackPressed,
                    modifier = Modifier
                        .padding(top = dimensionResource(R.dimen.padding_medium))
                        .weight(1f),
                )

            }
        }
    }

}
