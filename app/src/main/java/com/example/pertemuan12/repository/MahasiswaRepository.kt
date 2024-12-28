package com.example.pertemuan12.repository

import com.example.pertemuan12.service.MahasiswaService

interface MahasiswaRepository{

    suspend fun getAllMahasiswa(): List<Mahasiswa>

    suspend fun getMahasiswa(nim: String): Mahasiswa
}

class  NetworkKontakRepository(
    private val kontakApiService: MahasiswaService
) : MahasiswaRepository{

    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa){
        kontakApiService.insertMahasiswa(mahasiswa)
    }
    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa){
        kontakApiService.updateMahasiswa(nim, mahasiswa)
    }
    override suspend fun deleteMahasiswa(nim: String) {
        try{
            val response = kontakApiService.deleteMahasiswa(nim)
            if ()
        }
    }
}