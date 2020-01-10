package com.example.bottomnav.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bottomnav.Detailitem;
import com.example.bottomnav.POJO.item;
import com.example.bottomnav.R;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {
        private Context context;
        private LayoutInflater layoutInflater;
        private List<item> itemlist;

    public itemAdapter(Context context, List<item>itemlists){
        this.context=context;
        this.itemlist=itemlists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_items,parent,false);
        return new itemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        item i=itemlist.get(position);
        holder.txt.setText(i.getName());
        final String name=i.getName();
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idet=new Intent(context, Detailitem.class);
                idet.putExtra("key",name);
                context.startActivity(idet);


            }
        });

    }

    @Override
    public int getItemCount() {

        return itemlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        CardView card;

        public ViewHolder(View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt);
            card=itemView.findViewById(R.id.card);
        }
    }

}
