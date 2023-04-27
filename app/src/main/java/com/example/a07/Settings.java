package com.example.a07;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Locale;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private boolean languageSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner languageSpinner = findViewById(R.id.languageSpinner);
        Spinner colorSpinner = findViewById(R.id.colorSpinner);
        Spinner fontsizeSpinner = findViewById(R.id.fontsizeSpinner);

        SwitchMaterial darkmodeSwitch = findViewById(R.id.darkmodeSwitch);
        darkmodeSwitch.setChecked(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES);

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

        darkmodeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Enable dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                // Disable dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            getDelegate().applyDayNight();
        });
    }

    // Implement the onItemSelected method to do something when an item is selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (!languageSelected) {
            // Don't apply the language when the activity is first loaded
            languageSelected = true;
            return;
        }

        String selectedItem = parent.getItemAtPosition(position).toString();

        // Change app language based on selection
        if (parent.getId() == R.id.languageSpinner) {
            if (selectedItem.equals("German")){
                setLocale(this, "de");
                Toast.makeText(this, "Die Sprache wurde auf: " + selectedItem + " geändert", Toast.LENGTH_SHORT).show();
                recreate();
            }
            else if (selectedItem.equals("Englisch")){
                setLocale(this, "en");
                Toast.makeText(this, "The language has been changed to: " + selectedItem, Toast.LENGTH_SHORT).show();
                recreate();
            }
            else {
                Toast.makeText(this, "This would set the language to: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Implement the onNothingSelected method to do something when no item is selected
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "No item selected", Toast.LENGTH_SHORT).show();
    }

    public void setLocale (Activity activity, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public void openMainActivity(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_home_main, Toast.LENGTH_SHORT);    //toast a text when open
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //intent created to open a new page (activity)
        startActivity(intent);
    }

    public void openSettings(View view){
        Toast toast = Toast.makeText(this, R.string.toast_settings_main, Toast.LENGTH_SHORT);    //toast a text when open
        toast.show();
        Intent intent = new Intent(this, Settings.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void openTracking(View view){
        Toast toast = Toast.makeText(this, R.string.toast_tracking_main, Toast.LENGTH_SHORT);    //toast a text when open
        toast.show();
        Intent intent = new Intent(this, SportTracking.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void openArchive(View view){
        Toast toast = Toast.makeText(this, R.string.toast_archive_main, Toast.LENGTH_SHORT);    //toast a text when open
        toast.show();
        Intent intent = new Intent(this, Archive.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}