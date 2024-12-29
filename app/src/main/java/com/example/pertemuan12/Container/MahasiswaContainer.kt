package com.example.pertemuan12.Container

import com.example.pertemuan12.repository.MahasiswaRepository

interface AppContainer{
    val kontakRepository: MahasiswaRepository
}

class MahasiswaContainer: AppContainer{


}