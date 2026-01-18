package com.example.doctorappdemo.navigation.routes


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.doctorappdemo.feature.intro.IntroScreen
import com.example.doctorappdemo.navigation.Screen

fun NavGraphBuilder.introRoute(onStart:()-> Unit){
    composable(Screen.Intro.route){
        IntroScreen(onStart)
    }
}