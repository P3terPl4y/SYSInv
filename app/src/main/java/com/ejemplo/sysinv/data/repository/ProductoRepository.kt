package com.ejemplo.sysinv.data.repository

import com.ejemplo.sysinv.data.local.dao.ProductoDao
import com.ejemplo.sysinv.data.local.entities.Producto
import kotlinx.coroutines.flow.Flow

class ProductoRepository(private val dao: ProductoDao) {
    fun obtenerTodos(): Flow<List<Producto>> = dao.obtenerTodos()
    suspend fun insertar(producto: Producto) = dao.insertar(producto)
    suspend fun actualizar(producto: Producto) = dao.actualizar(producto)
    suspend fun eliminar(id: Int) = dao.eliminar(id)
    suspend fun obtenerPorId(id: Int) = dao.obtenerPorId(id)
    suspend fun sumarStock(id: Int, cantidad: Int) = dao.sumarStock(id, cantidad)
    suspend fun restarStock(id: Int, cantidad: Int) = dao.restarStock(id, cantidad)
}
