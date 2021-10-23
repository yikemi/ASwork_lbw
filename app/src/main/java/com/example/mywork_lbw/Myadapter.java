package com.example.mywork_lbw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.collection.CircularArray;
import androidx.recyclerview.widget.RecyclerView;

public class Myadapter extends RecyclerView.Adapter <Myadapter.MyViewHolder>{
    private View itemView;
    private Context context;
    private ImageView imageView;
    private Button button;
    private List<Map<String,Object>> data;




    public Myadapter(List<Map<String,Object>> data,Context context){
        this.context=context;
        this.data=data;
    }






    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(itemView);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent main2 = new Intent(context,(Class<?>)data.get(position).get("detail"));
                Toast.makeText(context.getApplicationContext(),"正在努力跳转 :)",Toast.LENGTH_SHORT).show();
                context.startActivity(main2);
            }
        });
            //holder.button2.setOnClickListener((View.OnClickListener) data.get(position).get("detail"));
            holder.textView1.setText(data.get(position).get("name").toString());
            holder.textView2.setText(data.get(position).get("price").toString());
            holder.textView3.setText(data.get(position).get("color").toString());
            holder.textView4.setText(data.get(position).get("configure").toString());
            holder.imageView2.setImageResource((Integer) data.get(position).get("tutu"));
        }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView1,textView2,textView3,textView4;
        ImageView imageView2;
        Button button2;

        public MyViewHolder(View itemView) {
            super(itemView);
            button2=(Button) itemView.findViewById(R.id.button2);
            textView1=(TextView) itemView.findViewById(R.id.textView1);
            textView2=(TextView) itemView.findViewById(R.id.textView2);
            textView3=(TextView) itemView.findViewById(R.id.textView3);
            textView4=(TextView) itemView.findViewById(R.id.textView4);
            imageView2=(ImageView)itemView.findViewById(R.id.imageView2);
        }
    }

}

