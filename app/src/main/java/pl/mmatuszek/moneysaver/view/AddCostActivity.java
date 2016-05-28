package pl.mmatuszek.moneysaver.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.inject.Inject;

import java.util.Calendar;
import java.util.Date;

import pl.mmatuszek.moneysaver.R;
import pl.mmatuszek.moneysaver.interfaces.viewModels.IAddCostActivityViewModel;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class AddCostActivity extends RoboActivity {

    @InjectView(R.id.editTextName) private EditText txtName;
    @InjectView(R.id.spinnerType) private Spinner spinnerType;
    @InjectView(R.id.editTextDate) private EditText txtDate;
    @InjectView(R.id.editTextValue) private EditText txtValue;
    private int year;
    private int month;
    private int day;

    @Inject
    IAddCostActivityViewModel addCostActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cost);
        initalizeComponent();
    }

    public void initalizeComponent() {
        txtDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                year=mcurrentDate.get(Calendar.YEAR);
                month=mcurrentDate.get(Calendar.MONTH);
                day=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(AddCostActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {

                    }
                },year, month, day);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();  }
        });
    }

    public void onSaveClick(View view){
        addCostActivityViewModel.setName(txtName.getText().toString());
        addCostActivityViewModel.setType(spinnerType.getSelectedItemId());
        addCostActivityViewModel.setDate(new Date(year,month,day));
        addCostActivityViewModel.setValue(Float.parseFloat(txtValue.getText().toString()));
        addCostActivityViewModel.saveOrUpdate();
    }
}
