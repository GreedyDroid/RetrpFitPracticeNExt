package com.example.sayed.retrpfitpracticenext;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nurud on 2/26/2018.
 */

public interface FlowerServiceAPI {
    @GET("feeds/flowers.json")
    Call<ArrayList<FlowerResponce>> getFlowerResponse();
}
