package com.ejemplo.sysinv.data.repository

import com.ejemplo.sysinv.data.local.Producto
import com.ejemplo.sysinv.data.local.ProductoDao
import kotlinx.coroutines.flow.Flow

class ProductoRepository(private val dao: ProductoDao) {
    fun obtenerTodos(): Flow<List<Producto>> = dao.obtenerTodos()
    suspend fun insertar(producto: Producto) = dao.insertar(producto)
    suspend fun actualizar(producto: Producto) = dao.actualizar(producto)
    suspend fun eliminar(producto: Producto) = dao.eliminar(producto)
}
