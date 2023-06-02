package com.luiscv.lab03

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

private val asistentes: List<Asistente> = listOf(
    Asistente("Luis Condori", "01/06/2023", "B+",
        "987654321", "lcondorivill@unsa.edu.pe", 2000.0),
    Asistente("Julio Lopez", "01/06/2023", "B+",
        "987654321", "lcondorivill@unsa.edu.pe", 2000.0),
    Asistente("Sandro Rodriguez", "01/06/2023", "B+",
        "987654321", "lcondorivill@unsa.edu.pe", 2000.0),
    Asistente("Pepe Fernandez", "01/06/2023", "B+",
        "987654321", "lcondorivill@unsa.edu.pe", 2000.0),
    Asistente("Lautaro Martinez", "01/06/2023", "B+",
        "987654321", "lcondorivill@unsa.edu.pe", 2000.0),
    Asistente("Mario Iturralde", "01/06/2023", "B+",
        "987654321", "lcondorivill@unsa.edu.pe", 2000.0),
    Asistente("Jesus Gomez", "01/06/2023", "B+",
        "987654321", "lcondorivill@unsa.edu.pe", 2000.0)
)

@Composable
fun Home(
    btnRegister: (String) -> Unit,
    btnEdit: (String) -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        //Text(text = "Hello $name!")
        Text(
            text = "Lista de los asistentes inscritos al congreso",
            modifier = Modifier.padding(bottom = 20.dp)
        )

        //val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            //aqui van los items
            MyAsistents(btnEdit, asistentes)
        }

        Button(
            onClick = { /*TODO*/
                        btnRegister("")
                      },
            Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Registrar asistente")
        }
    }
}

data class Asistente(val nombre: String, val fInscripcion: String,
                     val tSangre: String, val telefono: String,
                     val correo: String, val montoPagado: Double)

@Composable
fun ItemAsistente(btnEdit: (String) -> Unit, asistente: Asistente, count: Int){

    /*
    var t1 = Text(text = "")
    var t2 = Text(text = "")
    var t3 = Text(text = "")
    var t4 = Text(text = "")
    var t5 = Text(text = "")
    var t6= Text(text = "")
*/

    Row() {
        Column() {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .background(Color.LightGray)
                    .padding(all = 10.dp)
            ) {
                Text(text = "Nombres: "+ asistente.nombre)
                Text(text = "Fecha de inscripcion: "+ asistente.fInscripcion)
                Text(text = "Tipo de sangre: "+ asistente.tSangre)
                Text(text = "Telefono: "+ asistente.telefono)
                Text(text = "Correo: "+ asistente.correo)
                Text(text = "Monto pagado: "+ asistente.montoPagado)
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        Column(modifier = Modifier.padding(top = 20.dp)) {
            Button(onClick = { btnEdit("") },
                    modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Edit")
            }

            Button(onClick = {
                        asistentes.drop(count)
                    },
                    modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Delete")
            }
        }


    }

}

@Composable
fun MyAsistents(btnEdit: (String) -> Unit, asistentes: List<Asistente>){

    var count = 0
    LazyColumn(
        modifier = Modifier.height(500.dp)  //muy importante
    ) {
        items(asistentes){ asistente ->
            ItemAsistente(btnEdit,asistente, count)
            count = count + 1;
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03Theme {
        Home()
    }
}*/