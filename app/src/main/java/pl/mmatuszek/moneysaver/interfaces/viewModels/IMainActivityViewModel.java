package pl.mmatuszek.moneysaver.interfaces.viewModels;

import android.content.Context;

import java.util.List;

/**
 * Created by Michal on 2016-05-21.
 */
public interface IMainActivityViewModel {
    public List<String> getLastCosts(int count);
    public void setContext(Context context);
}
