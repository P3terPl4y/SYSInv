package com.ejemplo.sysinv.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movimientos")
data class Movimiento(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idProducto: Int,
    val tipo: String, // "entrada" o "salida"
    val cantidad: Int,
    val fecha: Long = System.currentTimeMillis(),
    val motivo: String = ""
)
