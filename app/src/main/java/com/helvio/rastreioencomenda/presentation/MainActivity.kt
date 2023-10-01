package com.helvio.rastreioencomenda.presentation

import androidx.navigation.compose.rememberNavController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.helvio.rastreioencomenda.presentation.newOrder.NewOrderPage
import com.helvio.rastreioencomenda.presentation.orderList.MainPage
import com.helvio.rastreioencomenda.presentation.theme.RastreioEncomendaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RastreioEncomendaTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "main_page") {
                    composable("main_page"){
                        MainPage()
                    }
                    composable("new_order"){
                        NewOrderPage()
                    }
                }
            }
        }
    }
}


