package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    EditText inputRule;
    MainActivity access;
    Intent intent2, intent3;
    Button diceRooler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
// Part 3a


    public void addingToArray(){
        TextView tv = this.findViewById(R.id.textView2);
        EditText inputRule = this.findViewById(R.id.newRule);
        ArrayList<String> questions1 = new ArrayList<String>();
        String s = inputRule.getText().toString();
        questions1.add(s);
        tv.setText(s);
    }

    public void bkScreenSave(View view){
        intent2 = new Intent(this,MainActivity.class);
        addingToArray();
        startActivity(intent2);
    }

    public void bkScreenCancel(View view) {
        intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
    }




}
