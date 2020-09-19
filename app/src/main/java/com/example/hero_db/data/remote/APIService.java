package com.example.hero_db.data.remote;

import com.example.hero_db.data.model.Hero;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    @GET("{ID}/image/")
    Call<Hero> savePost(@Path("ID") int Id);
}