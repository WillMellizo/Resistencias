package com.example.prueba.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.widget.Toast
import androidx.compose.foundation.layout.size

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun textos() {
    val context = LocalContext.current

    var banda1 by remember { mutableStateOf<String?>(null) }
    var isExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded } // Alterna el estado expandido
        ) {
            TextField(
                value = banda1 ?: "Valor banda 1", // Valor por defecto o el valor de banda1
                onValueChange = {},
                readOnly = true, // Solo lectura
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(isExpanded) }, // Ícono desplegable
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                // Opción 1: Negro - 0
                DropdownMenuItem(
                    text = {
                        Row {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .background(Color.Black)
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espacio entre el color y el texto
                            Text("Negro - 0")
                        }
                    },
                    onClick = {
                        banda1 = "0" // Valor para banda1
                        isExpanded = false // Cierra el menú
                        Toast.makeText(context, "SELECCIONO OPCION 1", Toast.LENGTH_SHORT).show()
                    }
                )
                // Opción 2: Azul - 2
                DropdownMenuItem(
                    text = {
                        Row {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .background(Color.Blue)
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espacio entre el color y el texto
                            Text("Azul - 2")
                        }
                    },
                    onClick = {
                        banda1 = "2" // Valor para banda1
                        isExpanded = false // Cierra el menú
                        Toast.makeText(context, "SELECCIONO OPCION 2", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}
