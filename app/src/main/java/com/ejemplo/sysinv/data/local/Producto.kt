package com.ejemplo.sysinv.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "productos")
data class Producto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val cantidad: Int,
    val precio: Double,
    val fechaCreacion: Long = System.currentTimeMillis()
)
