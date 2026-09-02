package com.ejemplo.sysinv.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ejemplo.sysinv.data.local.entities.Movimiento
import kotlinx.coroutines.flow.Flow

@Dao
interface MovimientoDao {
    @Insert
    suspend fun insertar(movimiento: Movimiento)

    @Query("SELECT * FROM movimientos WHERE idProducto = :idProducto ORDER BY fecha DESC")
    fun obtenerPorProducto(idProducto: Int): Flow<List<Movimiento>>

    @Query("SELECT * FROM movimientos ORDER BY fecha DESC")
    fun obtenerTodos(): Flow<List<Movimiento>>
}
