package com.ejemplo.sysinv.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ejemplo.sysinv.data.local.entities.Producto
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductoDao {
    @Insert
    suspend fun insertar(producto: Producto)

    @Update
    suspend fun actualizar(producto: Producto)

    @Query("DELETE FROM productos WHERE id = :id")
    suspend fun eliminar(id: Int)

    @Query("SELECT * FROM productos ORDER BY id DESC")
    fun obtenerTodos(): Flow<List<Producto>>

    @Query("SELECT * FROM productos WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Producto?

    @Query("UPDATE productos SET cantidad = cantidad + :cantidad WHERE id = :id")
    suspend fun sumarStock(id: Int, cantidad: Int)

    @Query("UPDATE productos SET cantidad = cantidad - :cantidad WHERE id = :id AND cantidad >= :cantidad")
    suspend fun restarStock(id: Int, cantidad: Int)
}
