package pl.mmatuszek.moneysaver.infrastructure;

import com.google.inject.Binder;
import com.google.inject.Module;

import pl.mmatuszek.moneysaver.contract.entity.CostType;
import pl.mmatuszek.moneysaver.implementations.dao.BaseDAO;
import pl.mmatuszek.moneysaver.implementations.dao.CostDAO;
import pl.mmatuszek.moneysaver.implementations.dao.CostTypeDAO;
import pl.mmatuszek.moneysaver.interfaces.dao.IBaseDAO;
import pl.mmatuszek.moneysaver.interfaces.dao.ICostDAO;
import pl.mmatuszek.moneysaver.interfaces.dao.ICostTypeDAO;

/**
 * Created by Michal on 2016-05-21.
 */
public class IOCModule implements Module{

    @Override
    public void configure(Binder binder) {
//        binder.bind(IBaseDAO.class).to(BaseDAO.class);
//        binder.bind(ICostTypeDAO.class).to(CostTypeDAO.class);
//        binder.bind(ICostDAO.class).to(CostDAO.class);
    }
}
