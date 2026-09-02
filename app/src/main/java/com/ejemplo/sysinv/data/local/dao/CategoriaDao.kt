package com.ejemplo.sysinv.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ejemplo.sysinv.data.local.entities.Categoria
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriaDao {
    @Insert
    suspend fun insertar(categoria: Categoria)

    @Update
    suspend fun actualizar(categoria: Categoria)

    @Query("DELETE FROM categorias WHERE id = :id")
    suspend fun eliminar(id: Int)

    @Query("SELECT * FROM categorias ORDER BY id DESC")
    fun obtenerTodos(): Flow<List<Categoria>>
}
