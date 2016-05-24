package pl.mmatuszek.moneysaver.implementations.dao;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.Date;
import java.util.List;

import pl.mmatuszek.moneysaver.contract.entity.Cost;
import pl.mmatuszek.moneysaver.interfaces.dao.ICostDAO;

/**
 * Created by Michal on 2016-05-23.
 */
public class CostDAO extends BaseDAO<Cost> implements ICostDAO {
    @Override
    public Cost findById(long id) {
        String selection = "_ID = ?";
        String[] args = {Long.toString(id)};
        Cursor cursor = loadAll(Cost.TABLE,Cost.COLUMNS,selection,args);
        Cost cost = null;
        if(cursor.moveToFirst()){
            cost = new Cost();
            mapCursorToEntity(cursor,cost);
        }

        return cost;
    }

    @Override
    public void saveOrUpdate(Cost cost) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Cost.COST_TYPE,cost.getType());
        contentValues.put(Cost.DATE,cost.getDate().getTime());
        contentValues.put(Cost.NAME, cost.getName());
        contentValues.put(Cost.VALUE, cost.getValue());

        if(cost.getId() <= 0){
            insert(Cost.TABLE,contentValues);
        } else {
            String selection = "_ID = ?";
            String[] args = {Long.toString(cost.getId())};
            update(Cost.TABLE,contentValues,selection,args);
        }
    }

    @Override
    public List<Cost> getLastAddedCosts(int count) {
        return null;
    }

    public void mapCursorToEntity(Cursor cursor, Cost cost){
        cost.setId(cursor.getInt(cursor.getColumnIndex(Cost._ID)));
        cost.setName(cursor.getString(cursor.getColumnIndex(Cost.NAME)));
        cost.setDate(new Date(cursor.getLong(cursor.getColumnIndex(Cost.DATE))));
        cost.setType(cursor.getLong(cursor.getColumnIndex(Cost.COST_TYPE)));
        cost.setValue(cursor.getFloat(cursor.getColumnIndex(Cost.VALUE)));
    }
}
