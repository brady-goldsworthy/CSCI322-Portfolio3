package com.example.portfolio3;

/*
    Brady Goldsworthy and Justin Dupre
    Portfolio 3
    2/18/19
 */


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioGroup pattyRG, cheeseRG;
    private CheckBox baconCB;
    private SeekBar sauceSB;
    private TextView caloriesTV;

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the variables
        pattyRG = findViewById(R.id.pattyRadioGroup);
        cheeseRG = findViewById(R.id.cheeseRadioGroup);

        baconCB = findViewById(R.id.checkBoxBacon);

        sauceSB = findViewById(R.id.seekBar);

        caloriesTV = findViewById(R.id.caloriesTextView);

        burger = new Burger();

        displayCalories();

        pattyRG.setOnCheckedChangeListener((pattyListener));

        cheeseRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.noCheeseRadio: burger.setCheeseCals(0);
                    break;

                    case R.id.cheddarRadio:  burger.setCheeseCals(burger.CHEDDAR);
                    break;

                    case R.id.mozzRadio: burger.setCheeseCals(burger.MOZZ);
                    break;
                }

                displayCalories();
            }
        });

        baconCB.setOnClickListener( baconListener);

        sauceSB.setOnSeekBarChangeListener(seekBarListener);

    }

    private SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setSauceCals(progress);
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private View.OnClickListener baconListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (((CheckBox) v).isChecked()){
                burger.setBaconCals(true);
            }
            else {
                burger.setBaconCals(false);
            }
            displayCalories();
        }
    };

    private RadioGroup.OnCheckedChangeListener pattyListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.radioBeef: burger.setPattyCals(burger.BEEF);
                break;

                case R.id.radioTurkey: burger.setPattyCals(burger.TURKEY);
                break;

                case R.id.radioVeggie: burger.setPattyCals(burger.VEGGIE);
                break;
            }

            displayCalories();
        }
    };

    private void displayCalories() {
        //Build the string to be displayed
        String caloriesText = "Calories: " + burger.totalCals();

        //Display the String
        caloriesTV.setText(caloriesText);
    }




}
