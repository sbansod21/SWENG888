package edu.psu.sweng888.p3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

public class SelectedItemsActivity extends AppCompatActivity {
        private RecyclerView recyclerView;
        private ProductAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_selected_items);


            // Initialize RecyclerView to show selected items
            recyclerView = findViewById(R.id.selectedItemsRecyclerView);

            // Initialize your adapter
            adapter = new ProductAdapter(this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            // Retrieve and display selected items
            displaySelectedItems();

            //button to send email will open a popup for the maail app
            Button btnSendEmail = findViewById(R.id.btnSendEmail);
            btnSendEmail.setOnClickListener(view -> sendEmail());
        }

    private void displaySelectedItems() {
        ArrayList<Product> selectedProducts;
        //goes through the extra that was passed to retrieve and update the adapter
        if (getIntent() != null && getIntent().getExtras() != null) {
            selectedProducts = getIntent().getExtras().getParcelableArrayList("selectedProducts");
            adapter.setProducts(selectedProducts);
        }
    }

    private void sendEmail() {
        // Prepare selected products details
        String subject = "Selected Products Details";
        StringBuilder emailBody = new StringBuilder();
        ArrayList<Product> selectedProducts = getIntent().getExtras().getParcelableArrayList("selectedProducts");
        for (Product product : selectedProducts) {
            emailBody.append(product.getSeller()).append("\n");
            emailBody.append(product.getName()).append("\n");
            emailBody.append(product.getPrice()).append("\n");
            emailBody.append(product.getDescription()).append("\n");
            emailBody.append(product.getPicture()).append("\n");
            emailBody.append("------------------------- \n");
            //creates the body the email for each product
        }

        //sending the email
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sweng888mobileapps@gmail.com"}); // Set the recipient email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody.toString());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SelectedItemsActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

}


