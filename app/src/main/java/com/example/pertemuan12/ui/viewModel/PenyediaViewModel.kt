package com.example.pertemuan12.ui.viewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan12.MahasiswaApplications


object PenyediaViewModel {
    val factory = viewModelFactory {
        {
            initializer { HomeViewModel(aplikasiKontak().container.kontakRepository) }
            initializer { InsertViewModel(aplikasiKontak().container.kontakRepository) }
            //initializer{UpdateViewModel(aplikasiKontak().container.kontakRepository)}
        }
    }

    fun CreationExtras.aplikasiKontak(): MahasiswaApplications =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)
}