package pl.mmatuszek.moneysaver.interfaces.viewModels;

import android.content.Context;

/**
 * Created by Michal on 2016-05-21.
 */
public interface IAddCostTypeActivityViewModel {
    public void saveOrUpdate();

    public void setContext(Context context);

    public String getName();

    public void setName(String name);
}
