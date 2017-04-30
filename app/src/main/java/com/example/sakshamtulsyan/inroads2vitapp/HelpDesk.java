package com.example.sakshamtulsyan.inroads2vitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HelpDesk extends AppCompatActivity {
    Button b1;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_desk);
        setTitle("HelpDesk");
        b1=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(in);
            }
        });
        lv=(ListView)findViewById(R.id.listView);
        ArrayList<String> a=new ArrayList<>();
        a.add("Hotel Aavanaa Inn\n144, Arcot Road, Vellore\n999999");
        a.add("Darling Residency\n11/8, Annasalai,Vellore\n999999");
        a.add("Gee Kay Millenniaa Ranipet\nPlot no.69, Ranipet, Vellore\n999999");
        a.add("Poppys Anukula Residency\nByPass Road, Vellore\n999999");
        a.add("Rangalaya Royal\nGandhinagar, Vellore\n999999");
        a.add("Hotel River View\nNew Kapadi Road, Vellore\n999999");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a);
        lv.setAdapter(arrayAdapter);
    }
}
