package com.example.cemilan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pembayaran extends AppCompatActivity {
    int totalBiaya = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pembayaran);
        String biaya = getIntent().getStringExtra("biaya");
        totalBiaya = Integer.valueOf(biaya);
        TextView x = findViewById(R.id.total_biaya);
        EditText Et = findViewById(R.id.edt_bayar);
        Et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                EditText kembalian = findViewById(R.id.edt_kemabalian);
                if (String.valueOf(s) != "") {
                    int uangRakyat = Integer.valueOf(String.valueOf(s));
                    int totalKalkulasi = uangRakyat - totalBiaya;
                    if (totalKalkulasi > 0) {
                        kembalian.setText(String.valueOf(totalKalkulasi));
                    }
                }

            }
        });
        x.setText(biaya);
    }

    public void bayar(View view) {
        Intent i = new Intent(Pembayaran.this, MenuCemilan.class);
        startActivity(i);
        this.finish();
        Toast.makeText(getApplicationContext(),"Pembayaran Sukses",Toast.LENGTH_LONG).show();
    }
}
