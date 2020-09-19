package com.example.hero_db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hero_db.data.HeroAdapter;
import com.example.hero_db.data.model.Hero;
import com.example.hero_db.data.remote.APIService;
import com.example.hero_db.data.remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView ReciclerView1;

    EditText edittext1;
    private APIService mAPIService;
    Hero AUX;
    static List<Hero> HeroList = new ArrayList<>();
    HeroAdapter heroAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAPIService = ApiUtils.getAPIServiceBio(1);
        ReciclerView1 = findViewById(R.id.ReciclerView1);
        edittext1= findViewById(R.id.edittext1);
        edittext1.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                for (Hero H:HeroList){
                    if(H.getName().equals(edittext1.getText().toString())){
                        startActivity(new Intent(getApplicationContext() , detalle.class));
                    }
                }

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
        ReciclerView1.setLayoutManager(new LinearLayoutManager(this));
        ReciclerView1.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        for (int i=1;i<=10;i++){
            sendPost(i);

        }

        while (10<HeroList.size()){
            HeroList.remove(0);
        }

        heroAdapter = new HeroAdapter(HeroList);

        ReciclerView1.setAdapter(heroAdapter);

    }


    public void sendPost(int i) {
        mAPIService.savePost(i).enqueue(new Callback<Hero>() {
            @Override
            public void onResponse(Call<Hero> call, Response<Hero> response) {

                if(response.isSuccessful()) {
                    response.body().toString();
                    AUX=response.body();
                    HeroList.add(AUX);
                    Toast.makeText(getApplicationContext(),response.body().getUrl(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Unable to submit post to API.",Toast.LENGTH_SHORT).show();
            }
        });
    }




}