package com.ejemplo.sysinv.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "compras")
data class Compra(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idProducto: Int,
    val cantidad: Int,
    val precioCompra: Double,
    val fecha: Long = System.currentTimeMillis()
)
