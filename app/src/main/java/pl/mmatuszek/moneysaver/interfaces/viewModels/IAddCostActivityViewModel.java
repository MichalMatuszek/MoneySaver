package pl.mmatuszek.moneysaver.interfaces.viewModels;

import android.content.Context;

import java.util.Date;
import java.util.List;

import pl.mmatuszek.moneysaver.contract.entity.CostType;

/**
 * Created by Michal on 2016-05-21.
 */
public interface IAddCostActivityViewModel {
    public void setContext(Context context);

    public List<CostType> getCostTypes();

    public void saveOrUpdate();

    public String getName();

    public void setName(String name);

    public Date getDate();

    public void setDate(Date date);

    public long getType();

    public void setType(long type);

    public float getValue();

    public void setValue(float value);
}
