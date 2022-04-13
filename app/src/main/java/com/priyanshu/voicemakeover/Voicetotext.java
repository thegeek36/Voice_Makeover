package com.priyanshu.voicemakeover;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Voicetotext extends AppCompatActivity {

    Button btnspeak;
    TextView text;
    ImageView copy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voicetotext);
        getSupportActionBar().setTitle("Voice to Text");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnspeak = findViewById(R.id.btnspeak);
        text = findViewById(R.id.textspeak);
        copy = findViewById(R.id.copy);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Objects.requireNonNull(text.getText().toString());
                ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("String" ,s );
                clipboardManager.setPrimaryClip(clip);
                clip.getDescription();
                Toast.makeText(Voicetotext.this,"Copied to ClipBoard",Toast.LENGTH_SHORT).show();
            }
        });


        btnspeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpeakNow(view);
            }
        });
    }

    private void SpeakNow(View view){
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Start Speaking...");
        startActivityForResult(i,111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == RESULT_OK){
            text.setText(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));
        }
    }
}
