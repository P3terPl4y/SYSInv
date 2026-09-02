package com.ejemplo.sysinv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ejemplo.sysinv.data.local.AppDatabase
import com.ejemplo.sysinv.data.local.Producto
import com.ejemplo.sysinv.data.repository.ProductoRepository
import com.ejemplo.sysinv.ui.screens.ProductoFormScreen
import com.ejemplo.sysinv.ui.screens.ProductoListScreen
import com.ejemplo.sysinv.ui.viewmodel.ProductoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AppDatabase.getInstance(this)
        val repository = ProductoRepository(db.productoDao())

        setContent {
            val viewModel: ProductoViewModel = viewModel(
                factory = ProductoViewModelFactory(repository)
            )
            var showForm by remember { mutableStateOf(false) }
            var productoEditar by remember { mutableStateOf<Producto?>(null) }

            if (showForm) {
                ProductoFormScreen(
                    viewModel = viewModel,
                    productoEditar = productoEditar,
                    onSave = {
                        showForm = false
                        productoEditar = null
                    }
                )
            } else {
                ProductoListScreen(
                    onAdd = {
                        productoEditar = null
                        showForm = true
                    },
                    onEdit = { producto ->
                        productoEditar = producto
                        showForm = true
                    },
                    viewModel = viewModel
                )
            }
        }
    }
}

class ProductoViewModelFactory(private val repository: ProductoRepository) : androidx.lifecycle.ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
