package com.helvio.rastreioencomenda.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.helvio.rastreioencomenda.presentation.newOrder.NewOrderPage
import com.helvio.rastreioencomenda.presentation.orderList.MainPage
import com.helvio.rastreioencomenda.presentation.theme.RastreioEncomendaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RastreioEncomendaTheme {
                val navController = rememberSwipeDismissableNavController()

                SwipeDismissableNavHost(navController = navController, startDestination = "main_page") {
                    composable("main_page"){
                        MainPage(navController)
                    }
                    composable("new_order"){
                        NewOrderPage()
                    }
                }
            }
        }
    }
}


