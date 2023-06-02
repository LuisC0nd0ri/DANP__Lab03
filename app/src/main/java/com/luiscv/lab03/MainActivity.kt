package com.luiscv.lab03

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luiscv.lab03.ui.theme.Lab03Theme

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
                        composable(route = "home"){
                            Home(
                                btnRegister = {
                                    //Toast.makeText(this@MainActivity, "Formulario registro", Toast.LENGTH_SHORT).show()
                                    navController.navigate("register")
                                },
                                //Otros botones
                                btnEdit = {
                                    navController.navigate("edit")
                                }
                            )
                        }
                        composable(route = "register"){
                            //aqui llamamos a la funcion onclick
                            // y lo enviamos al metodo home
                            //igual como se hizo en el compose home
                            registerAsistent(
                                btnCancel = {
                                    navController.navigate("home")
                                },
                                //Otros botones
                                btnSave = {
                                    navController.navigate("home")
                                }
                            )
                        }
                        composable(route = "edit"){
                            editAsistent(
                                btnCancel = {
                                    navController.navigate("home")
                                },
                                //Otros botones
                                btnSave = {
                                    navController.navigate("home")
                                }

                            )
                        }

                    }

                }
            }
        }
    }
}