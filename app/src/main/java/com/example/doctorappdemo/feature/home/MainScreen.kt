package com.example.doctorappdemo.feature.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(

){
    var selectedBottom by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            HomeBottomBar(
                selected = selectedBottom,
                onSelect = { selectedBottom = it }
            )
        }
    ){inner ->
        LazyColumn(contentPadding = inner) {
            item { HomeHeader() }
        }

    }
}
@Composable
@Preview(showBackground = true)
fun MainScreenPreview(){
    MainScreen()
}