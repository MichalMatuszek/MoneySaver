package pl.mmatuszek.moneysaver.contract.util.database.migrations;

import pl.mmatuszek.moneysaver.contract.entity.Cost;
import pl.mmatuszek.moneysaver.contract.entity.CostType;

/**
 * Created by Michal on 2016-05-21.
 */
public class Migration_0001 extends BaseMigration {
    public Migration_0001(){
        steps.add("CREATE TABLE " + CostType.TABLE + " (" + CostType._ID + " INTEGER PRIMARY KEY, " + CostType.NAME + " TEXT)");
        steps.add("CREATE TABLE " + Cost.TABLE + " (" + Cost._ID + " INTEGER PRIMARY KEY, " + Cost.NAME + " TEXT, " + Cost.COST_TYPE + " INTEGER, " + Cost.VALUE + " REAL, " + Cost.DATE + " INTEGER, FOREIGN KEY(" + Cost.COST_TYPE +") REFERENCES " + CostType.TABLE + " (" + CostType._ID + "))");
    }
}
