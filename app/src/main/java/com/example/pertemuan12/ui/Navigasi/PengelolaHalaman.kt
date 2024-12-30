package com.example.pertemuan12.ui.Navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pertemuan12.ui.View.*

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ) {
        // Halaman Home
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = { nim ->
                    navController.navigate("${DestinasiDetail.route}/$nim")
                }
            )
        }

        // Halaman Entry Mahasiswa
        composable(route = DestinasiEntry.route) {
            EntryMhsScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        // Halaman Detail Mahasiswa
        composable(
            route = DestinasiDetail.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiDetail.NIM) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString(DestinasiDetail.NIM)
            nim?.let {
                DetailScreen(
                    navigateBack = { navController.popBackStack() },
                    onEditClick = { navController.navigate("${DestinasiUpdate.route}/$it") }
                )
            }
        }

        // Halaman Update Mahasiswa
        composable(
            route = DestinasiUpdate.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdate.NIM) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString(DestinasiUpdate.NIM)
            nim?.let {
                UpdateScreen(
                    navigateBack = { navController.popBackStack() },
                    onNavigate = { navController.popBackStack() }
                )
            }
        }
    }
}
