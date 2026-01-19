package com.example.doctorappdemo.navigation

import androidx.navigation.NavController
import com.example.doctorappdemo.core.model.DoctorModel

fun NavController.navigateToDetail(doctor: DoctorModel){
    currentBackStackEntry?.savedStateHandle?.set("doctor",doctor)
    navigate(Screen.Detail.route)
}