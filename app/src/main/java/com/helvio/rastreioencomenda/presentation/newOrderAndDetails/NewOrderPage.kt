@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.helvio.rastreioencomenda.presentation.newOrderAndDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.PageIndicatorState
import com.helvio.rastreioencomenda.R

@Composable
fun NewOrderPage(
    navController: NavController,
    nameOrder: String?,
    codeOrder: String?
) {

    var textName by remember { mutableStateOf(TextFieldValue("")) }
    var textCode by remember { mutableStateOf(TextFieldValue("")) }

    textCode = if (codeOrder != "null") {
        TextFieldValue(codeOrder!!)
    } else {
        TextFieldValue("")
    }

    textName = if (nameOrder != "null") {
        TextFieldValue(nameOrder!!)
    } else {
        TextFieldValue("")
    }

    val listState = rememberScalingLazyListState()

    Box {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxWidth(),
            autoCentering = AutoCenteringParams(itemIndex = 0),
            state = listState,
            flingBehavior = ScalingLazyColumnDefaults.snapFlingBehavior(
                state = listState,
                snapOffset = 0.dp
            )
        ) {
            item {
                Column(Modifier.padding(horizontal = 10.dp)) {
                    OutlinedTextField(
                        value = textName,
                        onValueChange = { textName = it },
                        label = { Text("Nome") },
                        maxLines = 1,
                        textStyle = TextStyle(color = Color.White)
                    )
                    Spacer(modifier = Modifier.size(6.dp))
                    OutlinedTextField(
                        value = textCode,
                        onValueChange = { textCode = it },
                        label = { Text("Codigo") },
                        maxLines = 1,
                        textStyle = TextStyle(color = Color.White)
                    )
                }
            }
        }
        FloatingActionButton(
            onClick = {
                      navController.popBackStack()
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 15.dp)
                .size(32.dp),
            containerColor = MaterialTheme.colorScheme.primary,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_check_24),
                contentDescription = "Button to add new Order",
                Modifier.size(24.dp)
            )
        }
    }

}