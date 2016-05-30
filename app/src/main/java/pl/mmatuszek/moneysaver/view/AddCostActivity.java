package pl.mmatuszek.moneysaver.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.inject.Inject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pl.mmatuszek.moneysaver.MainActivity;
import pl.mmatuszek.moneysaver.R;
import pl.mmatuszek.moneysaver.contract.entity.CostType;
import pl.mmatuszek.moneysaver.interfaces.viewModels.IAddCostActivityViewModel;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class AddCostActivity extends RoboActivity implements View.OnClickListener {

    @InjectView(R.id.editTextName) private EditText txtName;
    @InjectView(R.id.spinnerType) private Spinner spinnerType;
    @InjectView(R.id.editTextDate) private EditText txtDate;
    @InjectView(R.id.editTextValue) private EditText txtValue;
    private DatePickerDialog datePickerDialog;

    private SimpleDateFormat dateFormatter;

    @Inject
    IAddCostActivityViewModel addCostActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cost);
        initalizeComponent();
    }

    public void initalizeComponent() {
        addCostActivityViewModel.setContext(this);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        txtDate.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                txtDate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        List<CostType> test = addCostActivityViewModel.getCostTypes();
        ArrayAdapter<CostType> dataAdapter = new ArrayAdapter<CostType>(this,
                android.R.layout.simple_spinner_item,test);
        spinnerType.setAdapter(dataAdapter);
    }

    private Date parseDate(){
        try {
            dateFormatter.parse(txtDate.getText().toString());
        }catch(ParseException exc){
            exc.printStackTrace();
        }
        return new Date();
    }

    public void onSaveClick(View view){
        addCostActivityViewModel.setName(txtName.getText().toString());
        addCostActivityViewModel.setType(spinnerType.getSelectedItemId());
        addCostActivityViewModel.setDate(parseDate());
        addCostActivityViewModel.setValue(Float.parseFloat(txtValue.getText().toString()));
        addCostActivityViewModel.saveOrUpdate();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        datePickerDialog.show();
    }
}
