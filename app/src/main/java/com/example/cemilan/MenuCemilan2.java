package com.example.cemilan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.cemilan.Adapter.MakananAdapter;
import com.example.cemilan.Model.Barang;
import com.example.cemilan.Model.Makanan;
import com.example.cemilan.Model.MakananResponse;
import com.example.cemilan.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MenuCemilan2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MakananAdapter makananAdapter;
    private ArrayList<Makanan> makanans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cemilan2);

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setTitle("Menu Makanan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        makananAdapter = new MakananAdapter();

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setAdapter(makananAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        loadMakanas();

    }

    private void loadMakanas()
    {
       Call<MakananResponse> callMakanans = RetrofitClient.servicesApiMasyadi().getDataMakanans();
       callMakanans.enqueue(new Callback<MakananResponse>() {
           @Override
           public void onResponse(Call<MakananResponse> call, Response<MakananResponse> response) {
               makananAdapter.setMakanans(response.body().getResult());
           }

           @Override
           public void onFailure(Call<MakananResponse> call, Throwable t) {
               Log.d("Makanas", String.valueOf(t));
           }
       });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
