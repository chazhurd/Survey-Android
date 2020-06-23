package com.example.churdlab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends  TracerActivity{
    boolean mIsOn = false;
    String mName;
    int mAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = (TextView)findViewById(R.id.resultstextView);
        Intent intent = getIntent();
        if(intent!=null){
            String action = intent.getAction();
            String type = intent.getType();
            if(action.equals(Intent.ACTION_SEND) && type.equals("text/plain")){
                t.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data) {

        if(requestCode == 0 && resultCode == Activity.RESULT_OK){
            mAge = data.getIntExtra("age", mAge);
            TextView results = (TextView)(findViewById(R.id.resultstextView));
            if(mAge>40) {
                results.setText("Your over 40 so your NOT trustworthy");
            }else{
                results.setText("Your NOT over 40 so your trustworthy");
            }
            super.onActivityResult(requestCode, resultCode, data);
        };
    }
    public void onAbout(MenuItem item) {
        Toast.makeText(this, "Lab 1, Spring 2020, Chaz C Hurd", Toast.LENGTH_SHORT).show();
    }
    public void onButtonSurveyClick(View view) {
        mIsOn = !mIsOn;
        EditText name = findViewById(R.id.nameInputText);
        if(!name.getText().toString().equals("")){
        mName = name.getText().toString();
        TextView rtv = (TextView)findViewById(R.id.resultstextView);
        rtv.setText("Hello " + mName.toString());
        Intent intent = new Intent(this, SurveyActivity.class);
        intent.putExtra("name", mName);
        startActivityForResult(intent, 0);

        }else{
            Toast.makeText(this, "Enter A Name To Proceed", Toast.LENGTH_LONG).show();
        }
    }
    public void onWebsiteButton(View view){
        //could've use a button listener in oncreate but seem likes extra code thats not needed
        Uri website = Uri.parse("https://sites.google.com/site/pschimpf99/");
        Intent intent = new Intent(Intent.ACTION_VIEW, website);
        startActivity(intent);
    }
    // end template
}
