package com.ejemplo.sysinv.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ventas")
data class Venta(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idProducto: Int,
    val cantidad: Int,
    val precioVenta: Double,
    val fecha: Long = System.currentTimeMillis()
)
