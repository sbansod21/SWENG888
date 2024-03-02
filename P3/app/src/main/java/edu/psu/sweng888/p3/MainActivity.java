package edu.psu.sweng888.p3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class MainActivity extends AppCompatActivity {
    private ProductAdapter mAdapter;
    private ProductDbHelper dbHelper;
    private Executor executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());
    List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new ProductDbHelper(this);


// Adding products to the list
//        products.add(new Product(1, "Liquid Foundation", "Lightweight and hydrating foundation with medium coverage.", "Maybelline", 12.99, "drawable/foundation"));
//        products.add(new Product(2, "Lipstick", "Matte finish lipstick in a bold red shade.", "MAC", 18.99, "drawable/mac_lipstick"));
//        products.add(new Product(3, "Eyeliner", "Waterproof liquid eyeliner with precision tip.", "Stila", 22.00, "drawable/stila_eyeliner"));
//        products.add(new Product(4, "Blush", "Powder blush offering a natural, rosy glow.", "NARS", 30.00, "drawable/nars_blush"));
//        products.add(new Product(5, "Eyeshadow Palette", "12-color eyeshadow palette with both matte and shimmer shades.", "ColorPop", 54.00, "drawable/colorpop_eyeshadow"));
//        products.add(new Product(6, "Concealer", "Full coverage concealer for under-eye and blemishes.", "Tarte", 27.00, "drawable/tarte_concealer"));
//        products.add(new Product(7, "Bronzer", "Sun-kissed bronzing powder for a natural look.", "Benefit", 30.00, "drawable/benefit_bronzer"));
//        products.add(new Product(8, "Setting Spray", "Long-lasting makeup setting spray.", "Urban Decay", 33.00, "drawable/urbandecay_setting_spray"));
//        products.add(new Product(9, "Mascara", "Volumizing and lengthening Mascara.", "elf", 9.99, "drawable/elf_mascara.jpg"));
//        products.add(new Product(10, "LipGloss", "Shiny lip gloss.", "elf", 12.99, "drawable/elf_lipgloss"));


        // Inserting product in background thread
        executor.execute(new Runnable() {
            @Override
            public void run() {

//                for(Product p: products){
//                    addProduct(p);
//                }
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        mAdapter = new ProductAdapter(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // method to fetch products from database
        fetchProducts();

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Product> selectedProducts = new ArrayList<>();
                for (Product product : mAdapter.getProducts()) { // Ensure you have a method in your adapter to get the current list of products
                    if (product.isSelected()) {
                        selectedProducts.add(product);
                    }
                }

                // Start new activity and pass selected products
                Intent intent = new Intent(MainActivity.this, SelectedItemsActivity.class);
                intent.putParcelableArrayListExtra("selectedProducts", selectedProducts); // Make sure Product implements Parcelable
                startActivity(intent);
            }
        });
    }

    private void fetchProducts() {
        // Fetch products from the database and update the adapter
        executor.execute(() -> {
            List<Product> products = dbHelper.getAllProducts();
            handler.post(() -> mAdapter.setProducts(products));
        });
    }
    public long addProduct(Product product) {
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ProductContract.ProductEntry.COLUMN_NAME_NAME, product.getName());
        values.put(ProductContract.ProductEntry.COLUMN_NAME_DESCRIPTION, product.getDescription());
        values.put(ProductContract.ProductEntry.COLUMN_NAME_SELLER, product.getSeller());
        values.put(ProductContract.ProductEntry.COLUMN_NAME_PRICE, product.getPrice());
        values.put(ProductContract.ProductEntry.COLUMN_NAME_PICTURE, product.getPicture().toString());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ProductContract.ProductEntry.TABLE_NAME, null, values);
        return newRowId;
    }


}
