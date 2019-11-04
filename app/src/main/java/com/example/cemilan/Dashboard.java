package com.example.cemilan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Switch;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    private CardView update, cemilan, call, sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        //Add Cardview yang ada di dashboard
        call = (CardView) findViewById(R.id.callcenter);
        sms = (CardView) findViewById(R.id.smscenter);
//        maps =(CardView)findViewById(R.id.maps);
        update = (CardView) findViewById(R.id.update_data);
        cemilan = (CardView) findViewById(R.id.cemilan);

        //tambah clicklistener
        update.setOnClickListener(this);
        cemilan.setOnClickListener(this);
        call.setOnClickListener(this);
        sms.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.cemilan:
                i = new Intent(this, MenuCemilan.class);
                startActivity(i);
                break;
            case R.id.update_data:
                i = new Intent(this, Update_data.class);
                startActivity(i);
                break;
            case R.id.callcenter:
                i = new Intent(this, CallCenter.class);
                startActivity(i);
                break;
            case R.id.smscenter:
                i = new Intent(this, SmsCenter.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    public void maps(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/maps"));
        startActivity(intent);
    }

}
