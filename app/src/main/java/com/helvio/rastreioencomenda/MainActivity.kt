package com.helvio.rastreioencomenda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.helvio.rastreioencomenda.presentation.newOrderAndDetails.NewOrderPage
import com.helvio.rastreioencomenda.presentation.newOrderAndDetails.NewOrderPageAndDetails
import com.helvio.rastreioencomenda.presentation.orderList.MainPage
import com.helvio.rastreioencomenda.presentation.theme.RastreioEncomendaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RastreioEncomendaTheme {
                val navController = rememberSwipeDismissableNavController()

                SwipeDismissableNavHost(
                    navController = navController,
                    startDestination = "main_page"
                ) {
                    composable("main_page") {
                        MainPage(navController)
                    }
                    composable(
                        "new_order/{nameOrder}/{codeOrder}"
                    ) {
                        NewOrderPageAndDetails(
                            navController = navController,
                            nameOrder = it.arguments?.getString("nameOrder"),
                            codeOrder = it.arguments?.getString("codeOrder")
                        )
                    }
                }
            }
        }
    }
}


