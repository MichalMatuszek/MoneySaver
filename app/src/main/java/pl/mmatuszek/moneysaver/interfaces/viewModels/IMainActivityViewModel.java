package pl.mmatuszek.moneysaver.interfaces.viewModels;

import android.content.Context;

import pl.mmatuszek.moneysaver.contract.entity.Cost;

/**
 * Created by Michal on 2016-05-21.
 */
public interface IMainActivityViewModel {
    public void setContext(Context context);

    public void saveOrUpdate(Cost cost);
}
