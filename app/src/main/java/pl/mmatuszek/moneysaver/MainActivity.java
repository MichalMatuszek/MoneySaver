package pl.mmatuszek.moneysaver;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import pl.mmatuszek.moneysaver.view.AddCostActivity;
import pl.mmatuszek.moneysaver.view.AddCostTypeActivity;
import pl.mmatuszek.moneysaver.view.ShowCostsActivity;
import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;

public class MainActivity extends RoboActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupIocContainer();
    }

    private void setupIocContainer(){
        RoboGuice.setUseAnnotationDatabases(false);
        RoboGuice.injectMembers(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public void onAddCostClick(View view){
        Intent intent = new Intent(this, AddCostActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
            case R.id.add_cost_type:
                intent = new Intent(this, AddCostTypeActivity.class);
                break;
            case R.id.show_costs:
                intent = new Intent(this, ShowCostsActivity.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);
        return true;
    }
}
