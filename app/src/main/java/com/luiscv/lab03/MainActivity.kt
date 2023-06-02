package com.luiscv.lab03

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.luiscv.lab03.ui.theme.Lab03Theme


//Todo: Esta aplicacion es la semilla de lo que se esta aprendiendo en kotlin,
//Todo: La aplicacion, nos guia con el ruteo del navController el paso de parametros en especial
//Algunos problemas que se tuvo es que no se pueden pasar Objetos como parametros con Jetpack compose
//Otro problema QUE SE SOLUCIONO fue cuando se queria pasar un tipo de parametro diferente
// a String(viene por default), para esto se hizo lo siguiente:

//1                  composable(
//2                            route = "edit/{asistent1}",
//3                            arguments = listOf(
//4                                //Para poder cambiar los tipos de datos de los parametros
//5                                navArgument(name = "asistent1") { type = NavType.IntType}
//6                            )
//7                        ) {

// en la linea 3 de navegacion se declara los argumentos y el tipo que se requieren que sea
// es recomendable para las BUENAS PRACTICAS empezar a poner esa linea de codigo y
// todos los argumentos del ROUTE en ella


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab03Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "home"){

                        //Todo: Home =============================================================
                        composable(route = "home"){

                            var insertRegisterHome: MutableState<Boolean> =
                                remember { mutableStateOf(false) }
                            var editRegisterHome: MutableState<Boolean> =
                                remember { mutableStateOf(false) }

                            Home(
                                btnRegister = {
                                    //Toast.makeText(this@MainActivity, "Formulario registro", Toast.LENGTH_SHORT).show()
                                    navController.navigate("register")
                                },
                                //Otros botones
                                btnEdit = { asistent1 ->
                                    navController.navigate("edit/$asistent1")
                                    Log.d("Index Asistente: ", asistent1.toString())
                                },
                                btnDelete = {
                                    navController.navigate("home")
                                },
                                "","","","","","", 0, insertRegisterHome, editRegisterHome
                            )

                        }

                        //Todo: Home despues de agregar =========================================

                        composable(route = "home2/{param1}/{param2}/{param3}/{param4}/{param5}/{param6}") {
                            // Acceder a los parámetros en la siguiente pantalla
                            val param1 = it.arguments?.getString("param1").orEmpty()
                            val param2 = it.arguments?.getString("param2").orEmpty()
                            val param3 = it.arguments?.getString("param3").orEmpty()
                            val param4 = it.arguments?.getString("param4").orEmpty()
                            val param5 = it.arguments?.getString("param5").orEmpty()
                            val param6 = it.arguments?.getString("param6").orEmpty()

                            var insertRegisterHome: MutableState<Boolean> =
                                remember { mutableStateOf(true) }

                            var editRegisterHome: MutableState<Boolean> =
                                remember { mutableStateOf(false) }

                            // Utilizar los parámetros en tu interfaz de usuario o lógica de negocio
                            Home(
                                btnRegister = {
                                    //Toast.makeText(this@MainActivity, "Formulario registro", Toast.LENGTH_SHORT).show()
                                    navController.navigate("register")
                                },
                                //Otros botones
                                btnEdit = { asistent1 ->
                                    navController.navigate("edit/$asistent1")
                                    Log.d("Index Asistente: ", asistent1.toString())
                                },
                                btnDelete = {
                                    navController.navigate("home")
                                },
                                param1, param2, param3, param4, param5, param6, 0, insertRegisterHome, editRegisterHome
                            )
                        }

                        //Todo: Home despues de editar =========================================
                        composable(route = "home3/{asistent_id}",
                            arguments = listOf(
                                //Para poder cambiar los tipos de datos de los parametros
                                navArgument(name = "asistent_id") { type = NavType.IntType}
                            )
                        ) {
                            // Acceder a los parámetros en la siguiente pantalla
                            val param1 = it.arguments?.getInt("asistent_id")?: 0

                            var insertRegisterHome: MutableState<Boolean> =
                                remember { mutableStateOf(false) }

                            var editRegisterHome: MutableState<Boolean> =
                                remember { mutableStateOf(true) }

                            // Utilizar los parámetros en tu interfaz de usuario o lógica de negocio
                            Home(
                                btnRegister = {
                                    //Toast.makeText(this@MainActivity, "Formulario registro", Toast.LENGTH_SHORT).show()
                                    navController.navigate("register")
                                },
                                //Otros botones
                                btnEdit = { asistent1 ->
                                    navController.navigate("edit/$asistent1")
                                    Log.d("Index Asistente: ", asistent1.toString())
                                },
                                btnDelete = {
                                    navController.navigate("home")
                                },
                                "", "", "", "", "", "", param1, insertRegisterHome, editRegisterHome
                            )
                        }


                        // Todo: Register==================================================================
                        composable(route = "register"){
                            //aqui llamamos a la funcion onclick
                            // y lo enviamos al metodo home
                            //igual como se hizo en el compose home
                            registerAsistent(
                                btnCancel = {
                                    navController.navigate("home")
                                },
                                //Otros botones
                                btnSave = { param1, param2, param3, param4, param5, param6 ->

                                    // Navegar a la siguiente pantalla y pasar los parámetros como argumentos
                                    navController.navigate("home2/$param1/$param2/$param3/$param4/$param5/$param6")
                                }

                            )

                        }

                        //Todo: edit=====================================================================
                        composable(
                            route = "edit/{asistent1}",
                            arguments = listOf(
                                //Para poder cambiar los tipos de datos de los parametros
                                navArgument(name = "asistent1") { type = NavType.IntType}
                            )
                        ) {

                            // Acceder a los parámetros en la siguiente pantalla
                            val asistent1 = it.arguments?.getInt("asistent1") ?: 0

                            editAsistent(
                                btnCancel = {
                                    navController.navigate("home")
                                },
                                //Otros botones
                                btnSave = { asistent_id ->
                                    navController.navigate("home3/$asistent_id")
                                },
                                asistent1
                            )
                        }

                        //todo: =================================================================

                    }

                }
            }
        }
    }
}