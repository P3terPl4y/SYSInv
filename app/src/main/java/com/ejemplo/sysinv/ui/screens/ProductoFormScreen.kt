package com.ejemplo.sysinv.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ejemplo.sysinv.data.local.Producto
import com.ejemplo.sysinv.ui.viewmodel.ProductoViewModel

@Composable
fun ProductoFormScreen(
    viewModel: ProductoViewModel,
    productoEditar: Producto? = null,
    onSave: () -> Unit
) {
    var nombre by remember { mutableStateOf(productoEditar?.nombre ?: "") }
    var cantidad by remember { mutableStateOf(productoEditar?.cantidad?.toString() ?: "") }
    var precio by remember { mutableStateOf(productoEditar?.precio?.toString() ?: "") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val cant = cantidad.toIntOrNull()
                val prec = precio.toDoubleOrNull()
                if (nombre.isNotBlank() && cant != null && prec != null) {
                    if (productoEditar == null) {
                        viewModel.insertar(Producto(nombre = nombre, cantidad = cant, precio = prec))
                    } else {
                        viewModel.actualizar(productoEditar.copy(nombre = nombre, cantidad = cant, precio = prec))
                    }
                    onSave()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (productoEditar == null) "Agregar" else "Actualizar")
        }
    }
}
