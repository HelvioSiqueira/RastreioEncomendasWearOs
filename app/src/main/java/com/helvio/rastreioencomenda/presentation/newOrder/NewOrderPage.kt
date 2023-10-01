package com.helvio.rastreioencomenda.presentation.newOrder

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState

@Composable
fun NewOrderPage() {

    val listState = rememberScalingLazyListState()

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
            Text("Tela para adicionar novo rastreio de pedido", color = MaterialTheme.colorScheme.primary)
        }
    }

}