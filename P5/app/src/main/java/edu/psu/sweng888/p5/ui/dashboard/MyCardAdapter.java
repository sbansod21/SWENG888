package edu.psu.sweng888.p5.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import edu.psu.sweng888.p4.MakeupItem;
import edu.psu.sweng888.p5.R;

public class MyCardAdapter extends RecyclerView.Adapter<MyCardAdapter.MyViewHolder> {
    private List<MakeupItem> data;

    public MyCardAdapter(List<MakeupItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MakeupItem item = data.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewBrand;

        TextView textViewPrice;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewBrand = itemView.findViewById(R.id.textViewDescription);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }

        public void bind(MakeupItem item) {
            textViewTitle.setText(item.getName());
            textViewBrand.setText(item.getBrand());
            textViewPrice.setText(item.getPrice());
        }
    }
}
