package pl.mmatuszek.moneysaver.contract.util.database.migrations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 2016-05-21.
 */
public abstract class BaseMigration {
    protected List<String> steps;

    public BaseMigration() {
        this.steps = new ArrayList<String>();
    }

    public String getSQLQuery() {
        StringBuilder result = new StringBuilder();
        for(String step : steps){
            result.append(step + ";" + "\n");
        }

        return result.toString();
    }
}
