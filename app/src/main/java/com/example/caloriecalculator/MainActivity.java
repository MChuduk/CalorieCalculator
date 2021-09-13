package com.example.caloriecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText _weightEditText;
    private EditText _heightEditText;
    private EditText _yearsEditText;
    private TextView _resultTextView;
    private Spinner _spinnerActivity;

    private double _height;
    private double _weight;
    private double _years;
    private Sex _sex = Sex.Male;
    private Activity _activity = Activity.Low;
    private CalorieCalculator _calorieCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        _calorieCalculator = new CalorieCalculator();
    }

    public void onCalculateButtonClick(View button) {
        parseValues();

        _calorieCalculator.Height = _height;
        _calorieCalculator.Weight = _weight;
        _calorieCalculator.Years = _years;

        _resultTextView.setText(String.valueOf(_calorieCalculator.calculate(_sex, _activity)));
    }

    public void setSex(View radioButton) {
        _sex = Sex.valueOf((String) radioButton.getTag());
    }

    private void findViews() {
        _weightEditText = findViewById(R.id.editTextNumberWeight);
        _heightEditText = findViewById(R.id.editTextNumberHeight);
        _yearsEditText = findViewById(R.id.editTextNumberYears);
        _resultTextView = findViewById(R.id.textViewResult);
        _spinnerActivity = findViewById(R.id.spinnerActivity);
    }

    private void parseValues() {
        _weight = Double.parseDouble(String.valueOf(_weightEditText.getText()));
        _height = Double.parseDouble(String.valueOf(_heightEditText.getText()));
        _years = Double.parseDouble(String.valueOf(_yearsEditText.getText()));
        _activity = Activity.values()[_spinnerActivity.getSelectedItemPosition()];
    }
}