package com.example.pertemuan12.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.pertemuan12.Model.Mahasiswa
import com.example.pertemuan12.repository.MahasiswaRepository
import kotlinx.coroutines.launch
import okio.IOException


sealed class HomeUiState {
    data class Success(val data: List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}

class HomeViewModel (private val mahasiswa: MahasiswaRepository) : ViewModel() {
    var mahasiswaUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
    private set
    init {
        getMahasiswa()
    }

    fun getMahasiswa(){
        viewModelScope.launch {
            mahasiswaUiState = HomeUiState.Loading
            mahasiswaUiState = try {
                HomeUiState.Success(mahasiswa.getAllMahasiswa())
            } catch (e: Exception) {
                HomeUiState.Error
            }catch (e: IOException){
                HomeUiState.Error
            }catch (e : HttpException){
                HomeUiState.Error
            }
        }
    }

    fun deleteMahasiswa(nim: String){
        viewModelScope.launch {
            mahasiswaUiState = HomeUiState.Loading
            mahasiswaUiState = try {
                HomeUiState.Success(mahasiswa.getAllMahasiswa())
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
            }
        }
    }
}