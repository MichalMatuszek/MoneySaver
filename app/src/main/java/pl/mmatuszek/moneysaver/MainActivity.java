package pl.mmatuszek.moneysaver;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.inject.Inject;

import pl.mmatuszek.moneysaver.interfaces.viewModels.IMainActivityViewModel;
import pl.mmatuszek.moneysaver.view.AddCostTypeActivity;
import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;

public class MainActivity extends RoboActivity {

    @Inject
    IMainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupIocContainer();
        initializeComponent();
    }

    private void initializeComponent() {
        mainActivityViewModel.setContext(this);
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

    public void onSaveClick(View view){

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
