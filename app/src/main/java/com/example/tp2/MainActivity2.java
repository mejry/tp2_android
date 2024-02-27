package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView v1;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2=findViewById(R.id.b2);
        v1=findViewById(R.id.v1);
        Intent i=getIntent();
       Float result= i.getFloatExtra("recu",0);
        String message="Félécitaion , votre moyenne est : "+result;
        v1.setText(message);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num ="26416549";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms: "+num));

                intent.putExtra("sms_body", message);
                startActivity(intent);
            }
        });
    }
}