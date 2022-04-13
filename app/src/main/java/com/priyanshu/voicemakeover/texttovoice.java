package com.priyanshu.voicemakeover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;
import java.util.Objects;

public class texttovoice extends AppCompatActivity {
    TextInputLayout text;
    Button btconvert, btclear;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texttovoice);
        getSupportActionBar().setTitle("Text to Voice");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        text = findViewById(R.id.textfeild);
        btclear = findViewById(R.id.stop);
        btconvert = findViewById(R.id.convert);


        textToSpeech = new TextToSpeech(getApplicationContext()
                , new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    //Select Language
                    int lang = textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
        btconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the input text
                String s = Objects.requireNonNull(text.getEditText()).getText().toString();
                if (s.isEmpty()) {
                    Toast.makeText(texttovoice.this, "Enter Text", Toast.LENGTH_SHORT).show();
                }
                //Conversion
                else {
                    int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        btclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // clear the text
                textToSpeech.stop();

            }
        });
    }
}