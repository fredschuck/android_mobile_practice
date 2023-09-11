package com.example.assignment_02;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView_moodResult;
    EditText editText_name, editText_age;
    Button button_tellUs, button_submitMain;
    ImageView imageView_mood_main;
    final static public String USER_KEY = "USER";
    int mood_level = -1;

    private ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result != null && result.getResultCode() == RESULT_OK){
                Intent data = result.getData();
                if(data != null && data.hasExtra(SelectMoodActivity.MOOD_KEY)){
                    mood_level = data.getIntExtra(SelectMoodActivity.MOOD_KEY, -1);
                    switch(mood_level) {
                        case 0:
                            imageView_mood_main.setImageResource(R.drawable.not_well);
                            break;
                        case 1:
                            imageView_mood_main.setImageResource(R.drawable.sad);
                            break;
                        case 2:
                            imageView_mood_main.setImageResource(R.drawable.ok);
                            break;
                        case 3:
                            imageView_mood_main.setImageResource(R.drawable.good);
                            break;
                        case 4:
                            imageView_mood_main.setImageResource(R.drawable.very_good);
                            break;
                        default:
                            Toast.makeText(getBaseContext(), "error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    textView_moodResult.setText(String.valueOf(mood_level) + " out of 4");
                    textView_moodResult.setVisibility(View.VISIBLE);
                    imageView_mood_main.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getBaseContext(), "error", Toast.LENGTH_SHORT).show();
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Main Activity");

        editText_name = findViewById(R.id.editText_name);
        editText_age = findViewById(R.id.editText_age);
        button_submitMain = findViewById(R.id.button_submitMain);
        button_tellUs = findViewById(R.id.button_tellUs);
        textView_moodResult = findViewById(R.id.textView_moodResult);
        imageView_mood_main = findViewById(R.id.imageView_mood_main);

        textView_moodResult.setVisibility(View.INVISIBLE);
        imageView_mood_main.setVisibility(View.INVISIBLE);

        button_tellUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectMoodActivity.class);
                startForResult.launch(intent);
            }
        });

        button_submitMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);

                String name = editText_name.getText().toString();
                int age, mood;
                if (name.isEmpty() || name == null){
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    age = Integer.parseInt(editText_age.getText().toString());
                } catch(Exception e){
                    Toast.makeText(MainActivity.this, "Please enter your age", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mood_level == -1) {
                    Toast.makeText(MainActivity.this, "Please enter your mood", Toast.LENGTH_SHORT).show();
                    return;
                }
                User user = new User(name, age, mood_level);
                intent.putExtra(USER_KEY, user);
                startActivity(intent);
            }
        });
    }
}