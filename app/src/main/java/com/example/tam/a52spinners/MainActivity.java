package com.example.tam.a52spinners;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spn_color, spn_colorJava;
    TextView txt;
    int[] color = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
    String[] arr = {"Red", "Blue", "Yellow", "Green"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn_color = (Spinner)findViewById(R.id.spn_color);
        txt = (TextView)findViewById(R.id.txt);
        spn_color.setOnItemSelectedListener(new SpinnerClick());
        spn_colorJava = (Spinner)findViewById(R.id.spn_colorJava);
        Button btn_goto2 = (Button)findViewById(R.id.btn_goto2);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spn_colorJava.setAdapter(adapter);
        spn_colorJava.setOnItemSelectedListener(new SpinnerClick());
        btn_goto2.setOnClickListener(new Goto2());

    }

    private class SpinnerClick implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            txt.setBackgroundColor(color[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class Goto2 implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(i);
        }
    }

}
