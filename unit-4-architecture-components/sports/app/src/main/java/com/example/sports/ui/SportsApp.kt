package com.example.sports.ui

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sports.R
import com.example.sports.utils.SportsContentType

/**
 * Main composable that serves as container
 * which displays content according to [uiState] and [windowSize]
 */
@Composable
fun SportsApp(windowSize: WindowWidthSizeClass,
) {
    val viewModel: SportsViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            SportsAppBar(
                isShowingListPage = uiState.isShowingListPage,
                onBackButtonClick = { viewModel.navigateToListPage() },
            )
        }
    ) { innerPadding ->

        val contentType: SportsContentType

        when (windowSize) {
            WindowWidthSizeClass.Compact -> {
                contentType = SportsContentType.ListOnly
            }
            WindowWidthSizeClass.Medium -> {
                contentType = SportsContentType.ListOnly
            }
            WindowWidthSizeClass.Expanded -> {
                contentType = SportsContentType.ListAndDetail
            }
            else -> {
                contentType = SportsContentType.ListOnly
            }
        }

        val activity = LocalContext.current as Activity

        SportsScreen(
            contentType = contentType,
            sportsUiState = uiState,
            onBackPressed = { viewModel.navigateToListPage() },
            onSportsClicked = {
                viewModel.updateCurrentSport(it)
                viewModel.navigateToDetailPage()
            }, contentPadding = innerPadding)

//        if (uiState.isShowingListPage) {
//            SportsList(
//                sports = uiState.sportsList,
//                onClick = {
//                    viewModel.updateCurrentSport(it)
//                    viewModel.navigateToDetailPage()
//                },
//                contentPadding = innerPadding,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(
//                        top = dimensionResource(R.dimen.padding_medium),
//                        start = dimensionResource(R.dimen.padding_medium),
//                        end = dimensionResource(R.dimen.padding_medium),
//                    )
//            )
//        } else {
//            SportsDetail(
//                selectedSport = uiState.currentSport,
//                contentPadding = innerPadding,
//                onBackPressed = {
//                    viewModel.navigateToListPage()
//                }
//            )
//        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportsAppBar(
    onBackButtonClick: () -> Unit,
    isShowingListPage: Boolean,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text =
                if (!isShowingListPage) {
                    stringResource(R.string.detail_fragment_label)
                } else {
                    stringResource(R.string.list_fragment_label)
                }
            )
        },
        navigationIcon = if (!isShowingListPage) {
            {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        } else {
            { Box {} }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
    )
}