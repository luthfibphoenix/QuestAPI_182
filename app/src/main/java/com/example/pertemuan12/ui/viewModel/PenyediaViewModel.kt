package com.example.pertemuan12.ui.viewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan12.MahasiswaApplications


object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer { HomeViewModel(AplikasiMahasiswa().container.kontakRepository) }
        initializer { InsertViewModel(AplikasiMahasiswa().container.kontakRepository) }
    }

    fun CreationExtras.AplikasiMahasiswa():MahasiswaApplications =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as MahasiswaApplications)
}