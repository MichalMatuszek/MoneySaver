package pl.mmatuszek.moneysaver.implementations.dao;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import pl.mmatuszek.moneysaver.contract.entity.CostType;
import pl.mmatuszek.moneysaver.interfaces.dao.ICostTypeDAO;

/**
 * Created by Michal on 2016-05-23.
 */
public class CostTypeDAO extends BaseDAO<CostType> implements ICostTypeDAO {
    @Override
    public List<CostType> getAll() {
        List<CostType> result = new ArrayList<CostType>();
        Cursor cursor = loadAll(CostType.TABLE,CostType.COLUMNS);
        if(cursor.moveToFirst()){
            do {
                CostType costType = new CostType();
                mapCursorToEntity(cursor,costType);
                result.add(costType);
            }while(cursor.moveToNext());
        }

        return result;
    }

    @Override
    public CostType findById(long id) {
        String selection = "_id = ?";
        String[] args = {Long.toString(id)};
        Cursor cursor = loadAll(CostType.TABLE,CostType.COLUMNS,selection,args);
        CostType costType = null;
        if(cursor.moveToFirst()){
            costType = new CostType();
            mapCursorToEntity(cursor,costType);
        }

        return costType;
    }

    @Override
    public void saveOrUpdate(CostType costType) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CostType.NAME, costType.getName());

        if(costType.getId() <= 0){
            insert(CostType.TABLE,contentValues);
        } else {
            String selection = "_ID = ?";
            String[] args = {Long.toString(costType.getId())};
            update(CostType.TABLE,contentValues, selection, args);
        }
    }

    public void mapCursorToEntity(Cursor cursor, CostType costType) {
        costType.setId(cursor.getInt(cursor.getColumnIndex(CostType._ID)));
        costType.setName(cursor.getString(cursor.getColumnIndex(CostType.NAME)));
    }
}
