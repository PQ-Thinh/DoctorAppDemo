package com.example.doctorappdemo.navigation.routes

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.doctorappdemo.core.ViewModel.MainViewModel
import com.example.doctorappdemo.core.model.DoctorModel
import com.example.doctorappdemo.feature.topdoctors.TopDoctorsScreen
import com.example.doctorappdemo.navigation.Screen


fun NavGraphBuilder.topDoctorsRoute(
    vm: MainViewModel,
    onBack: () -> Unit,
    onOpenDetail: (DoctorModel) -> Unit
) {
    composable(Screen.TopDoctors.route) {
        val doctors by vm.doctors.collectAsState(emptyList())
        LaunchedEffect(Unit) {
            if (doctors.isEmpty()) vm.loadDoctors()

        }
        TopDoctorsScreen(
            doctors = doctors,
            onBack = onBack,
            onOpenDetail = onOpenDetail
        )
    }
}