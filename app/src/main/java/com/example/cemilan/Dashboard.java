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
    private CardView cemilan, call, sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        //Add Cardview yang ada di dashboard
        call = findViewById(R.id.callcenter);
        sms = findViewById(R.id.smscenter);
        // maps =(CardView)findViewById(R.id.maps);
        cemilan = findViewById(R.id.cemilan);

        //tambah clicklistener
        cemilan.setOnClickListener(this);
        sms.setOnClickListener(this);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:089510213499"));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(i);
            }
        });

    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.cemilan:
                i = new Intent(this, MenuCemilan.class);
                startActivity(i);
                break;
            case R.id.callcenter:
                i = new Intent(this, Dashboard.class);
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
