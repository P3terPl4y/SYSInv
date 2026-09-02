package com.ejemplo.sysinv.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ejemplo.sysinv.data.local.entities.Venta
import kotlinx.coroutines.flow.Flow

@Dao
interface VentaDao {
    @Insert
    suspend fun insertar(venta: Venta)

    @Query("SELECT * FROM ventas WHERE idProducto = :idProducto ORDER BY fecha DESC")
    fun obtenerPorProducto(idProducto: Int): Flow<List<Venta>>

    @Query("SELECT * FROM ventas ORDER BY fecha DESC")
    fun obtenerTodos(): Flow<List<Venta>>
}
