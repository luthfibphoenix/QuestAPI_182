package com.example.pertemuan12.ui.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.unit.dp
import com.example.pertemuan12.Model.Mahasiswa

@Composable
fun ItemDetailMahasiswa(
    modifier: Modifier = Modifier,
    mahaasiswa: Mahasiswa
){
    Card(
        modifier = modifier.fillMaxWidth()
    ){
        Column(
            modifier = modifier.padding(16.dp)
        ){
            ComponentDetailMahasiswa(judul = "NIM", isinya = mahaasiswa.nim)
            Spacer(modifier = Modifier.padding(5.dp))
            ComponentDetailMahasiswa(judul = "Nama", isinya = mahaasiswa.nama)
            Spacer(modifier = Modifier.padding(5.dp))
            ComponentDetailMahasiswa(judul = "Alamat", isinya = mahaasiswa.alamat)
            Spacer(modifier = Modifier.padding(5.dp))
            ComponentDetailMahasiswa(judul = "Jenis Kelamin", isinya = mahaasiswa.jenisKelamin)
            Spacer(modifier = Modifier.padding(5.dp))
            ComponentDetailMahasiswa(judul = "Kelas", isinya = mahaasiswa.kelas)
            Spacer(modifier = Modifier.padding(5.dp))
            ComponentDetailMahasiswa(judul = "Angkatan", isinya = mahaasiswa.angkatan)
        }
    }
}

@Composable
fun ComponentDetailMahasiswa(
    modifier: Modifier = Modifier,
    judul: String,
    isinya: String
){
  Column(
      modifier = modifier
          .fillMaxWidth(),
      horizontalAlignment = Alignment.Start
  ){
      Text(
          text = "$judul :",
          modifier = modifier
      )
      Text(
          text = isinya,
      )
  }
}