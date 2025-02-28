package com.example.ptitapp1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptitapp1.R;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private List<Cat> list;
    private Context context;
    private OnCatItemListener onCatItemListener;

    public void setOnCatItemListener(OnCatItemListener onCatItemListener) {
        this.onCatItemListener = onCatItemListener;
    }

    public CatAdapter(Context context, List<Cat> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) { //gan gia tri cho 1 view holder tai vi tri position
        Cat cat = list.get(position);
//        list.set
        holder.img.setImageResource(cat.getImage());
        holder.txtName.setText(cat.getName());
//        holder.cardView.setOnClickListener(v -> {
//            Toast.makeText(context.getApplicationContext(), cat.getName(), Toast.LENGTH_SHORT).show();
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtName;
//        CardView cardView;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txtName = itemView.findViewById(R.id.txtName);
//            itemView.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCatItemListener.onItemClick(v, getAdapterPosition());
                }
            });
//            cardView = itemView.findViewById(R.id.cardView);
        }

    }

    public interface OnCatItemListener {
        public void onItemClick(View v, int position);
    }
}
