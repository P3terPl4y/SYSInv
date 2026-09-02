package com.ejemplo.sysinv.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ejemplo.sysinv.data.local.entities.Producto
import com.ejemplo.sysinv.data.repository.ProductoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductoViewModel(private val repository: ProductoRepository) : ViewModel() {
    private val _productos = MutableStateFlow<List<Producto>>(emptyList())
    val productos: StateFlow<List<Producto>> = _productos

    init {
        cargar()
    }

    fun cargar() {
        viewModelScope.launch {
            repository.obtenerTodos().collect { lista ->
                _productos.value = lista
            }
        }
    }

    fun insertar(producto: Producto) {
        viewModelScope.launch {
            repository.insertar(producto)
            cargar()
        }
    }

    fun actualizar(producto: Producto) {
        viewModelScope.launch {
            repository.actualizar(producto)
            cargar()
        }
    }

    fun eliminar(id: Int) {
        viewModelScope.launch {
            repository.eliminar(id)
            cargar()
        }
    }

    suspend fun obtenerProducto(id: Int) = repository.obtenerPorId(id)

    suspend fun registrarEntrada(idProducto: Int, cantidad: Int) {
        repository.sumarStock(idProducto, cantidad)
    }

    suspend fun registrarSalida(idProducto: Int, cantidad: Int) {
        repository.restarStock(idProducto, cantidad)
    }
}
