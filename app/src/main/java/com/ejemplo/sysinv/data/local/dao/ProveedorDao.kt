package com.ejemplo.sysinv.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ejemplo.sysinv.data.local.entities.Proveedor
import kotlinx.coroutines.flow.Flow

@Dao
interface ProveedorDao {
    @Insert
    suspend fun insertar(proveedor: Proveedor)

    @Update
    suspend fun actualizar(proveedor: Proveedor)

    @Query("DELETE FROM proveedores WHERE id = :id")
    suspend fun eliminar(id: Int)

    @Query("SELECT * FROM proveedores ORDER BY id DESC")
    fun obtenerTodos(): Flow<List<Proveedor>>
}
