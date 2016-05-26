package pl.mmatuszek.moneysaver.implementations.viewModel;

import android.content.Context;

import com.google.inject.Inject;

import pl.mmatuszek.moneysaver.contract.entity.CostType;
import pl.mmatuszek.moneysaver.interfaces.dao.ICostTypeDAO;
import pl.mmatuszek.moneysaver.interfaces.viewModels.IAddCostTypeActivityViewModel;

/**
 * Created by Michal on 2016-05-26.
 */
public class AddCostTypeActivityViewModel implements IAddCostTypeActivityViewModel {
    private String name;
    private long id;

    @Inject
    ICostTypeDAO costTypeDAO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void setContext(Context context) {
        costTypeDAO.setContext(context);
    }

    @Override
    public void saveOrUpdate() {
        CostType costType = costTypeDAO.findById(id);
        if(costType == null){
            costType = new CostType();
        }
        costType.setName(name);
        costTypeDAO.saveOrUpdate(costType);
    }
}
