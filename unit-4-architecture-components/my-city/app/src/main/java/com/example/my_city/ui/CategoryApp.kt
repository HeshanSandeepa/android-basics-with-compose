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

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.my_city.data.Category


@Composable
fun CategoryApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val viewModel: CategoryViewModel = viewModel()
    val cityUiState = viewModel.uiState.collectAsState().value

//    val navigationType: ReplyNavigationType
//    val contentType: ReplyContentType
//
//    when (windowSize) {
//        WindowWidthSizeClass.Compact -> {
//            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
//            contentType = ReplyContentType.LIST_ONLY
//        }
//        WindowWidthSizeClass.Medium -> {
//            navigationType = ReplyNavigationType.NAVIGATION_RAIL
//            contentType = ReplyContentType.LIST_ONLY
//        }
//        WindowWidthSizeClass.Expanded -> {
//            navigationType = ReplyNavigationType.PERMANENT_NAVIGATION_DRAWER
//            contentType = ReplyContentType.LIST_AND_DETAIL
//        }
//        else -> {
//            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
//            contentType = ReplyContentType.LIST_ONLY
//        }
//    }

    CategoryHomeScreen(
//        navigationType = navigationType,
//        contentType = contentType,
        cityUiState = cityUiState,
//        onTabPressed = { mailboxType: MailboxType ->
//            viewModel.updateCurrentMailbox(mailboxType = mailboxType)
//            viewModel.resetHomeScreenStates()
//        },
        cardPressed = { email: Category ->
//            viewModel.updateDetailsScreenStates(
//                email = email
//            )
        },
//        onDetailScreenBackPressed = {
//            viewModel.resetHomeScreenStates()
//        },
        modifier = modifier
    )
}
