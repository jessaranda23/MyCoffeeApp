package ca.jessaranda.mycoffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);


        // Retrieve the list of orders from the intent
        ArrayList<String> allOrders = getIntent().getStringArrayListExtra("ALL_ORDERS");

        // Display all orders in the TextView
        TextView orderDetailsText = findViewById(R.id.orderDetailsText);


        // Build a string containing all orders
        StringBuilder orderDetails = new StringBuilder();
        for (String order : allOrders) {
            orderDetails.append(order).append("\n" + "\n");  // Modify this to match your order format
        }

        orderDetailsText.setText(orderDetails.toString());



        // Inside onCreate() after setting the content view
        Button payOrderButton = findViewById(R.id.payOrderButton);
        payOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display a Toast when the button is clicked
                Toast.makeText(OrderDetailsActivity.this, "Order Paid", Toast.LENGTH_SHORT).show();
            }
        });


    }
}