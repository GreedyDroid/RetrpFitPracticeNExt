package com.example.sayed.retrpfitpracticenext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String fUrl = "http://services.hanselandpetal.com/feeds/flowers.json";
    private final String BASE_URL = "http://services.hanselandpetal.com/";
    private FlowerServiceAPI flowerServiceAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        flowerServiceAPI = retrofit.create(FlowerServiceAPI.class);

        Call<ArrayList<FlowerResponce>>arrayListCall = flowerServiceAPI.getFlowerResponse();
        arrayListCall.enqueue(new Callback<ArrayList<FlowerResponce>>() {
            @Override
            public void onResponse(Call<ArrayList<FlowerResponce>> call, Response<ArrayList<FlowerResponce>> response) {
                if (response.code() == 200){
                    ArrayList<FlowerResponce>flowerResponces = response.body();
                    Toast.makeText(MainActivity.this, ""+flowerResponces.size(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, ""+flowerResponces.get(0).getName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FlowerResponce>> call, Throwable t) {

            }
        });
    }
}
