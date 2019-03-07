package com.example.roomdatabaseexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    MainActivity mainActivity;
    List<Model> list;

    public MyAdapter(MainActivity mainActivity, List<Model> list) {
        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.row,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getName());
        viewHolder.branch.setText(list.get(i).getBranch());
        viewHolder.roll.setText(list.get(i).getId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,roll,branch;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            roll = itemView.findViewById(R.id.roll);
            branch = itemView.findViewById(R.id.branch);
        }
    }
}
