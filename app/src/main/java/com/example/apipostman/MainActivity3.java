package com.example.apipostman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity3 extends AppCompatActivity {

    ImageView imageView;
    TextView textView1,textView4,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView1=findViewById(R.id.textview2);
        textView3=findViewById(R.id.textview3);
        textView4=findViewById(R.id.textview4);
        imageView=findViewById(R.id.imageview2);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String rasm=intent.getStringExtra("rasm");
        String description=intent.getStringExtra("description");
        Double price=intent.getDoubleExtra("price",0);
<<<<<<< HEAD

        Glide.with(MainActivity3.this).load(rasm).into(imageView);
        textView1.setText("Mahsulot narhi : "+name);
=======
        Glide.with(MainActivity3.this).load(rasm).into(imageView);
        textView1.setText("Mahsulot nomi : "+name);
>>>>>>> 5bca907 (xfbfx)
        textView3.setText("Mahsulot haqida batafsil : "+description);
        textView4.setText("Narhi : "+price);
    }
}