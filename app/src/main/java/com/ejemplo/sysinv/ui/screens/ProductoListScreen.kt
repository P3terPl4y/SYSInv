package com.ejemplo.sysinv.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ejemplo.sysinv.data.local.entities.Producto
import com.ejemplo.sysinv.ui.viewmodel.ProductoViewModel

@Composable
fun ProductoListScreen(
    onAdd: () -> Unit,
    onEdit: (Producto) -> Unit,
    viewModel: ProductoViewModel = viewModel()
) {
    val productos by viewModel.productos.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAdd) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            if (productos.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("No hay productos")
                }
            } else {
                LazyColumn {
                    items(productos) { producto ->
                        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = producto.nombre, style = MaterialTheme.typography.titleLarge)
                                Text("Stock: ${producto.cantidad}")
                                Text("Precio: $${"%.2f".format(producto.precio)}")
                                Row {
                                    Button(onClick = { onEdit(producto) }) { Text("Editar") }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Button(
                                        onClick = { viewModel.eliminar(producto.id) },
                                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                                    ) { Text("Eliminar") }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
