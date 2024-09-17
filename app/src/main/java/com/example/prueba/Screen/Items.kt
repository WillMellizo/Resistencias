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

    // Variables para las tres bandas de colores, multiplicador, tolerancia y sus colores asociados
    var banda1 by remember { mutableStateOf<String?>(null) }
    var banda2 by remember { mutableStateOf<String?>(null) }
    var banda3 by remember { mutableStateOf<String?>(null) }
    var tolerancia by remember { mutableStateOf<String?>(null) }

    var banda1Color by remember { mutableStateOf(Color.LightGray) }
    var banda2Color by remember { mutableStateOf(Color.LightGray) }
    var banda3Color by remember { mutableStateOf(Color.LightGray) }
    var toleranciaColor by remember { mutableStateOf(Color.LightGray) }

    var isExpanded1 by remember { mutableStateOf(false) }
    var isExpanded2 by remember { mutableStateOf(false) }
    var isExpanded3 by remember { mutableStateOf(false) }
    var isExpandedTolerancia by remember { mutableStateOf(false) }

    // Función para calcular el valor de la resistencia
    fun calcularResistencia(): String {
        val digito1 = banda1?.toIntOrNull() ?: return "Seleccione bandas"
        val digito2 = banda2?.toIntOrNull() ?: return "Seleccione bandas"
        val multiplicador = banda3?.toFloatOrNull() ?: return "Seleccione bandas"
        val resistencia = (digito1 * 10 + digito2) * multiplicador
        return "$resistencia Ω ±${tolerancia ?: "20%"}"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título centrado
            Text(
                text = "Cálculo del valor de la resistencia",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
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
                        .background(banda1Color)
                )
                ExposedDropdownMenu(
                    expanded = isExpanded1,
                    onDismissRequest = { isExpanded1 = false }
                ) {
                    // Colores para banda 1
                    DropdownMenuItem(text = { Text("Negro - 0") }, onClick = {
                        banda1 = "0"; banda1Color = Color.Black; isExpanded1 = false
                    })
                    DropdownMenuItem(text = { Text("Marrón - 1") }, onClick = {
                        banda1 = "1"; banda1Color = Color(0xFF964B00); isExpanded1 = false
                    })
                    DropdownMenuItem(text = { Text("Rojo - 2") }, onClick = {
                        banda1 = "2"; banda1Color = Color.Red; isExpanded1 = false
                    })
                    DropdownMenuItem(text = { Text("Naranja - 3") }, onClick = {
                        banda1 = "3"; banda1Color = Color(0xFFFFA500); isExpanded1 = false
                    })
                    DropdownMenuItem(text = { Text("Amarillo - 4") }, onClick = {
                        banda1 = "4"; banda1Color = Color.Yellow; isExpanded1 = false
                    })
                    DropdownMenuItem(text = { Text("Verde - 5") }, onClick = {
                        banda1 = "5"; banda1Color = Color.Green; isExpanded1 = false
                    })
                    DropdownMenuItem(text = { Text("Azul - 6") }, onClick = {
                        banda1 = "6"; banda1Color = Color.Blue; isExpanded1 = false
                    })
                    DropdownMenuItem(text = { Text("Violeta - 7") }, onClick = {
                        banda1 = "7"; banda1Color = Color(0xFF8B00FF); isExpanded1 = false
                    })
                    DropdownMenuItem(text = { Text("Gris - 8") }, onClick = {
                        banda1 = "8"; banda1Color = Color.Gray; isExpanded1 = false
                    })
                    DropdownMenuItem(text = { Text("Blanco - 9") }, onClick = {
                        banda1 = "9"; banda1Color = Color.White; isExpanded1 = false
                    })
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
                        .background(banda2Color)
                )
                ExposedDropdownMenu(
                    expanded = isExpanded2,
                    onDismissRequest = { isExpanded2 = false }
                ) {
                    // Colores para banda 2 (igual que banda 1)
                    DropdownMenuItem(text = { Text("Negro - 0") }, onClick = {
                        banda2 = "0"; banda2Color = Color.Black; isExpanded2 = false
                    })
                    DropdownMenuItem(text = { Text("Marrón - 1") }, onClick = {
                        banda2 = "1"; banda2Color = Color(0xFF964B00); isExpanded2 = false
                    })
                    DropdownMenuItem(text = { Text("Rojo - 2") }, onClick = {
                        banda2 = "2"; banda2Color = Color.Red; isExpanded2 = false
                    })
                    DropdownMenuItem(text = { Text("Naranja - 3") }, onClick = {
                        banda2 = "3"; banda2Color = Color(0xFFFFA500); isExpanded2 = false
                    })
                    DropdownMenuItem(text = { Text("Amarillo - 4") }, onClick = {
                        banda2 = "4"; banda2Color = Color.Yellow; isExpanded2 = false
                    })
                    DropdownMenuItem(text = { Text("Verde - 5") }, onClick = {
                        banda2 = "5"; banda2Color = Color.Green; isExpanded2 = false
                    })
                    DropdownMenuItem(text = { Text("Azul - 6") }, onClick = {
                        banda2 = "6"; banda2Color = Color.Blue; isExpanded2 = false
                    })
                    DropdownMenuItem(text = { Text("Violeta - 7") }, onClick = {
                        banda2 = "7"; banda2Color = Color(0xFF8B00FF); isExpanded2 = false
                    })
                    DropdownMenuItem(text = { Text("Gris - 8") }, onClick = {
                        banda2 = "8"; banda2Color = Color.Gray; isExpanded2 = false
                    })
                    DropdownMenuItem(text = { Text("Blanco - 9") }, onClick = {
                        banda2 = "9"; banda2Color = Color.White; isExpanded2 = false
                    })
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Menú desplegable para la Banda 3 (Multiplicador)
            ExposedDropdownMenuBox(
                expanded = isExpanded3,
                onExpandedChange = { isExpanded3 = !isExpanded3 }
            ) {
                TextField(
                    value = banda3 ?: "Multiplicador",
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(isExpanded3) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier
                        .menuAnchor()
                        .background(banda3Color)
                )
                ExposedDropdownMenu(
                    expanded = isExpanded3,
                    onDismissRequest = { isExpanded3 = false }
                ) {
                    // Colores para multiplicador
                    DropdownMenuItem(text = { Text("Negro - x1") }, onClick = {
                        banda3 = "1"; banda3Color = Color.Black; isExpanded3 = false
                    })
                    DropdownMenuItem(text = { Text("Marrón - x10") }, onClick = {
                        banda3 = "10"; banda3Color = Color(0xFF964B00); isExpanded3 = false
                    })
                    DropdownMenuItem(text = { Text("Rojo - x100") }, onClick = {
                        banda3 = "100"; banda3Color = Color.Red; isExpanded3 = false
                    })
                    DropdownMenuItem(text = { Text("Naranja - x1K") }, onClick = {
                        banda3 = "1000"; banda3Color = Color(0xFFFFA500); isExpanded3 = false
                    })
                    DropdownMenuItem(text = { Text("Amarillo - x10K") }, onClick = {
                        banda3 = "10000"; banda3Color = Color.Yellow; isExpanded3 = false
                    })
                    DropdownMenuItem(text = { Text("Verde - x100K") }, onClick = {
                        banda3 = "100000"; banda3Color = Color.Green; isExpanded3 = false
                    })
                    DropdownMenuItem(text = { Text("Azul - x1M") }, onClick = {
                        banda3 = "1000000"; banda3Color = Color.Blue; isExpanded3 = false
                    })
                    DropdownMenuItem(text = { Text("Violeta - x10M") }, onClick = {
                        banda3 = "10000000"; banda3Color = Color(0xFF8B00FF); isExpanded3 = false
                    })
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Menú desplegable para la tolerancia
            ExposedDropdownMenuBox(
                expanded = isExpandedTolerancia,
                onExpandedChange = { isExpandedTolerancia = !isExpandedTolerancia }
            ) {
                TextField(
                    value = tolerancia ?: "Tolerancia",
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(isExpandedTolerancia) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier
                        .menuAnchor()
                        .background(toleranciaColor)
                )
                ExposedDropdownMenu(
                    expanded = isExpandedTolerancia,
                    onDismissRequest = { isExpandedTolerancia = false }
                ) {
                    // Colores para tolerancia
                    DropdownMenuItem(text = { Text("Dorado - ±5%") }, onClick = {
                        tolerancia = "5%"; toleranciaColor = Color(0xFFFFD700); isExpandedTolerancia = false
                    })
                    DropdownMenuItem(text = { Text("Plateado - ±10%") }, onClick = {
                        tolerancia = "10%"; toleranciaColor = Color(0xFFC0C0C0); isExpandedTolerancia = false
                    })
                    DropdownMenuItem(text = { Text("Ninguno - ±20%") }, onClick = {
                        tolerancia = "20%"; toleranciaColor = Color.LightGray; isExpandedTolerancia = false
                    })
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
