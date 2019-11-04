package com.example.cemilan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuCemilan extends AppCompatActivity implements OnClickListener {

    TextView rago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_cemilan);

        rago = (TextView)findViewById(R.id.Harga);
    }

    @Override
    public void onClick(View v) {
        Log.d("klik","kklik");
        switch (v.getId()){
            case R.id.img_dorayaki:
                rago.setText("123123");
                break;

            default:
                rago.setText("00000");
                break;
        }
    }


}
