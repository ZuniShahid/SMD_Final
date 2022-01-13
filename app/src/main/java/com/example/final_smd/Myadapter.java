package com.example.final_smd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder>
{
    ArrayList<String> list = new ArrayList<String>();
    public Myadapter(ArrayList<String> list)
    {
        this.list = list;
    }

    @NonNull
    @Override
    public Myadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather,parent,false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.textView1.setText(list.get(position));
        holder.textView2.setText(list.get(position));
        holder.textView3.setText(list.get(position));
        holder.textView4.setText(list.get(position));

    }

    public int getItemCount()
    {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView1,textView2,textView3,textView4;
        public  MyViewHolder(View view)
        {
            super(view);
            textView1 = view.findViewById(R.id.textView2);
            textView2 = view.findViewById(R.id.textView5);
            textView3 =  view.findViewById(R.id.textView7);
            textView4 =  view.findViewById(R.id.textView9);
        }


    }
}
