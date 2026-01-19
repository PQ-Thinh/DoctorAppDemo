package com.example.doctorappdemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.doctorappdemo.core.ViewModel.MainViewModel
import com.example.doctorappdemo.navigation.routes.detailRoute
import com.example.doctorappdemo.navigation.routes.homeRoute
import com.example.doctorappdemo.navigation.routes.introRoute
import com.example.doctorappdemo.navigation.routes.topDoctorsRoute

@Composable
fun AppNavGraph(
    nav: NavHostController,
    vm: MainViewModel
) {
    NavHost(navController = nav, startDestination = Screen.Intro.route) {
        introRoute(onStart = {
            nav.popBackStack()
            nav.navigate(Screen.Home.route){
                popUpTo(Screen.Intro.route){
                    inclusive=true
                }
            }
        })
        homeRoute(
            vm = vm,
            onOpenTopDoctors = {
                nav.navigate(Screen.TopDoctors.route)
            },
            onOpenDetail = {doctorModel ->
                nav.navigateToDetail(doctorModel)
            }

        )
        topDoctorsRoute(vm = vm,
            onBack = {nav.popBackStack()},
            onOpenDetail = {doctorModel ->
                nav.navigateToDetail(doctorModel)
            })

        detailRoute(
            nav = nav,
            onBack = {nav.popBackStack()}
        )
    }
}