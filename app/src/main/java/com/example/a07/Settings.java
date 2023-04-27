package com.example.a07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner languageSpinner = findViewById(R.id.languageSpinner);
        Spinner colorSpinner = findViewById(R.id.colorSpinner);
        Spinner fontsizeSpinner = findViewById(R.id.fontsizeSpinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.language_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        languageSpinner.setAdapter(adapter);
        languageSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(this,
                R.array.color_array, android.R.layout.simple_spinner_item);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colorAdapter);
        colorSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> fontsizeAdapter = ArrayAdapter.createFromResource(this,
                R.array.fontsize_array, android.R.layout.simple_spinner_item);
        fontsizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontsizeSpinner.setAdapter(fontsizeAdapter);
        fontsizeSpinner.setOnItemSelectedListener(this);
    }

    // Implement the onItemSelected method to do something when an item is selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, "Selected item: " + selectedItem, Toast.LENGTH_SHORT).show();
    }

    // Implement the onNothingSelected method to do something when no item is selected
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "No item selected", Toast.LENGTH_SHORT).show();
    }

    public void openQuestionnaire(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_questionnaire_main, Toast.LENGTH_SHORT);    //toast a text when open
        toast.show();
        Intent intent = new Intent(this, Questionnaire.class);      //intent created to open a new page (activity)
        startActivity(intent);
    }

    public void openSettings(View view){
        Toast toast = Toast.makeText(this, R.string.toast_settings_main, Toast.LENGTH_SHORT);    //toast a text when open
        toast.show();
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void openTracking(View view){
        Toast toast = Toast.makeText(this, R.string.toast_tracking_main, Toast.LENGTH_SHORT);    //toast a text when open
        toast.show();
        Intent intent = new Intent(this, SportTracking.class);
        startActivity(intent);
    }

    public void openArchive(View view){
        Toast toast = Toast.makeText(this, R.string.toast_archive_main, Toast.LENGTH_SHORT);    //toast a text when open
        toast.show();
        Intent intent = new Intent(this, Archive.class);
        startActivity(intent);
    }
}