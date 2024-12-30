package com.example.pertemuan12.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan12.Model.Mahasiswa
import com.example.pertemuan12.repository.MahasiswaRepository
import kotlinx.coroutines.launch

class UpdateViewModel(
    savedStateHandle: SavedStateHandle,
    private val mhs: MahasiswaRepository
): ViewModel() {
    var uiState by mutableStateOf(InsertUiState())
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinasiUpdate.NIM])

    init {
        viewModelScope.launch {
            val mahasiswa = mahasiswaRepository.getMahasiswa(_nim)
            uiState = mahasiswa.toUiStateMhsUpdate()
        }
    }

    fun updateMahasiswa() {
        viewModelScope.launch {
            try {
                val mahasiswa = uiState.insertUiEvent.toMahasiswa()
                mahasiswaRepository.updateMahasiswa(_nim, mahasiswa)
            } catch (e:Exception) {
                e.printStackTrace()
            }
        }
    }
}

fun Mahasiswa.toUiStateMhsUpdate(): InsertUiState = InsertUiState(
    insertUiEvent = this.toDetaulUiEvent()
)