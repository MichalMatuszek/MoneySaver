package pl.mmatuszek.moneysaver.interfaces.dao;

import java.util.List;

import pl.mmatuszek.moneysaver.contract.entity.CostType;

/**
 * Created by Michal on 2016-05-23.
 */
public interface ICostTypeDAO extends IBaseDAO {

    List<CostType> getAll();

    CostType findById(long id);

    void saveOrUpdate(CostType costType);
}
