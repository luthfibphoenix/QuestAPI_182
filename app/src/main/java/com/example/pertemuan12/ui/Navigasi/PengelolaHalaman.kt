package com.example.pertemuan12.ui.Navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan12.ui.View.DestinasiDetail
import com.example.pertemuan12.ui.View.DestinasiEntry
import com.example.pertemuan12.ui.View.DestinasiHome
import com.example.pertemuan12.ui.View.DestinasiUpdate
import com.example.pertemuan12.ui.View.DetailScreen
import com.example.pertemuan12.ui.View.EntryMhsScreen
import com.example.pertemuan12.ui.View.HomeScreen
import com.example.pertemuan12.ui.View.UpdateScreen

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
                    navController.navigate("${DestinasiEntry.route}/$nim")
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

        composable(DestinasiDetail.routeWithArg) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString(DestinasiDetail.NIM) ?: ""
            DetailScreen(
                navigateBack = { navController.navigateUp() },
                onEditClick = {
                    navController.navigate("${DestinasiUpdate.route}/$nim")
                }
            )
        }

        composable(DestinasiUpdate.routeWithArg){ backStackEntry ->
            val nim = backStackEntry.arguments?.getString(DestinasiUpdate.NIM) ?: ""
            UpdateScreen(
                navigateBack = { navController.navigateUp() },
                onNavigate = { navController.navigate(DestinasiHome.route) }
            )
        }
    }
}
