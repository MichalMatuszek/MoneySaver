package pl.mmatuszek.moneysaver.infrastructure;

import com.google.inject.Binder;
import com.google.inject.Module;

import pl.mmatuszek.moneysaver.implementations.dao.CostDAO;
import pl.mmatuszek.moneysaver.implementations.dao.CostTypeDAO;
import pl.mmatuszek.moneysaver.implementations.viewModel.AddCostActivityViewModel;
import pl.mmatuszek.moneysaver.implementations.viewModel.AddCostTypeActivityViewModel;
import pl.mmatuszek.moneysaver.interfaces.dao.ICostDAO;
import pl.mmatuszek.moneysaver.interfaces.dao.ICostTypeDAO;
import pl.mmatuszek.moneysaver.interfaces.viewModels.IAddCostActivityViewModel;
import pl.mmatuszek.moneysaver.interfaces.viewModels.IAddCostTypeActivityViewModel;

/**
 * Created by Michal on 2016-05-21.
 */
public class IOCModule implements Module{

    @Override
    public void configure(Binder binder) {
        binder.bind(IAddCostActivityViewModel.class).to(AddCostActivityViewModel.class);
        binder.bind(IAddCostTypeActivityViewModel.class).to(AddCostTypeActivityViewModel.class);
        binder.bind(ICostDAO.class).to(CostDAO.class);
        binder.bind(ICostTypeDAO.class).to(CostTypeDAO.class);
        binder.bind(IAddCostTypeActivityViewModel.class).to(AddCostTypeActivityViewModel.class);
    }
}
