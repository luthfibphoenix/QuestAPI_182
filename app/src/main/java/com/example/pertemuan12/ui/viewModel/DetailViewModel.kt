package com.example.pertemuan12.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.pertemuan12.Model.Mahasiswa
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.pertemuan12.repository.MahasiswaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val mahasiswa: Mahasiswa) : DetailUiState()
    object Error : DetailUiState()
}

class DetailViewModel(private val repository: MahasiswaRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState

    fun getMahasiswaById(nim: String) {
        viewModelScope.launch {
            _uiState.value = DetailUiState.Loading
            try {
                val mahasiswa = repository.getMahasiswa(nim)
                _uiState.value = DetailUiState.Success(mahasiswa)
            } catch (e: IOException) {
                e.printStackTrace()
                _uiState.value = DetailUiState.Error
            } catch (e: HttpException) {
                e.printStackTrace()
                _uiState.value = DetailUiState.Error
            }
        }
    }
}