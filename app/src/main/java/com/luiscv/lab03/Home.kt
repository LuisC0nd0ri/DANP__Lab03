package com.luiscv.lab03

import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.versionedparcelable.VersionedParcelize

private var asistentes = mutableListOf(
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

//val data = mutableStateListOf<List<String>>()

@Composable
fun Home(
    btnRegister: (String) -> Unit,
    btnEdit: (Int) -> Unit,
    btnDelete: () -> Unit,
    p1: String, //nombre
    p2: String, //fecha
    p3: String, //tipo
    p4: String, //telefono
    p5: String, //correo
    p6: String, //monto
    p7: Int,  //indice del asistente(editar)
    insertRegister: MutableState<Boolean>, //para insertar el dato registrado
    editRegister: MutableState<Boolean>
) {

    //Todo: insert asistent
    if (insertRegister.value){
        asistentes += listOf(Asistente(p1, p2, p3, p4, p5, p6.toDouble()))
        insertRegister.value = false
    }

    //Todo: edit asistent
    //agregamos un valor por defecto porque todavia no se implemento el paso de parametros
    //pero los PARAMETROS serian IGUAL que con REGISTER debido a que de momento no se encontro
    //el modo de pasar objetos
    if (editRegister.value){
        asistentes[p7] = Asistente(
            "Alejandro", "1", "1", "1", "1", 100.0)
        editRegister.value = false
    }

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
            MyAsistents(btnEdit, asistentes, btnDelete)
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
fun ItemAsistente(btnEdit: (Int) -> Unit, asistente: Asistente, btnDelete: () -> Unit){

    //Seria recomendable agregar Cards, pero como es un proyecto semilla se entiende
    Row() {
        Column() {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .background(Color.LightGray)
                    .padding(all = 10.dp)
                    .width(240.dp)
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
            Button(onClick = {
                        //todo : esperar
                        btnEdit(asistentes.indexOf(asistente))
                    },
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
            ) {
                Text(text = "Edit")
            }

            Button(onClick = {
                        //todo : esperar
                        asistentes.remove(asistente)
                        btnDelete()
                    },
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
            ) {
                Text(text = "Delete")
            }
        }


    }

}


@Composable
fun MyAsistents(btnEdit: (Int) -> Unit, asistentes: List<Asistente>, btnDelete: () -> Unit){

    LazyColumn(
        modifier = Modifier.height(500.dp)  //muy importante
    ) {
        items(asistentes){ asistente ->
            ItemAsistente(btnEdit,asistente, btnDelete)
        }
    }
}