package com.example.prueba.Screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun textos() {
    val context = LocalContext.current

    // Variables para las tres bandas de colores y sus colores asociados
    var banda1 by remember { mutableStateOf<String?>(null) }
    var banda2 by remember { mutableStateOf<String?>(null) }
    var banda3 by remember { mutableStateOf<String?>(null) }

    var banda1Color by remember { mutableStateOf(Color.LightGray) }
    var banda2Color by remember { mutableStateOf(Color.LightGray) }
    var banda3Color by remember { mutableStateOf(Color.LightGray) }

    var isExpanded1 by remember { mutableStateOf(false) }
    var isExpanded2 by remember { mutableStateOf(false) }
    var isExpanded3 by remember { mutableStateOf(false) }

    // Función para calcular el valor de la resistencia
    fun calcularResistencia(): String {
        val digito1 = banda1?.toIntOrNull() ?: return "Seleccione bandas"
        val digito2 = banda2?.toIntOrNull() ?: return "Seleccione bandas"
        val multiplicador = banda3?.toFloatOrNull() ?: return "Seleccione bandas"

        val resistencia = (digito1 * 10 + digito2) * multiplicador
        return "$resistencia Ω ±20%" // Se asume una tolerancia de ±20%
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos en la columna
        ) {
            // Título centrado
            Text(
                text = "Cálculo del valor de la resistencia",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally) // Centra el título horizontalmente
                    .padding(bottom = 16.dp) // Espacio debajo del título
            )

            // Menú desplegable para la Banda 1
            ExposedDropdownMenuBox(
                expanded = isExpanded1,
                onExpandedChange = { isExpanded1 = !isExpanded1 }
            ) {
                TextField(
                    value = banda1 ?: "Banda 1",
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(isExpanded1) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier
                        .menuAnchor()
                        .background(banda1Color) // Fondo del botón cambia con el color
                )
                ExposedDropdownMenu(
                    expanded = isExpanded1,
                    onDismissRequest = { isExpanded1 = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Negro - 0") },
                        onClick = {
                            banda1 = "0"
                            banda1Color = Color.Black // Cambia color del botón
                            isExpanded1 = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Marrón - 1") },
                        onClick = {
                            banda1 = "1"
                            banda1Color = Color(0xFF964B00) // Marrón
                            isExpanded1 = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Rojo - 2") },
                        onClick = {
                            banda1 = "2"
                            banda1Color = Color.Red // Rojo
                            isExpanded1 = false
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Menú desplegable para la Banda 2
            ExposedDropdownMenuBox(
                expanded = isExpanded2,
                onExpandedChange = { isExpanded2 = !isExpanded2 }
            ) {
                TextField(
                    value = banda2 ?: "Banda 2",
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(isExpanded2) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier
                        .menuAnchor()
                        .background(banda2Color) // Fondo del botón cambia con el color
                )
                ExposedDropdownMenu(
                    expanded = isExpanded2,
                    onDismissRequest = { isExpanded2 = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Negro - 0") },
                        onClick = {
                            banda2 = "0"
                            banda2Color = Color.Black // Cambia color del botón
                            isExpanded2 = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Marrón - 1") },
                        onClick = {
                            banda2 = "1"
                            banda2Color = Color(0xFF964B00) // Marrón
                            isExpanded2 = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Rojo - 2") },
                        onClick = {
                            banda2 = "2"
                            banda2Color = Color.Red // Rojo
                            isExpanded2 = false
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Menú desplegable para la Banda 3 (Multiplicador)
            ExposedDropdownMenuBox(
                expanded = isExpanded3,
                onExpandedChange = { isExpanded3 = !isExpanded3 }
            ) {
                TextField(
                    value = banda3 ?: "Banda 3 (Multiplicador)",
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(isExpanded3) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier
                        .menuAnchor()
                        .background(banda3Color) // Fondo del botón cambia con el color
                )
                ExposedDropdownMenu(
                    expanded = isExpanded3,
                    onDismissRequest = { isExpanded3 = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Negro - x1") },
                        onClick = {
                            banda3 = "1"
                            banda3Color = Color.Black // Cambia color del botón
                            isExpanded3 = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Marrón - x10") },
                        onClick = {
                            banda3 = "10"
                            banda3Color = Color(0xFF964B00) // Marrón
                            isExpanded3 = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Rojo - x100") },
                        onClick = {
                            banda3 = "100"
                            banda3Color = Color.Red // Rojo
                            isExpanded3 = false
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para calcular la resistencia
            Button(onClick = {
                Toast.makeText(context, calcularResistencia(), Toast.LENGTH_SHORT).show()
            }) {
                Text("Calcular Resistencia")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Mostrar el valor de la resistencia calculada
            Text(text = "Valor de la resistencia: ${calcularResistencia()}")
        }
    }
}
