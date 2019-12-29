package com.example.sp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author IDO PEREZ
 * @since 2/9/03
 * @version 0.01
 */
public class MainActivity extends AppCompatActivity {
    TextView tv0;
    EditText et0;
    int count, score= 0;
    String name, name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et0 = (EditText) findViewById(R.id.et0);
        tv0 = (TextView) findViewById(R.id.tv0);
        /**
         * Reading from the SP file
         */
        SharedPreferences settings=getSharedPreferences("SCORE",MODE_PRIVATE);
        score= settings.getInt("score", 0);
        name2 = settings.getString("Name", "Name:");


        tv0.setText("Score:"+" "+count);
        count = score;

        et0.setText(name2);
    }

    /**
     * Counting clicks
     * @param view
     */
    public void Count(View view) {
        count++;
        tv0.setText("Score:"+" "+count);
    }

    /**
     * Reset the Counter.
     * @param view
     */
    public void Reset(View view) {
        count = 0;
        tv0.setText("Score:"+" "+count);
        et0.setText("Name:");
    }

    /**
     *  Finish the app and saving the values in the SP file.
     * @param view
     */
    public void Exit(View view) {
        name =  et0.getText().toString();
        SharedPreferences settings=getSharedPreferences("SCORE",MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("score", count);
        editor.putString("Name", name);
        editor.commit();

        finish();
    }
    @Override

    /**
     * option menu with credit and main that moving from the activitis.
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }

    /**
     * comparing ids and moving to the chosen activity.
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.Credits){
            Intent si = new Intent(this, Credits.class);
            startActivity(si);
        }


        return true;
    }
}