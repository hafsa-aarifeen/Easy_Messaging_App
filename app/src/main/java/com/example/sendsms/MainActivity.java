package com.example.sendsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText No;
    EditText Msg;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        No = (EditText) findViewById(R.id.txtnum);
        Msg = (EditText) findViewById(R.id.txtmsge);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},
                PackageManager.PERMISSION_GRANTED);
    }

    public void send(View view) {
        phoneNo = No.getText().toString();
        message = Msg.getText().toString();

        try {
            if (!phoneNo.equals("") && !message.equals("")) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo, null, message, null, null);
                Toast.makeText(getApplicationContext(), "SMS Sent to " + phoneNo, Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS Sending Failed ", Toast.LENGTH_LONG).show();
        }
    }
}