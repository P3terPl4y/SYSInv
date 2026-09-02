package com.ejemplo.sysinv.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ejemplo.sysinv.data.local.dao.*
import com.ejemplo.sysinv.data.local.entities.*

@Database(
    entities = [Producto::class, Movimiento::class, Categoria::class, Proveedor::class, Venta::class, Compra::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productoDao(): ProductoDao
    abstract fun movimientoDao(): MovimientoDao
    abstract fun categoriaDao(): CategoriaDao
    abstract fun proveedorDao(): ProveedorDao
    abstract fun ventaDao(): VentaDao
    abstract fun compraDao(): CompraDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "sysinv.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
