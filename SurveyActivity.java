package com.example.churdlab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SurveyActivity extends AppCompatActivity {
    String mName;
    int mAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        Intent intent = getIntent();
        mName = intent.getStringExtra("name");
        TextView welcome = (TextView)(findViewById(R.id.helloTextView));
        welcome.setText("Hello " +  mName.toString());
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void onAbout(MenuItem item) {
        Toast.makeText(this, "Lab 1, Spring 2020, Chaz C Hurd", Toast.LENGTH_SHORT).show();
    }
    public void onButtonSubmit(View view){
        EditText uAge = findViewById(R.id.ageTextInput);
        String age = uAge.getText().toString();


        if(age.toString().equals("")){
            Toast.makeText(this, "Please enter an age", Toast.LENGTH_SHORT).show();
        }else{
            mAge = Integer.parseInt(age);
            Intent intent = new Intent();
            intent.putExtra("age", mAge);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }
}
