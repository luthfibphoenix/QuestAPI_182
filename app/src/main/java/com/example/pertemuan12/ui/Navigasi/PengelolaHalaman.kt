package com.example.pertemuan12.ui.Navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pertemuan12.ui.View.DestinasiDetail
import com.example.pertemuan12.ui.View.DestinasiEntry
import com.example.pertemuan12.ui.View.DestinasiHome
import com.example.pertemuan12.ui.View.DetailView
import com.example.pertemuan12.ui.View.EntryMhsScreen
import com.example.pertemuan12.ui.View.HomeScreen

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ){
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = {navController.navigate(DestinasiEntry.route)},
                onDetailClick = {nim ->
                    navController.navigate("${DestinasiEntry.route}/$nim"){
                        popUpTo(DestinasiHome.route) {
                            inclusive = true
                        }
                    }
                    println("PengelolaHalaman: nim = $nim")
                }
            )
        }
        composable(DestinasiEntry.route){
            EntryMhsScreen(navigateBack = {
                navController.navigate(DestinasiHome.route) {
                    popUpTo(DestinasiHome.route) {
                        inclusive = true
                    }
                }
            })
        }
        composable(
            route = "${DestinasiDetail.route}/{nim}",
            arguments = listOf(navArgument("nim") {type = NavType.StringType })
        ){
            backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            DetailView(
                nim = nim,
                navigateBack = {
                    navController.navigate(DestinasiHome.route){
                        popUpTo(DestinasiHome.route){
                            inclusive = true
                        }
                    }
                },
                onClick = {
                    navController.navigate("${DestinasiEntry.route}/$nim") {
                    }
                }
            )
        }
    }
}
