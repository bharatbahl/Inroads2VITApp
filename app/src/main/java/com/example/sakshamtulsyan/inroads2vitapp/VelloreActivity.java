package com.example.sakshamtulsyan.inroads2vitapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class VelloreActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    Button b2;
    Firebase mRef;
    String branch;
    RadioButton r1,r2,r3,r4,r5;
    Firebase childRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vellore);
        setTitle("Vellore Campus");
        t1=(TextView)findViewById(R.id.textView17);
        t2=(TextView)findViewById(R.id.textView18);
        t3=(TextView)findViewById(R.id.textView19);
        t4=(TextView)findViewById(R.id.textView20);
        t5=(TextView)findViewById(R.id.textView21);
        r1=(RadioButton)findViewById(R.id.radioButton6);
        r2=(RadioButton)findViewById(R.id.radioButton7);
        r3=(RadioButton)findViewById(R.id.radioButton8);
        r4=(RadioButton)findViewById(R.id.radioButton9);
        r5=(RadioButton)findViewById(R.id.radioButton10);
        b2=(Button)findViewById(R.id.button4);
        Firebase.setAndroidContext(this);
        mRef=new Firebase("https://inroads2vitapp-38b7a.firebaseio.com/");

        final Long[] values=new Long[40];

        mRef.addValueEventListener(new ValueEventListener() {
            int i1=0;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,Long> branches=(Map<String,Long>)dataSnapshot.getValue();
                for(Map.Entry<String,Long>entry:branches.entrySet()){
                 values[i1++]=entry.getValue();
                }
                t1.setText(values[4]+"");
                t2.setText(values[3]+"");
                t3.setText(values[0]+"");
                t4.setText(values[1]+"");
                t5.setText(values[2]+"");

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r1.isChecked()) {
                    branch = "CSE";
                } else if (r2.isChecked()) {
                    branch = "Mechanical";
                } else if (r3.isChecked()) {
                    branch = "ECE";
                } else if (r4.isChecked()) {
                    branch = "IT";
                } else if (r5.isChecked()) {
                    branch = "Civil";
                } else {
                }
                childRef = mRef.child(branch);
               //final Firebase childRef = mRef.child(branch);
                /*childRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long data=dataSnapshot.getValue(Long.class);
                        data--;
                        childRef.setValue(data);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });*/

               confirm(null);

            }

        });


    }
    public void confirm(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to proceed?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                childRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        long data=dataSnapshot.getValue(Long.class);
                        data--;
                        childRef.setValue(data);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });



               Intent in=new Intent(getApplicationContext(),Main2Activity.class);
                in.putExtra("branch",branch);
                startActivity(in);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }
}
