package pl.mmatuszek.moneysaver.contract.entity;

import android.provider.BaseColumns;

/**
 * Created by Michal on 2016-05-21.
 */
public interface IBaseEntity extends BaseColumns{
    public static String TABLE =null;
    public static String[] COLUMNS =null;
    public long getId();
    public void setId(long id);
}
