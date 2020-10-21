package com.example.android.mykalcy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView standardCalculator = (TextView) findViewById(R.id.standard_calculator);
        standardCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent standardCalculatorIntent = new Intent(MainActivity.this, StandardCalculatorActivity.class);
                startActivity(standardCalculatorIntent);
            }
        });
    }

}
