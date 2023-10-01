package com.helvio.rastreioencomenda.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.helvio.rastreioencomenda.R
import com.helvio.rastreioencomenda.presentation.data.model.Order
import com.helvio.rastreioencomenda.presentation.theme.RastreioEncomendaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RastreioEncomendaTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainPage()
                }
            }
        }
    }
}

@Preview
@Composable
fun MainPage() {

    val dummyOrders = listOf(
        Order("30-4923-49203-4", "HQ Sandman"),
        Order("30-4923-49203-4", "Robo limpador"),
        Order("30-4923-49203-4", "Café em grãos"),
        Order("30-4923-49203-4", "Placa de video"),
        Order("30-4923-49203-4", "Roupas"),
    )

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
            items(5) { index ->
                ItemOrder(order = dummyOrders[index])
            }
        }

        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 15.dp)
                .size(32.dp),
            containerColor = MaterialTheme.colorScheme.primary,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "Button to add new Order",
                Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ItemOrder(order: Order) {
    Card(onClick = { /*TODO*/ }, modifier = Modifier.padding(vertical = 6.dp, horizontal = 10.dp)) {
        Column {
            Text(text = order.codigo)
            Text(text = order.descricao, style = TextStyle(fontSize = 12.sp))
        }
    }
}

@Preview
@Composable
fun ItemOrderPreview() {
    Card(onClick = {}, modifier = Modifier.padding(vertical = 6.dp, horizontal = 10.dp)) {
        Column {
            Text("344923405982384")
            Text("Meu robo limpador", style = TextStyle(fontSize = 12.sp))
        }
    }
}

