package com.example.doctorappdemo.navigation.routes

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.doctorappdemo.core.ViewModel.MainViewModel
import com.example.doctorappdemo.core.model.DoctorModel
import com.example.doctorappdemo.feature.home.MainScreen
import com.example.doctorappdemo.navigation.Screen

fun NavGraphBuilder.homeRoute(
    vm: MainViewModel,
    onOpenDetail: (DoctorModel)-> Unit
){
    composable(Screen.Home.route){
        val categories by vm.category.collectAsState(initial = emptyList())
        val doctors by vm.doctors.collectAsState(initial = emptyList())

        LaunchedEffect(Unit) {
            if (categories.isEmpty()) vm.loadCategory()
            if (doctors.isEmpty()) vm.loadDoctors()
        }

        MainScreen(vm,
        onOpenDoctorDetail = onOpenDetail)


    }
}