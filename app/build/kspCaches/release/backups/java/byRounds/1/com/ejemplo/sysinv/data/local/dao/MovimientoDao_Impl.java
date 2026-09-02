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
import com.ejemplo.sysinv.data.local.entities.Movimiento;
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
public final class MovimientoDao_Impl implements MovimientoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Movimiento> __insertionAdapterOfMovimiento;

  public MovimientoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovimiento = new EntityInsertionAdapter<Movimiento>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `movimientos` (`id`,`idProducto`,`tipo`,`cantidad`,`fecha`,`motivo`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Movimiento entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getIdProducto());
        statement.bindString(3, entity.getTipo());
        statement.bindLong(4, entity.getCantidad());
        statement.bindLong(5, entity.getFecha());
        statement.bindString(6, entity.getMotivo());
      }
    };
  }

  @Override
  public Object insertar(final Movimiento movimiento,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMovimiento.insert(movimiento);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Movimiento>> obtenerPorProducto(final int idProducto) {
    final String _sql = "SELECT * FROM movimientos WHERE idProducto = ? ORDER BY fecha DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idProducto);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"movimientos"}, new Callable<List<Movimiento>>() {
      @Override
      @NonNull
      public List<Movimiento> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfIdProducto = CursorUtil.getColumnIndexOrThrow(_cursor, "idProducto");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final int _cursorIndexOfCantidad = CursorUtil.getColumnIndexOrThrow(_cursor, "cantidad");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfMotivo = CursorUtil.getColumnIndexOrThrow(_cursor, "motivo");
          final List<Movimiento> _result = new ArrayList<Movimiento>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Movimiento _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpIdProducto;
            _tmpIdProducto = _cursor.getInt(_cursorIndexOfIdProducto);
            final String _tmpTipo;
            _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
            final int _tmpCantidad;
            _tmpCantidad = _cursor.getInt(_cursorIndexOfCantidad);
            final long _tmpFecha;
            _tmpFecha = _cursor.getLong(_cursorIndexOfFecha);
            final String _tmpMotivo;
            _tmpMotivo = _cursor.getString(_cursorIndexOfMotivo);
            _item = new Movimiento(_tmpId,_tmpIdProducto,_tmpTipo,_tmpCantidad,_tmpFecha,_tmpMotivo);
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
  public Flow<List<Movimiento>> obtenerTodos() {
    final String _sql = "SELECT * FROM movimientos ORDER BY fecha DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"movimientos"}, new Callable<List<Movimiento>>() {
      @Override
      @NonNull
      public List<Movimiento> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfIdProducto = CursorUtil.getColumnIndexOrThrow(_cursor, "idProducto");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final int _cursorIndexOfCantidad = CursorUtil.getColumnIndexOrThrow(_cursor, "cantidad");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final int _cursorIndexOfMotivo = CursorUtil.getColumnIndexOrThrow(_cursor, "motivo");
          final List<Movimiento> _result = new ArrayList<Movimiento>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Movimiento _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpIdProducto;
            _tmpIdProducto = _cursor.getInt(_cursorIndexOfIdProducto);
            final String _tmpTipo;
            _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
            final int _tmpCantidad;
            _tmpCantidad = _cursor.getInt(_cursorIndexOfCantidad);
            final long _tmpFecha;
            _tmpFecha = _cursor.getLong(_cursorIndexOfFecha);
            final String _tmpMotivo;
            _tmpMotivo = _cursor.getString(_cursorIndexOfMotivo);
            _item = new Movimiento(_tmpId,_tmpIdProducto,_tmpTipo,_tmpCantidad,_tmpFecha,_tmpMotivo);
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
