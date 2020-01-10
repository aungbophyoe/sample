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
import com.example.bottomnav.POJO.number;
import com.example.bottomnav.R;

import java.util.List;

public class numAdapter extends RecyclerView.Adapter<numAdapter.ViewHolder> {

    private Context context;
    private List<number>numlist;
    private LayoutInflater lyinflater;

    public numAdapter(Context context,List<number>numlist){
        this.context=context;
        this.numlist=numlist;
        lyinflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=lyinflater.from(context).inflate(R.layout.row_items,parent,false);
        return new numAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        number Number=numlist.get(position);
        holder.numtxt.setText(Number.getNum());
        final String num=Number.getNum();
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Detailitem.class);
                intent.putExtra("key",num);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return numlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView numtxt;
        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numtxt=itemView.findViewById(R.id.txt);
            card=itemView.findViewById(R.id.card);

        }
    }
}
