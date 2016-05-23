package pl.mmatuszek.moneysaver.contract.entity;

import java.util.Date;

/**
 * Created by Michal on 2016-05-21.
 */
public class Cost implements IBaseEntity{
    public static final String NAME = "Name";
    public static final String DATE = "Date";
    public static final String COST_TYPE = "Type";
    public static final String VALUE = "Value";


    public static final String TABLE = "Costs";
    public static final String[] COLUMNS = {_ID, NAME, DATE, COST_TYPE, VALUE };

    private long id;
    private String name;
    private Date date;
    private long type;
    private float value;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
