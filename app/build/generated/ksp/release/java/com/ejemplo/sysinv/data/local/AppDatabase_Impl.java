package com.ejemplo.sysinv.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.ejemplo.sysinv.data.local.dao.CategoriaDao;
import com.ejemplo.sysinv.data.local.dao.CategoriaDao_Impl;
import com.ejemplo.sysinv.data.local.dao.CompraDao;
import com.ejemplo.sysinv.data.local.dao.CompraDao_Impl;
import com.ejemplo.sysinv.data.local.dao.MovimientoDao;
import com.ejemplo.sysinv.data.local.dao.MovimientoDao_Impl;
import com.ejemplo.sysinv.data.local.dao.ProductoDao;
import com.ejemplo.sysinv.data.local.dao.ProductoDao_Impl;
import com.ejemplo.sysinv.data.local.dao.ProveedorDao;
import com.ejemplo.sysinv.data.local.dao.ProveedorDao_Impl;
import com.ejemplo.sysinv.data.local.dao.VentaDao;
import com.ejemplo.sysinv.data.local.dao.VentaDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ProductoDao _productoDao;

  private volatile MovimientoDao _movimientoDao;

  private volatile CategoriaDao _categoriaDao;

  private volatile ProveedorDao _proveedorDao;

  private volatile VentaDao _ventaDao;

  private volatile CompraDao _compraDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `productos` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `cantidad` INTEGER NOT NULL, `precio` REAL NOT NULL, `fechaCreacion` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `movimientos` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idProducto` INTEGER NOT NULL, `tipo` TEXT NOT NULL, `cantidad` INTEGER NOT NULL, `fecha` INTEGER NOT NULL, `motivo` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `categorias` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `descripcion` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `proveedores` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `telefono` TEXT NOT NULL, `email` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `ventas` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idProducto` INTEGER NOT NULL, `cantidad` INTEGER NOT NULL, `precioVenta` REAL NOT NULL, `fecha` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `compras` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idProducto` INTEGER NOT NULL, `cantidad` INTEGER NOT NULL, `precioCompra` REAL NOT NULL, `fecha` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '63035cb7c9d75ee6d527daf40e22682c')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `productos`");
        db.execSQL("DROP TABLE IF EXISTS `movimientos`");
        db.execSQL("DROP TABLE IF EXISTS `categorias`");
        db.execSQL("DROP TABLE IF EXISTS `proveedores`");
        db.execSQL("DROP TABLE IF EXISTS `ventas`");
        db.execSQL("DROP TABLE IF EXISTS `compras`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsProductos = new HashMap<String, TableInfo.Column>(5);
        _columnsProductos.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductos.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductos.put("cantidad", new TableInfo.Column("cantidad", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductos.put("precio", new TableInfo.Column("precio", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductos.put("fechaCreacion", new TableInfo.Column("fechaCreacion", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProductos = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProductos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProductos = new TableInfo("productos", _columnsProductos, _foreignKeysProductos, _indicesProductos);
        final TableInfo _existingProductos = TableInfo.read(db, "productos");
        if (!_infoProductos.equals(_existingProductos)) {
          return new RoomOpenHelper.ValidationResult(false, "productos(com.ejemplo.sysinv.data.local.entities.Producto).\n"
                  + " Expected:\n" + _infoProductos + "\n"
                  + " Found:\n" + _existingProductos);
        }
        final HashMap<String, TableInfo.Column> _columnsMovimientos = new HashMap<String, TableInfo.Column>(6);
        _columnsMovimientos.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovimientos.put("idProducto", new TableInfo.Column("idProducto", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovimientos.put("tipo", new TableInfo.Column("tipo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovimientos.put("cantidad", new TableInfo.Column("cantidad", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovimientos.put("fecha", new TableInfo.Column("fecha", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovimientos.put("motivo", new TableInfo.Column("motivo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMovimientos = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMovimientos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMovimientos = new TableInfo("movimientos", _columnsMovimientos, _foreignKeysMovimientos, _indicesMovimientos);
        final TableInfo _existingMovimientos = TableInfo.read(db, "movimientos");
        if (!_infoMovimientos.equals(_existingMovimientos)) {
          return new RoomOpenHelper.ValidationResult(false, "movimientos(com.ejemplo.sysinv.data.local.entities.Movimiento).\n"
                  + " Expected:\n" + _infoMovimientos + "\n"
                  + " Found:\n" + _existingMovimientos);
        }
        final HashMap<String, TableInfo.Column> _columnsCategorias = new HashMap<String, TableInfo.Column>(3);
        _columnsCategorias.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategorias.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategorias.put("descripcion", new TableInfo.Column("descripcion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategorias = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategorias = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategorias = new TableInfo("categorias", _columnsCategorias, _foreignKeysCategorias, _indicesCategorias);
        final TableInfo _existingCategorias = TableInfo.read(db, "categorias");
        if (!_infoCategorias.equals(_existingCategorias)) {
          return new RoomOpenHelper.ValidationResult(false, "categorias(com.ejemplo.sysinv.data.local.entities.Categoria).\n"
                  + " Expected:\n" + _infoCategorias + "\n"
                  + " Found:\n" + _existingCategorias);
        }
        final HashMap<String, TableInfo.Column> _columnsProveedores = new HashMap<String, TableInfo.Column>(4);
        _columnsProveedores.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProveedores.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProveedores.put("telefono", new TableInfo.Column("telefono", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProveedores.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProveedores = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProveedores = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProveedores = new TableInfo("proveedores", _columnsProveedores, _foreignKeysProveedores, _indicesProveedores);
        final TableInfo _existingProveedores = TableInfo.read(db, "proveedores");
        if (!_infoProveedores.equals(_existingProveedores)) {
          return new RoomOpenHelper.ValidationResult(false, "proveedores(com.ejemplo.sysinv.data.local.entities.Proveedor).\n"
                  + " Expected:\n" + _infoProveedores + "\n"
                  + " Found:\n" + _existingProveedores);
        }
        final HashMap<String, TableInfo.Column> _columnsVentas = new HashMap<String, TableInfo.Column>(5);
        _columnsVentas.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVentas.put("idProducto", new TableInfo.Column("idProducto", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVentas.put("cantidad", new TableInfo.Column("cantidad", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVentas.put("precioVenta", new TableInfo.Column("precioVenta", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVentas.put("fecha", new TableInfo.Column("fecha", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysVentas = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesVentas = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVentas = new TableInfo("ventas", _columnsVentas, _foreignKeysVentas, _indicesVentas);
        final TableInfo _existingVentas = TableInfo.read(db, "ventas");
        if (!_infoVentas.equals(_existingVentas)) {
          return new RoomOpenHelper.ValidationResult(false, "ventas(com.ejemplo.sysinv.data.local.entities.Venta).\n"
                  + " Expected:\n" + _infoVentas + "\n"
                  + " Found:\n" + _existingVentas);
        }
        final HashMap<String, TableInfo.Column> _columnsCompras = new HashMap<String, TableInfo.Column>(5);
        _columnsCompras.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCompras.put("idProducto", new TableInfo.Column("idProducto", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCompras.put("cantidad", new TableInfo.Column("cantidad", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCompras.put("precioCompra", new TableInfo.Column("precioCompra", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCompras.put("fecha", new TableInfo.Column("fecha", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCompras = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCompras = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCompras = new TableInfo("compras", _columnsCompras, _foreignKeysCompras, _indicesCompras);
        final TableInfo _existingCompras = TableInfo.read(db, "compras");
        if (!_infoCompras.equals(_existingCompras)) {
          return new RoomOpenHelper.ValidationResult(false, "compras(com.ejemplo.sysinv.data.local.entities.Compra).\n"
                  + " Expected:\n" + _infoCompras + "\n"
                  + " Found:\n" + _existingCompras);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "63035cb7c9d75ee6d527daf40e22682c", "ebbfb54c4e86c16308a7faac92b5678a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "productos","movimientos","categorias","proveedores","ventas","compras");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `productos`");
      _db.execSQL("DELETE FROM `movimientos`");
      _db.execSQL("DELETE FROM `categorias`");
      _db.execSQL("DELETE FROM `proveedores`");
      _db.execSQL("DELETE FROM `ventas`");
      _db.execSQL("DELETE FROM `compras`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ProductoDao.class, ProductoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MovimientoDao.class, MovimientoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CategoriaDao.class, CategoriaDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProveedorDao.class, ProveedorDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(VentaDao.class, VentaDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CompraDao.class, CompraDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ProductoDao productoDao() {
    if (_productoDao != null) {
      return _productoDao;
    } else {
      synchronized(this) {
        if(_productoDao == null) {
          _productoDao = new ProductoDao_Impl(this);
        }
        return _productoDao;
      }
    }
  }

  @Override
  public MovimientoDao movimientoDao() {
    if (_movimientoDao != null) {
      return _movimientoDao;
    } else {
      synchronized(this) {
        if(_movimientoDao == null) {
          _movimientoDao = new MovimientoDao_Impl(this);
        }
        return _movimientoDao;
      }
    }
  }

  @Override
  public CategoriaDao categoriaDao() {
    if (_categoriaDao != null) {
      return _categoriaDao;
    } else {
      synchronized(this) {
        if(_categoriaDao == null) {
          _categoriaDao = new CategoriaDao_Impl(this);
        }
        return _categoriaDao;
      }
    }
  }

  @Override
  public ProveedorDao proveedorDao() {
    if (_proveedorDao != null) {
      return _proveedorDao;
    } else {
      synchronized(this) {
        if(_proveedorDao == null) {
          _proveedorDao = new ProveedorDao_Impl(this);
        }
        return _proveedorDao;
      }
    }
  }

  @Override
  public VentaDao ventaDao() {
    if (_ventaDao != null) {
      return _ventaDao;
    } else {
      synchronized(this) {
        if(_ventaDao == null) {
          _ventaDao = new VentaDao_Impl(this);
        }
        return _ventaDao;
      }
    }
  }

  @Override
  public CompraDao compraDao() {
    if (_compraDao != null) {
      return _compraDao;
    } else {
      synchronized(this) {
        if(_compraDao == null) {
          _compraDao = new CompraDao_Impl(this);
        }
        return _compraDao;
      }
    }
  }
}
