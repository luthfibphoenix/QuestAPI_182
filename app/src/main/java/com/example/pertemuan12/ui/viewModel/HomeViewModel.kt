package com.example.pertemuan12.ui.viewModel

import com.example.pertemuan12.Model.Mahasiswa


sealed class HomeUiState {
    data class Success(val data: List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}

