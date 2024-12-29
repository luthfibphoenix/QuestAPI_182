package com.example.pertemuan12.Model


import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*


@Serializable
data class Mahasiswa(
    val nim: String,
    val nama: String,
    val alamat: String,

    @SerialiName("jenis_kelamin")
    val jenisKelamin: String,

    val kelas: String,
    val angkatan: String
)