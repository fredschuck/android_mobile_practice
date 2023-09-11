package com.example.practice_profile_mood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    TextView textView_dName_profile, textView_dAge_profile, textView_moodStatus, textView_moodRange;
    ImageView imageView_moodIcon;
    User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView_dName_profile = findViewById(R.id.textView_dName_profile);
        textView_dAge_profile = findViewById(R.id.textView_dAge_profile);
        textView_moodRange = findViewById(R.id.textView_moodRange);
        textView_moodStatus = findViewById(R.id.textView_moodStatus);
        imageView_moodIcon = findViewById(R.id.imageView_moodIcon);

        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().hasExtra(MainActivity.USER_KEY)) {
                user = (User) getIntent().getSerializableExtra(MainActivity.USER_KEY);
                textView_dName_profile.setText(user.getName());
                textView_dAge_profile.setText(String.valueOf(user.getAge()));
                int mood_level = user.getMood();
                String moodStatus = null;
                Integer moodImage = null;

                switch(mood_level) {
                    case 0:
                        moodStatus = "Not Well";
                        moodImage = R.drawable.not_well;
                        break;
                    case 1:
                        moodStatus = "Sad";
                        moodImage = R.drawable.sad;
                        break;
                    case 2:
                        moodStatus = "Ok";
                        moodImage = R.drawable.ok;
                        break;
                    case 3:
                        moodStatus = "Good";
                        moodImage = R.drawable.good;
                        break;
                    case 4:
                        moodStatus = "Very Good";
                        moodImage = R.drawable.very_good;
                        break;
                    default:
                        Toast.makeText(getBaseContext(), "error", Toast.LENGTH_SHORT).show();
                        break;
                }
                textView_moodStatus.setText(moodStatus);
                imageView_moodIcon.setImageResource(moodImage);
                textView_moodRange.setText( mood_level + " out of 4");
            }
        }

        findViewById(R.id.button_back_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}