package com.example.apipostman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apipostman.Request.Login;
import com.example.apipostman.Response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText1,editText2;

    String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1=findViewById(R.id.edittext1);
        editText2=findViewById(R.id.edittext2);
        button=findViewById(R.id.button1);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://valixon.bexatobot.uz/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api=retrofit.create(Api.class);

        button.setOnClickListener(view -> {
            Login login=new Login();
            login.setLogin(editText1.getText().toString());
            login.setPassword(editText2.getText().toString());

            Call<LoginResponse> call=api.loginuser(login);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.code()==200){
                        LoginResponse loginResponse=response.body();
                        token=loginResponse.getToken();
                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        intent.putExtra("token",token);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });
        });


    }
}