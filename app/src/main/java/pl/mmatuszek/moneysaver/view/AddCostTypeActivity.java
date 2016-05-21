package pl.mmatuszek.moneysaver.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pl.mmatuszek.moneysaver.R;
import roboguice.activity.RoboActivity;

public class AddCostTypeActivity extends RoboActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cost_type);
    }
}
