package com.example.bunny.ass3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final String[] question;
    private final Context context;


    public ListAdapter(Context context,String[] items){
        this.context=context;
        this.question=items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        String ques=question[i];
        viewHolder.tv.setText(ques);

        viewHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id",i);
                ((MainActivity)context).startActivity(intent);
                Toast toast = Toast.makeText(context,""+i,Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return question.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView tv;
        public ViewHolder(View view) {
            super(view);
            tv=(TextView) view.findViewById(R.id.textView);
        }

        @Override
        public String toString(){
            return super.toString() + "'"+ "'";
        }
    }
}
