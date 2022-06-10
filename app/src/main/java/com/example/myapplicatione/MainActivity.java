package com.example.myapplicatione;



import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button storeinformation = (Button) findViewById(R.id.storeinformation);
        Button showinformation = (Button) findViewById(R.id.showinformation);
        textView = (TextView) findViewById(R.id.txtPrefs);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.storeinformation:
                        Intent intent = new Intent(MainActivity.this,PrefsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.showinformation:
                        displaySharedPreferences();
                        break;
                    default:
                        break;
                }
            }
        };
        storeinformation.setOnClickListener(listener);
        showinformation.setOnClickListener(listener);
    }


    private void displaySharedPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String name = prefs.getString("name", "Default NickName");
        String about = prefs.getString("prod", "Default Password");
        boolean checkBox = prefs.getBoolean("checkBox", false);
        String listPrefs = prefs.getString("listpref", "Default list prefs");


        StringBuilder builder = new StringBuilder();
        builder.append("Name: " + name + "\n");
        builder.append("About the product: " + about + "\n");
        builder.append("Followed for further updates? : " + String.valueOf(checkBox) + "\n");
        builder.append("Your overall experience with us: " + listPrefs);
        textView.setText(builder.toString());

    }

}