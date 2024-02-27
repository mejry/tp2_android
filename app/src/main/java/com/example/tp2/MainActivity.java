package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText note1,note2,note3,coef1,coef2,coef3;
    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       note1=findViewById(R.id.note1);
       note2=findViewById(R.id.note2);
       note3=findViewById(R.id.note3);
       coef1=findViewById(R.id.coef1);
       coef2=findViewById(R.id.coef2);
       coef3=findViewById(R.id.coef3);
       button=findViewById(R.id.boutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = note1.getText().toString();
                String n2 = note2.getText().toString();
                String n3 = note3.getText().toString();
                String c1 = coef1.getText().toString();
                String c2 = coef2.getText().toString();
                String c3 = coef3.getText().toString();
                if (n1.isEmpty()||n2.isEmpty()||n3.isEmpty()||c1.isEmpty()||c2.isEmpty()||c3.isEmpty()){
                    Toast.makeText(MainActivity.this,"remplir votre champs",Toast.LENGTH_LONG).show();
                }else {
                    Float not1 = Float.parseFloat(n1);
                    Float not2 = Float.parseFloat(n2);
                    Float not3 = Float.parseFloat(n3);
                    Float cf1 = Float.parseFloat(c1);
                    Float cf2 = Float.parseFloat(c2);
                    Float cf3 = Float.parseFloat(c3);
                   Float sum= ((not1*cf1)+(not2*cf2)+(not3*cf3))/(cf1+cf2+cf3);

                   if (sum>=10){
                       Intent i= new Intent(MainActivity.this,MainActivity2.class);
                        i.putExtra("recu",sum);
                        startActivity(i);
                   }
                   if (sum<10){
                       Intent i= new Intent(MainActivity.this,Failed.class);
                       i.putExtra("recu",sum);
                       startActivity(i);
                   }
                }
            }
        });


    }

}