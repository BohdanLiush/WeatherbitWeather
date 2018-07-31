package com.example.bohdan.weatherbitweather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ModelApi {

    @GET("?&key=9c918e0e834d486fb1a1cb6dc07b78b2&hours=24")
    Call<Model> idsInfo(@Query("city") String number);
}
