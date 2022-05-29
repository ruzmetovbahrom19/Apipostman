package com.example.apipostman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.apipostman.Response.ProductsResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    String token;
    ArrayList<ProductsResponse> productsResponseArrayList;
    RecyclerView recyclerView;
    ProductsAdapter productsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        token=intent.getStringExtra("token");

        recyclerView=findViewById(R.id.recyclerview1);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://valixon.bexatobot.uz/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api=retrofit.create(Api.class);
        Call<List<ProductsResponse>> call=api.hammamahsulot("Token "+token);
        call.enqueue(new Callback<List<ProductsResponse>>() {
            @Override
            public void onResponse(Call<List<ProductsResponse>> call, Response<List<ProductsResponse>> response) {
                if (response.code()==200){
                    productsResponseArrayList= (ArrayList<ProductsResponse>) response.body();
                    recyclerView.setLayoutManager(new GridLayoutManager(MainActivity2.this,2));
                    productsAdapter=new ProductsAdapter(MainActivity2.this,productsResponseArrayList);
                    recyclerView.setAdapter(productsAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<ProductsResponse>> call, Throwable t) {

            }
        });
    }
}