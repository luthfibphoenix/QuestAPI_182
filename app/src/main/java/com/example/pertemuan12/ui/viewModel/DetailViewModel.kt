package com.example.pertemuan12.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.pertemuan12.Model.Mahasiswa
import com.example.pertemuan12.repository.MahasiswaRepository
import com.example.pertemuan12.ui.View.DestinasiDetail
import com.example.pertemuan12.ui.View.DestinasiEntry
import kotlinx.coroutines.launch
import java.io.IOException

sealed class DetailUiState{
    data class Success(val mahasiswa: Mahasiswa) : DetailUiState()
    object Error : DetailUiState()
    object Loading : DetailUiState()
}

fun Mahasiswa.toDetaulUiEvent(): InsertUiEvent{
    return InsertUiEvent(
        nim = nim,
        nama = nama,
        alamat = alamat,
        jenisKelamin = jenisKelamin,
        kelas = kelas,
        angkatan = angkatan
    )
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val mhs:MahasiswaRepository): ViewModel(){
    var mhsUiState : DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set
    private val _nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM])

    init {
        getMhsByNim()
    }

    fun getMhsByNim(){
        viewModelScope.launch {
            mhsUiState = DetailUiState.Loading
            mhsUiState = try {
                DetailUiState.Success(mhs.getMahasiswa(_nim))
            } catch (e: IOException) {
                DetailUiState.Error
            } catch (e: HttpException) {
                DetailUiState.Error
            }

        }
    }
}