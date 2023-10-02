package com.helvio.rastreioencomenda.presentation.newOrderAndDetails

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.wear.compose.material.HorizontalPageIndicator
import androidx.wear.compose.material.PageIndicatorState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalFoundationApi
@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewOrderPageAndDetails(
    navController: NavController,
    nameOrder: String?,
    codeOrder: String?
) {

    val maxPages = 2
    val pagerState = rememberPagerState()
    var selectedPage by remember { mutableIntStateOf(0) }

    val pageIndicatorState: PageIndicatorState = remember {
        object : PageIndicatorState {
            override val pageCount: Int
                get() = maxPages
            override val pageOffset: Float
                get() = 0f
            override val selectedPage: Int
                get() = selectedPage

        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (codeOrder == "null") {
            NewOrderPage(
                navController = navController,
                nameOrder = nameOrder,
                codeOrder = codeOrder
            )
            return
        }

        HorizontalPager(state = pagerState, count = maxPages) { page ->
            selectedPage = pagerState.currentPage

            when (page) {
                0 -> {
                    NewOrderPage(
                        navController = navController,
                        nameOrder = nameOrder,
                        codeOrder = codeOrder
                    )
                }

                1 -> {
                    DetailsPage()
                }
            }
        }

        HorizontalPageIndicator(
            pageIndicatorState = pageIndicatorState,
            selectedColor = MaterialTheme.colorScheme.primary
        )
    }
}