package com.ejemplo.sysinv.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ejemplo.sysinv.data.local.entities.Producto;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ProductoDao_Impl implements ProductoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Producto> __insertionAdapterOfProducto;

  private final EntityDeletionOrUpdateAdapter<Producto> __updateAdapterOfProducto;

  private final SharedSQLiteStatement __preparedStmtOfEliminar;

  private final SharedSQLiteStatement __preparedStmtOfSumarStock;

  private final SharedSQLiteStatement __preparedStmtOfRestarStock;

  public ProductoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProducto = new EntityInsertionAdapter<Producto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `productos` (`id`,`nombre`,`cantidad`,`precio`,`fechaCreacion`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Producto entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNombre());
        statement.bindLong(3, entity.getCantidad());
        statement.bindDouble(4, entity.getPrecio());
        statement.bindLong(5, entity.getFechaCreacion());
      }
    };
    this.__updateAdapterOfProducto = new EntityDeletionOrUpdateAdapter<Producto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `productos` SET `id` = ?,`nombre` = ?,`cantidad` = ?,`precio` = ?,`fechaCreacion` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Producto entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNombre());
        statement.bindLong(3, entity.getCantidad());
        statement.bindDouble(4, entity.getPrecio());
        statement.bindLong(5, entity.getFechaCreacion());
        statement.bindLong(6, entity.getId());
      }
    };
    this.__preparedStmtOfEliminar = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM productos WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfSumarStock = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE productos SET cantidad = cantidad + ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRestarStock = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE productos SET cantidad = cantidad - ? WHERE id = ? AND cantidad >= ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertar(final Producto producto, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProducto.insert(producto);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object actualizar(final Producto producto, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfProducto.handle(producto);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object eliminar(final int id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfEliminar.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfEliminar.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object sumarStock(final int id, final int cantidad,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfSumarStock.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, cantidad);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfSumarStock.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object restarStock(final int id, final int cantidad,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfRestarStock.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, cantidad);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, cantidad);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfRestarStock.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Producto>> obtenerTodos() {
    final String _sql = "SELECT * FROM productos ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"productos"}, new Callable<List<Producto>>() {
      @Override
      @NonNull
      public List<Producto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfCantidad = CursorUtil.getColumnIndexOrThrow(_cursor, "cantidad");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final List<Producto> _result = new ArrayList<Producto>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Producto _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            final int _tmpCantidad;
            _tmpCantidad = _cursor.getInt(_cursorIndexOfCantidad);
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _item = new Producto(_tmpId,_tmpNombre,_tmpCantidad,_tmpPrecio,_tmpFechaCreacion);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object obtenerPorId(final int id, final Continuation<? super Producto> $completion) {
    final String _sql = "SELECT * FROM productos WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Producto>() {
      @Override
      @Nullable
      public Producto call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfCantidad = CursorUtil.getColumnIndexOrThrow(_cursor, "cantidad");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfFechaCreacion = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaCreacion");
          final Producto _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            final int _tmpCantidad;
            _tmpCantidad = _cursor.getInt(_cursorIndexOfCantidad);
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final long _tmpFechaCreacion;
            _tmpFechaCreacion = _cursor.getLong(_cursorIndexOfFechaCreacion);
            _result = new Producto(_tmpId,_tmpNombre,_tmpCantidad,_tmpPrecio,_tmpFechaCreacion);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
