package com.priyanshu.voicemakeover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button texttovoice ,voicetotext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texttovoice = findViewById(R.id.texttovoice);
        voicetotext = findViewById(R.id.voicetotext);
        getSupportActionBar().hide();

        texttovoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , texttovoice.class);
                startActivity(i);
            }
        });
        voicetotext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , Voicetotext.class);
                startActivity(i);
            }
        });
    }
}