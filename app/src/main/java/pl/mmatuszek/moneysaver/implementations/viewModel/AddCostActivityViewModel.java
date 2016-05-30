package pl.mmatuszek.moneysaver.implementations.viewModel;

import android.content.Context;

import com.google.inject.Inject;


import java.util.Date;
import java.util.List;

import pl.mmatuszek.moneysaver.contract.entity.Cost;
import pl.mmatuszek.moneysaver.contract.entity.CostType;
import pl.mmatuszek.moneysaver.interfaces.dao.ICostDAO;
import pl.mmatuszek.moneysaver.interfaces.dao.ICostTypeDAO;
import pl.mmatuszek.moneysaver.interfaces.viewModels.IAddCostActivityViewModel;

/**
 * Created by Michal on 2016-05-26.
 */
public class AddCostActivityViewModel implements IAddCostActivityViewModel {

    @Inject
    ICostDAO costDAO;

    @Inject
    ICostTypeDAO costTypeDAO;

    private long id;
    private String name;
    private Date date;
    private long type;
    private float value;

    public long getId() {
        return id;
    }

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

    @Override
    public void setContext(Context context) {
        costTypeDAO.setContext(context);
        costDAO.setContext(context);
    }

    @Override
    public List<CostType> getCostTypes() {
        return costTypeDAO.getAll();
    }

    @Override
    public void saveOrUpdate() {
        Cost cost = costDAO.findById(id);
        if(cost == null){
            cost = new Cost();
        }

        cost.setName(name);
        cost.setDate(date);
        cost.setType(type);
        cost.setValue(value);
        costDAO.saveOrUpdate(cost);
    }
}
