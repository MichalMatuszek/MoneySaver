package pl.mmatuszek.moneysaver.implementations.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import pl.mmatuszek.moneysaver.contract.util.database.DbContext;
import pl.mmatuszek.moneysaver.interfaces.dao.IBaseDAO;

/**
 * Created by Michal on 2016-05-23.
 */
public abstract class BaseDAO<TEntity> implements IBaseDAO {
    protected DbContext db;

    @Override
    public void setContext(Context context) {
        this.db = new DbContext(context);
    }

    public void insert(String table, ContentValues contentValues) {
        db.getWritableDatabase().insert(table,null,contentValues);
    }

    public Cursor loadAll(String table, String[] columns){
        return db.getReadableDatabase().query(table,columns,null,null,null,null,null);
    }

    public Cursor loadAll(String table, String[] columns, String selection, String[] args) {
        return db.getReadableDatabase().query(table,columns,selection,args,null,null,null);
    }

    public void update(String table, ContentValues contentValues, String selection, String[] args) {
        db.getWritableDatabase().update(table,contentValues,selection,args);
    }

    public abstract void mapCursorToEntity(Cursor cursor, TEntity entity);
}
