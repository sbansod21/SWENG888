package edu.psu.sweng888.p5.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.psu.sweng888.p4.MakeupItem;
import edu.psu.sweng888.p5.R;

import java.util.List;

public class MakeupAdapter extends RecyclerView.Adapter<MakeupAdapter.ViewHolder> {

    private List<MakeupItem> itemList;

    public MakeupAdapter(List<MakeupItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create a new ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_makeup, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind data to the ViewHolder's views
        MakeupItem item = itemList.get(position);
        holder.textViewName.setText(item.getName());
        holder.textViewBrand.setText(item.getBrand());
        holder.textViewPrice.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewBrand;
        TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            // ViewHolder class to hold item views
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewBrand = itemView.findViewById(R.id.textViewBrand);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
