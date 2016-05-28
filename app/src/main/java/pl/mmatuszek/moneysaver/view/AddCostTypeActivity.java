package pl.mmatuszek.moneysaver.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.inject.Inject;

import pl.mmatuszek.moneysaver.R;
import pl.mmatuszek.moneysaver.interfaces.viewModels.IAddCostTypeActivityViewModel;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class AddCostTypeActivity extends RoboActivity {

    @InjectView(R.id.txtCostTypeName) private EditText txtName;

    @Inject
    IAddCostTypeActivityViewModel addCostTypeActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cost_type);
        initializeComponent();
    }

    public void initializeComponent() {
        addCostTypeActivityViewModel.setContext(this);
    }

    public void onSaveClick(View view){
        addCostTypeActivityViewModel.setName(txtName.getText().toString());
        addCostTypeActivityViewModel.saveOrUpdate();
    }
}
