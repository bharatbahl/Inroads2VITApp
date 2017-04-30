package com.example.sakshamtulsyan.inroads2vitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChennaiActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chennai);
        setTitle("Chennai Campus");
        t1=(TextView)findViewById(R.id.textView12);
        t2=(TextView)findViewById(R.id.textView13);
        t3=(TextView)findViewById(R.id.textView14);
        t4=(TextView)findViewById(R.id.textView15);
        t5=(TextView)findViewById(R.id.textView16);
        b1=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
