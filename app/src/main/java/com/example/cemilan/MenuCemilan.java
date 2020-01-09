package com.example.cemilan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuCemilan extends AppCompatActivity implements OnClickListener {

    TextView rago;
    int hargaTotal=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_cemilan);

        rago = (TextView)findViewById(R.id.Harga);
        findViewById(R.id.img_dorayaki).setOnClickListener(this);
        findViewById(R.id.img_dango).setOnClickListener(this);
        findViewById(R.id.img_french).setOnClickListener(this);
        findViewById(R.id.img_ramen1).setOnClickListener(this);
        findViewById(R.id.img_sushi).setOnClickListener(this);
        findViewById(R.id.img_tako).setOnClickListener(this);
        findViewById(R.id.Harga).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuCemilan.this, Pembayaran.class);
                i.putExtra("biaya", String.valueOf(hargaTotal));
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.img_dorayaki:
                hargaTotal+=100;
                break;
            case R.id.img_dango:
                hargaTotal+=200;
                break;
            case R.id.img_french:
                hargaTotal+=300;
                break;
            case R.id.img_ramen1:
                hargaTotal+=1500;
                break;
            case R.id.img_tako:
                hargaTotal+=500;
                break;
            case R.id.img_sushi:
                hargaTotal+=2000;
                break;
                default: hargaTotal=hargaTotal;
        }
        rago.setText("Rp. "+String.valueOf(hargaTotal));
    }

}
