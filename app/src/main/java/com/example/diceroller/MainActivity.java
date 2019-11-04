package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView dice;
    TextView dice2;
    EditText InputNumber;
    TextView point;
    String num;
    int count = 0;
    ArrayList<String> questions;

    public static final String EXTRA_MESSAGE = "com.example.DiceRoller.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int roll_the_dice() {
        Random rand = new Random();
        int number = rand.nextInt(6) + 1;
        return number;
    }
//Part 1 A,B,C
public void clickTheButton(View view) {
    int number = roll_the_dice();
    dice = this.findViewById(R.id.textView);
    point = this.findViewById(R.id.userPoints);
    dice.setText(Integer.toString(number));
    InputNumber = this.findViewById(R.id.roll);
    num = InputNumber.getText().toString();
    if (num.equals(Integer.toString(number)) && Integer.parseInt(num) < 7) {
        dice.setText("Congratulations: " + number);
        iceBreakerRule();
        count++;
        point.setText("User Ponits: " + count);

    }
}
    //Part 3a
    public void iceBreakerRule(){
        dice2 = this.findViewById(R.id.textView3);
        int number2 = roll_the_dice()-1;
        questions = new ArrayList<String>();
        questions.add("If you could go anywhere in the world, where would you go?");
        questions.add("If you were stranded on a desert island, what three things would you want to take with you?");
        questions.add("If you could eat only one food for the rest of your life, what would that be?");
        questions.add("If you won a million dollars, what is the first thing you would buy?");
        questions.add("If you could spend the day with one fictional character, who would it be?");
        questions.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
        dice2.setText(questions.get(number2));
    }

    public void clickTheSecondButton(View view){
        iceBreakerRule();
    }
    //bonus part 4.5
    public void secondScreen(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}

