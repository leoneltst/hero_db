package com.example.hero_db.data.remote;

import retrofit2.Retrofit;

public class ApiUtils {

    private ApiUtils() {}


    public static APIService getAPIServiceBio(Integer ID) {

        return RetrofitClient.getClient("https://superheroapi.com/api/10156112965520834/").create(APIService.class);
    }

}