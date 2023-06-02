package com.luiscv.lab03

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun editAsistent(
    btnCancel: (String) -> Unit,
    btnSave: (Int) -> Unit,
    asistenteId: Int
){

    //var asistente: Asistente =
    var tfnombres by remember { mutableStateOf("Luis Condori") }
    var tffechaInscripcion by remember { mutableStateOf("01/06/2023") }
    var tftipoSangre by remember { mutableStateOf("B+") }
    var tftelefono by remember { mutableStateOf("987654321") }
    var tfcorreo by remember { mutableStateOf("lcondorivill@unsa.edu.pe") }
    var tfmontoPagado by remember { mutableStateOf("2000.0") }


    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    ) {
        Text(text = "Editar asistente",
            modifier = Modifier.padding(10.dp),
            fontSize = 24.sp
        )

        Text(text = "Nombres: ")
        TextField(value = tfnombres, onValueChange = { tfnombres = it }, modifier = Modifier.fillMaxWidth())
        Text(text = "Fecha de inscripcion: ")
        TextField(value = tffechaInscripcion, onValueChange = { tffechaInscripcion = it }, modifier = Modifier.fillMaxWidth())
        Text(text = "Tipo de sangre: ")
        TextField(value = tftipoSangre, onValueChange = { tftipoSangre = it }, modifier = Modifier.fillMaxWidth())
        Text(text = "Telefono: ")
        TextField(value = tftelefono, onValueChange = { tftelefono = it }, modifier = Modifier.fillMaxWidth())
        Text(text = "Correo: ")
        TextField(value = tfcorreo, onValueChange = { tfcorreo = it }, modifier = Modifier.fillMaxWidth())
        Text(text = "Monto pagado: ")
        TextField(value = tfmontoPagado, onValueChange = { tfmontoPagado = it }, modifier = Modifier.fillMaxWidth())

        Button(
            onClick = { btnSave(asistenteId) },
            modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
        ) {
            Text(text = "Guardar")
        }

        Button(
            onClick = { btnCancel("") },
            modifier = Modifier.padding(top = 5.dp).fillMaxWidth(),
        ) {
            Text(text = "Cancelar")
        }

    }

}