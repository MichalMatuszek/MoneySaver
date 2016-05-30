package pl.mmatuszek.moneysaver.view;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import pl.mmatuszek.moneysaver.R;

public class ShowCostsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_show_costs);
        ListView costsList = getListView();
    }
}
