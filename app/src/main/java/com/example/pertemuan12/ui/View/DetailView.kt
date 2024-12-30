package com.example.pertemuan12.ui.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text

@Composable
fun ComponentDetailMahasiswa(
    modifier: Modifier,
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