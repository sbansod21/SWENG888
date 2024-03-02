package edu.psu.sweng888.p3;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.*;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final LayoutInflater mInflater;
    private List<Product> mProducts; // Cached copy of products
    private Context context; // Add this to get context
    ProductAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }
    class ProductViewHolder extends RecyclerView.ViewHolder {
//        private final ImageView productImage;
        private final TextView productName;
        private final TextView productBrand;
        private final TextView productPrice;

        private ProductViewHolder(View itemView) {
            super(itemView);
//            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productBrand = itemView.findViewById(R.id.product_brand);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        if (mProducts != null) {
            Product current = mProducts.get(position);
            holder.productName.setText(current.getName());
            holder.productBrand.setText(current.getSeller()); // Assuming 'seller' is the brand
            holder.productPrice.setText("$" + current.getPrice());

            holder.itemView.setSelected(current.isSelected()); // Highlight the item if selected

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toggle selection state
                    boolean newSelectionState = !current.isSelected();
                    current.setSelected(newSelectionState);
                    notifyItemChanged(position); // Refresh item to display selection state visually
                }
            });

        } else {
            // Covers the case of data not being ready yet.
            holder.productName.setText("No Product Available");
        }

    }

    void setProducts(List<Product> products){
        mProducts = products;
        notifyDataSetChanged();
    }

    public List<Product> getProducts()
    {
        return mProducts;
    }


    @Override
    public int getItemCount() {
        if (mProducts != null)
            return mProducts.size();
        else return 0;
    }

}

