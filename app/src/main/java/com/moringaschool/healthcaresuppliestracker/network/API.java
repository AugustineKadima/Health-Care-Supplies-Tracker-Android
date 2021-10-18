
package com.moringaschool.healthcaresuppliestracker.network;

import com.moringaschool.healthcaresuppliestracker.modules.Delivered;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("ItemsList/")
    Call<List<Delivered>> getPropertiesInASpecificLocation();

}