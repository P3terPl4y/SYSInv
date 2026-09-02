package com.ejemplo.sysinv.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "proveedores")
data class Proveedor(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val telefono: String = "",
    val email: String = ""
)
