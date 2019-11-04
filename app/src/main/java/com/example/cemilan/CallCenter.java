package com.example.cemilan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class CallCenter extends AppCompatActivity {

    EditText edtnumber;
    private ImageButton btcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_center);
        edtnumber = (EditText) findViewById(R.id.et_phone);
        btcall = (ImageButton) findViewById(R.id.bt_call);
        btcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"));

                if(ActivityCompat.checkSelfPermission(CallCenter.this,
                        Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    return;
                }
                startActivity(i);
            }
        });
//        btcall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Phone = edtnumber.getText().toString();
//                if (Phone.isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "Please Enter Number!", Toast.LENGTH_LONG).show();
//                } else {
//                    String i = "tel : " + Phone;
//                    Intent intent = new Intent(Intent.ACTION_CALL);
//                    intent.setData(Uri.parse(i));
//                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                        // TODO: Consider calling
//                        //    Activity#requestPermissions
//                        // here to request the missing permissions, and then overriding
//                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                        //                                          int[] grantResults)
//                        // to handle the case where the user grants the permission. See the documentation
//                        // for Activity#requestPermissions for more details.
//                        return;
//                    }
//                    startActivity(intent);
//                }
//            }
//        });
    }

}
