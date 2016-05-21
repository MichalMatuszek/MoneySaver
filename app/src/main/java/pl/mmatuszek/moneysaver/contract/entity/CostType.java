package pl.mmatuszek.moneysaver.contract.entity;

/**
 * Created by Michal on 2016-05-21.
 */
public class CostType implements IBaseEntity {

    public static final String NAME = "Name";
    public static final String TABLE = "CostTypes";
    public static final String[] COLUMNS = {_ID, NAME };

    private long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
