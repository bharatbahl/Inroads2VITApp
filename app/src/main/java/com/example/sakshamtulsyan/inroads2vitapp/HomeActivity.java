package com.example.sakshamtulsyan.inroads2vitapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {
    String title=MainActivity.e1.getText().toString();
    String type,aa11;
    Spinner sp1;
    SQLite showrank;
    TextView t1,t2,t3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Welcome " + title);
        String time= DateFormat.getDateTimeInstance().format(new Date());
        String[] dd=time.split(" ");


        t1=(TextView)findViewById(R.id.rank);
        t2=(TextView)findViewById(R.id.day);
        t3=(TextView)findViewById(R.id.time);
        b1=(Button)findViewById(R.id.button);
        sp1=(Spinner)findViewById(R.id.spinner);
        ArrayList<String> a=new ArrayList<>();
        a.add("Vellore");
        a.add("Chennai");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a);
        sp1.setAdapter(arrayAdapter);
        type=sp1.getSelectedItem().toString();

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                aa11 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        showrank=new SQLite(this);
        Cursor c=showrank.rank(title);
        while(c.moveToNext())
        {
            String rank=c.getString(0);
            int intrank=Integer.parseInt(rank);
            t1.setText("Your Rank: " + rank);
            if(intrank>0&&intrank<=1000){
                t2.setText("1-May-2017");
                t3.setText("12:00:00");
            }

            else if(intrank>1000&&intrank<=2000){
                t2.setText("1-May-2017");
                t3.setText("13:00:00");
            }

            else if(intrank>2000&&intrank<=3000){
                t2.setText("1-May-2017");
                t3.setText("14:00:00");
            }

            else if(intrank>3000&&intrank<=4000){
                t2.setText("1-May-2017");
                t3.setText("15:00:00");
            }

            else if(intrank>4000&&intrank<=5000){
                t2.setText("1-May-2017");
                t3.setText("16:00:00");
            }


            else if(intrank>5000&&intrank<=6000){
                t2.setText("2-May-2017");
                t3.setText("12:00:00");
            }

            else if(intrank>6000&&intrank<=7000){
                t2.setText("2-May-2017");
                t3.setText("13:00:00");
            }

            else if(intrank>7000&&intrank<=8000){
                t2.setText("2-May-2017");
                t3.setText("14:00:00");
            }

            else if(intrank>8000&&intrank<=9000){
                t2.setText("2-May-2017");
                t3.setText("15:00:00");
            }

            else if(intrank>9000&&intrank<=10000){
                t2.setText("2-May-2017");
                t3.setText("16:00:00");
            }


            else if(intrank>10000&&intrank<=11000){
                t2.setText("3-May-2017");
                t3.setText("12:00:00");
            }

            else if(intrank>11000&&intrank<=12000){
                t2.setText("3-May-2017");
                t3.setText("13:00:00");
            }

            else if(intrank>12000&&intrank<=13000){
                t2.setText("3-May-2017");
                t3.setText("14:00:00");
            }

            else if(intrank>13000&&intrank<=14000){
                t2.setText("3-May-2017");
                t3.setText("15:00:00");
            }

            else if(intrank>14000&&intrank<=15000){
                t2.setText("3-May-2017");
                t3.setText("16:00:00");
            }

            else{
                t2.setText("-");
                t3.setText("-");
                b1.setVisibility(View.INVISIBLE);
                Toast.makeText(getBaseContext(),"You are not eligible for Counselling",Toast.LENGTH_LONG).show();
            }
        }
        /*String m=dd[0].trim();
        String n=dd[1].trim();
        String p=t2.getText().toString().trim();
        String q=t3.getText().toString().trim();
        n=n.substring(0,2);
        q=q.substring(0,2);
        Toast.makeText(getBaseContext(),m+" "+n+" "+p+" "+q,Toast.LENGTH_LONG).show();
        f(m.equalsIgnoreCase(p))
        {
            Toast.makeText(getBaseContext(),t2.getText().toString()+t3.getText().toString(),Toast.LENGTH_LONG).show();
        }
        else{
            b1.setVisibility(View.INVISIBLE);
            Toast.makeText(getBaseContext(),"Please come at allotted slot",Toast.LENGTH_LONG).show();
            //Toast.makeText(getBaseContext(),t2.getText().toString()+t3.getText().toString(),Toast.LENGTH_LONG).show();
        }*/



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm(null);
            }
        });

    }
    public void confirm(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Are you sure you want to Proceed?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (aa11.equalsIgnoreCase("vellore")) {
                    Intent in = new Intent(getApplicationContext(), VelloreActivity.class);
                    startActivity(in);
                } else {
                    Intent in = new Intent(getApplicationContext(), ChennaiActivity.class);
                    startActivity(in);
                }
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

    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0, 0, 0, "Helpdesk");
        menu.add(0, 1, 1, "Logout");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemid = item.getItemId();
        switch (itemid) {
            case 0:Intent in1=new Intent(getApplicationContext(),HelpDesk.class);
                startActivity(in1);
                break;
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setMessage("Are you sure you want to Logout?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onBackPressed() {
                   AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Are you sure you want to Logout?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
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

