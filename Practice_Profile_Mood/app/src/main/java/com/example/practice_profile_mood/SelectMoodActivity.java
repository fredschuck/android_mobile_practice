package com.example.practice_profile_mood;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SelectMoodActivity extends AppCompatActivity {

    final static public String MOOD_KEY = "MOOD";

    SeekBar seekBar_mood;
    TextView textView_moodProgress;
    ImageView imageView_mood;
    Button button_submitMood, button_cancelMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mood);

        seekBar_mood = findViewById(R.id.seekBar_mood);
        imageView_mood = findViewById(R.id.imageView_mood);
        textView_moodProgress = findViewById(R.id.textView_moodProgress);
        button_cancelMood = findViewById(R.id.button_cancelMood);
        button_submitMood = findViewById(R.id.button_submitMood);

        seekBar_mood.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Log.d(TAG, "onProgressChanged: " + progress);
                switch(progress) {
                    case 0:
                        textView_moodProgress.setText("Not Well");
                        imageView_mood.setImageResource(R.drawable.not_well);
                        break;
                    case 1:
                        textView_moodProgress.setText("Sad");
                        imageView_mood.setImageResource(R.drawable.sad);
                        break;
                    case 2:
                        textView_moodProgress.setText("Ok");
                        imageView_mood.setImageResource(R.drawable.ok);
                        break;
                    case 3:
                        textView_moodProgress.setText("Good");
                        imageView_mood.setImageResource(R.drawable.good);
                        break;
                    case 4:
                        textView_moodProgress.setText("Very Good");
                        imageView_mood.setImageResource(R.drawable.very_good);
                        break;
                    default:
                        Toast.makeText(getBaseContext(), "error", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch: ");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch: ");
            }
        });

        button_submitMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(MOOD_KEY, seekBar_mood.getProgress());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        button_cancelMood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}