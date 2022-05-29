package com.example.apipostman;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apipostman.Response.ProductsResponse;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {


    Context context;
    ArrayList<ProductsResponse> productsResponseArrayList;

    public ProductsAdapter(Context context, ArrayList<ProductsResponse> productsResponseArrayList) {
        this.context = context;
        this.productsResponseArrayList = productsResponseArrayList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.products_layout,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.textView.setText(productsResponseArrayList.get(position).getName());
        Glide.with(context).load(productsResponseArrayList.get(position).getPhotoUrl()).into(holder.imageView);
        holder.linearLayout.setOnClickListener(view -> {
            Intent intent=new Intent(context,MainActivity3.class);
            intent.putExtra("rasm",productsResponseArrayList.get(position).getPhotoUrl());
            intent.putExtra("name",productsResponseArrayList.get(position).getName());
            intent.putExtra("description",productsResponseArrayList.get(position).getDescription());
            intent.putExtra("price",productsResponseArrayList.get(position).getPrice());
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return productsResponseArrayList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview1);
            textView=itemView.findViewById(R.id.textview1);
            linearLayout=itemView.findViewById(R.id.linearlayot1);
        }
    }
}
