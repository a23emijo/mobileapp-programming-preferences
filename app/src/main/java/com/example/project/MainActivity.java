package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    // Variables
    private Button buttonToSecondActivity;
    private SharedPreferences myPreferenceRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buttonToSecondActivity = findViewById(R.id.goToSecondActivity); // Finds the to second activity button

        myPreferenceRef = getSharedPreferences("MyPreferencesName", MODE_PRIVATE);

        // Sets a OnClickListener for the to second activity button
        buttonToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sets the intents
                startActivity(new Intent(MainActivity.this, SecondActivity.class)); // Starts the activity with the intents
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView prefTextRef=new TextView(this);
        prefTextRef=(TextView)findViewById(R.id.prefText);
        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));
    }
}