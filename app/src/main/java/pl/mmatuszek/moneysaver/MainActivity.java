package pl.mmatuszek.moneysaver;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import pl.mmatuszek.moneysaver.view.AddCostTypeActivity;
import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;

public class MainActivity extends RoboActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RoboGuice.setUseAnnotationDatabases(false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AddCostTypeActivity.class);
        switch(item.getItemId()) {
            case R.id.add_cost_type:
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
