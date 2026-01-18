package com.example.doctorappdemo.feature.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.doctorappdemo.core.ViewModel.MainViewModel
import kotlin.collections.emptyList

@Composable
fun MainScreen(viewModel: MainViewModel

){
    val categories by viewModel.category.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        if (categories.isEmpty()) {
            viewModel.loadCategory(force = false)
        }

    }
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
            item { HomeHeader()}
            item { Banner() }
            item { SectionHeader(
                title = "Bác sĩ chuyên khoa", onSeeAllClicked = null)}
            item { CategoryRow(items = categories) }
        }

    }
}


@Composable
@Preview(showBackground = true)
fun MainScreenPreview(){
    val viewModel: MainViewModel = viewModel()
    MainScreen(viewModel = viewModel)
}