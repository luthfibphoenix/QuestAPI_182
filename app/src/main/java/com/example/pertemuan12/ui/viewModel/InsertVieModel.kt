package com.example.pertemuan12.ui.viewModel

import com.example.pertemuan12.Model.Mahasiswa


fun Mahasiswa.toInsertUiEvent():InsertUiEvent = InsertUiEvent{
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
}