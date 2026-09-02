package com.ejemplo.sysinv.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ejemplo.sysinv.data.local.entities.Compra
import kotlinx.coroutines.flow.Flow

@Dao
interface CompraDao {
    @Insert
    suspend fun insertar(compra: Compra)

    @Query("SELECT * FROM compras WHERE idProducto = :idProducto ORDER BY fecha DESC")
    fun obtenerPorProducto(idProducto: Int): Flow<List<Compra>>

    @Query("SELECT * FROM compras ORDER BY fecha DESC")
    fun obtenerTodos(): Flow<List<Compra>>
}
