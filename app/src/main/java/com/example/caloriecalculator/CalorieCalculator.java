package com.example.caloriecalculator;


import java.util.HashMap;
import java.util.Map;

public class CalorieCalculator
{
    public double Height;
    public double Weight;
    public double Years;

    private Map<Sex, double[]> _bmrMultipliers;
    private Map<Activity, Double> _amr;

    public CalorieCalculator()
    {
        initBMR();
        initAMR();
    }

    private void initAMR() {
        _amr = new HashMap<Activity, Double>();
        _amr.put(Activity.Low, (double)1.2f);
        _amr.put(Activity.Medium, (double)1.375f);
        _amr.put(Activity.Middle, (double)1.55f);
        _amr.put(Activity.High, (double)1.725f);
        _amr.put(Activity.Sport, (double)1.9f);
    }

    private void initBMR() {
        _bmrMultipliers = new HashMap<Sex, double[]>();
        _bmrMultipliers.put(Sex.Male, new double[]{66.4730f, 13.7516f, 5.0033f, 6.7550f});
        _bmrMultipliers.put(Sex.Female, new double[]{655.0955f, 9.5634f, 1.8496f, 4.6756f});
    }

    public double calculate(Sex sex, Activity activity) {
        return getBMR(sex) * getAMR(activity);
    }

    private double getBMR(Sex sex) {
        return _bmrMultipliers.get(sex)[0] + (_bmrMultipliers.get(sex)[1] * Weight) +
                (_bmrMultipliers.get(sex)[2] * Height) - (_bmrMultipliers.get(sex)[3] * Years);
    }

    private double getAMR(Activity activity) {
        return _amr.get(activity);
    }
}

enum Sex
{
    Male,
    Female,
}

enum Activity
{
    Low,
    Medium,
    Middle,
    High,
    Sport,
}
