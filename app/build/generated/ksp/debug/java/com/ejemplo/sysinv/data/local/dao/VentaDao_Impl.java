package com.ejemplo.sysinv.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ejemplo.sysinv.data.local.entities.Venta;
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
public final class VentaDao_Impl implements VentaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Venta> __insertionAdapterOfVenta;

  public VentaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVenta = new EntityInsertionAdapter<Venta>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `ventas` (`id`,`idProducto`,`cantidad`,`precioVenta`,`fecha`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Venta entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getIdProducto());
        statement.bindLong(3, entity.getCantidad());
        statement.bindDouble(4, entity.getPrecioVenta());
        statement.bindLong(5, entity.getFecha());
      }
    };
  }

  @Override
  public Object insertar(final Venta venta, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfVenta.insert(venta);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Venta>> obtenerPorProducto(final int idProducto) {
    final String _sql = "SELECT * FROM ventas WHERE idProducto = ? ORDER BY fecha DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idProducto);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ventas"}, new Callable<List<Venta>>() {
      @Override
      @NonNull
      public List<Venta> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfIdProducto = CursorUtil.getColumnIndexOrThrow(_cursor, "idProducto");
          final int _cursorIndexOfCantidad = CursorUtil.getColumnIndexOrThrow(_cursor, "cantidad");
          final int _cursorIndexOfPrecioVenta = CursorUtil.getColumnIndexOrThrow(_cursor, "precioVenta");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final List<Venta> _result = new ArrayList<Venta>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Venta _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpIdProducto;
            _tmpIdProducto = _cursor.getInt(_cursorIndexOfIdProducto);
            final int _tmpCantidad;
            _tmpCantidad = _cursor.getInt(_cursorIndexOfCantidad);
            final double _tmpPrecioVenta;
            _tmpPrecioVenta = _cursor.getDouble(_cursorIndexOfPrecioVenta);
            final long _tmpFecha;
            _tmpFecha = _cursor.getLong(_cursorIndexOfFecha);
            _item = new Venta(_tmpId,_tmpIdProducto,_tmpCantidad,_tmpPrecioVenta,_tmpFecha);
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
  public Flow<List<Venta>> obtenerTodos() {
    final String _sql = "SELECT * FROM ventas ORDER BY fecha DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ventas"}, new Callable<List<Venta>>() {
      @Override
      @NonNull
      public List<Venta> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfIdProducto = CursorUtil.getColumnIndexOrThrow(_cursor, "idProducto");
          final int _cursorIndexOfCantidad = CursorUtil.getColumnIndexOrThrow(_cursor, "cantidad");
          final int _cursorIndexOfPrecioVenta = CursorUtil.getColumnIndexOrThrow(_cursor, "precioVenta");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final List<Venta> _result = new ArrayList<Venta>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Venta _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpIdProducto;
            _tmpIdProducto = _cursor.getInt(_cursorIndexOfIdProducto);
            final int _tmpCantidad;
            _tmpCantidad = _cursor.getInt(_cursorIndexOfCantidad);
            final double _tmpPrecioVenta;
            _tmpPrecioVenta = _cursor.getDouble(_cursorIndexOfPrecioVenta);
            final long _tmpFecha;
            _tmpFecha = _cursor.getLong(_cursorIndexOfFecha);
            _item = new Venta(_tmpId,_tmpIdProducto,_tmpCantidad,_tmpPrecioVenta,_tmpFecha);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
