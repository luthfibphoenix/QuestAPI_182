package com.example.pertemuan12.ui.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan12.customwidget.CostumeTopAppBar
import com.example.pertemuan12.ui.Navigasi.DestinasiNavigasi
import com.example.pertemuan12.ui.viewModel.PenyediaViewModel
import com.example.pertemuan12.ui.viewModel.UpdateViewModel
import kotlinx.coroutines.launch

object DestinasiUpdate : DestinasiNavigasi {
    override val route = "update"
    override val titleRes = "Update Mhs"
    const val NIM = "nim"
    val routeWithArg = "$route/{$NIM}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(
    modifier: Modifier = Modifier,
    viewModel: UpdateViewModel = viewModel(factory = PenyediaViewModel.Factory),
    navigateBack: () -> Unit,
    onNavigate: () -> Unit
){
    val insertUiState = viewModel.uiState
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        modifier = Modifier,
        topBar = {
            CostumeTopAppBar(
                title = DestinasiUpdate.titleRes,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ){
        padding ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
                .padding(15.dp)
        ){
            EntryBody(
                insertUiState = insertUiState,
                onMahasiswaValueChange = { updateEvent ->
                    viewModel.updateState(updateEvent)
                },
                onSaveClick = {
                    coroutineScope.launch {
                        viewModel.updateMahasiswa()
                        onNavigate()
                    }
                }
            )
        }
    }
}