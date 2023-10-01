package com.helvio.rastreioencomenda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.helvio.rastreioencomenda.presentation.newOrder.NewOrderPage
import com.helvio.rastreioencomenda.presentation.orderList.MainPage
import com.helvio.rastreioencomenda.presentation.theme.RastreioEncomendaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
                        NewOrderPage(
                            nameOrder = it.arguments?.getString("nameOrder"),
                            codeOrder = it.arguments?.getString("codeOrder")
                        )
                    }
                }
            }
        }
    }
}


