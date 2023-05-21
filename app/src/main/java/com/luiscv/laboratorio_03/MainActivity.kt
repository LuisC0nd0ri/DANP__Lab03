package com.luiscv.laboratorio_03

import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luiscv.laboratorio_03.ui.theme.Laboratorio03Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio03Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

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
            MyAsistents(asistentes)
        }

        Button(
            onClick = { /*TODO*/ },
            Modifier.padding(start = 50.dp)
        ) {
            Text(text = "Registrar asistente")
        }
    }
}

data class Asistente(val nombre: String, val fInscripcion: String,
                     val tSangre: String, val telefono: String,
                     val correo: String, val montoPagado: Double)

@Composable
fun ItemAsistente(asistente: Asistente){

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
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Edit")
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Delete")
            }
        }


    }

}

@Composable
fun MyAsistents(asistentes: List<Asistente>){

    LazyColumn(
        modifier = Modifier.height(500.dp)  //muy importante
    ) {
        items(asistentes){ asistente ->
            ItemAsistente(asistente)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Laboratorio03Theme {
        Greeting("Android")
    }
}