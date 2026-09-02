package com.ejemplo.sysinv.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class Producto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    var cantidad: Int = 0,
    val precio: Double,
    val fechaCreacion: Long = System.currentTimeMillis()
)
