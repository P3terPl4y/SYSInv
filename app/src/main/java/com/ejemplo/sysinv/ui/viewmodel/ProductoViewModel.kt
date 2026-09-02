package com.ejemplo.sysinv.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ejemplo.sysinv.data.local.Producto
import com.ejemplo.sysinv.data.repository.ProductoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductoViewModel(private val repository: ProductoRepository) : ViewModel() {
    private val _productos = MutableStateFlow<List<Producto>>(emptyList())
    val productos: StateFlow<List<Producto>> = _productos

    init {
        cargarProductos()
    }

    fun cargarProductos() {
        viewModelScope.launch {
            repository.obtenerTodos().collect { lista ->
                _productos.value = lista
            }
        }
    }

    fun insertar(producto: Producto) {
        viewModelScope.launch { repository.insertar(producto) }
    }

    fun actualizar(producto: Producto) {
        viewModelScope.launch { repository.actualizar(producto) }
    }

    fun eliminar(producto: Producto) {
        viewModelScope.launch { repository.eliminar(producto) }
    }
}
