package pl.mmatuszek.moneysaver;

import android.os.Bundle;

import roboguice.activity.RoboActivity;

public class MainActivity extends RoboActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
