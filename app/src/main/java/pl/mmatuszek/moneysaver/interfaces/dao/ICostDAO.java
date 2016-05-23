package pl.mmatuszek.moneysaver.interfaces.dao;

import java.util.List;

import pl.mmatuszek.moneysaver.contract.entity.Cost;

/**
 * Created by Michal on 2016-05-23.
 */
public interface ICostDAO extends IBaseDAO {

    Cost findById(long id);

    void saveOrUpdate(Cost cost);

    List<Cost> getLastAddedCosts(int count);
}
