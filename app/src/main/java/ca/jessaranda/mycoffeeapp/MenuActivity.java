package ca.jessaranda.mycoffeeapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private TextView orderDesc;
    private String cupSize = "";
    private String coffeeType = "";

    private TextView sugarCountTextView;
    private TextView creamCountTextView;
    private int sugarCount = 0;
    private int creamCount = 0;
    private int orderCount = 0;


    private List<String> allOrdersList = new ArrayList<>();



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        orderDesc = findViewById(R.id.orderDesc);

        // Clear the orderDesc TextView initially
        orderDesc.setText("");  // This line clears the text

        // Find the TextViews for sugar and cream counts
        sugarCountTextView = findViewById(R.id.sugarCount);
        creamCountTextView = findViewById(R.id.creamCount);


        // Set default values for sugarCount and creamCount
        sugarCount = 0;
        creamCount = 0;

        // Update sugar and cream count TextViews with default values
        updateSugarCount();
        updateCreamCount();


        // Set up button click listeners
        findViewById(R.id.small).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cupSize = "Small";
                updateCupDescription();
            }
        });

        findViewById(R.id.med).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cupSize = "Medium";
                updateCupDescription();
            }
        });

        findViewById(R.id.large).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cupSize = "Large";
                updateCupDescription();
            }
        });

        findViewById(R.id.xlarge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cupSize = "XLarge";
                updateCupDescription();
            }
        });


        // Set up click listeners for coffee type buttons
        findViewById(R.id.black).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeeType = "Black";
                sugarCount = 0;
                creamCount = 0;
                updateSugarCount();
                updateCreamCount();
                updateCupDescription();
            }
        });


        findViewById(R.id.reg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeeType = "Regular";
                sugarCount = 1;
                creamCount = 1;
                updateSugarCount();
                updateCreamCount();
                updateCupDescription();
            }
        });

        findViewById(R.id.dubdub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeeType = "Double Double";
                sugarCount = 2;
                creamCount = 2;
                updateSugarCount();
                updateCreamCount();
                updateCupDescription();
            }
        });

        findViewById(R.id.triptrip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeeType = "Triple Triple";
                sugarCount = 3;
                creamCount = 3;
                updateSugarCount();
                updateCreamCount();
                updateCupDescription();
            }
        });

        findViewById(R.id.decaf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeeType = "Decaf";
                sugarCount = 0;
                creamCount = 0;
                updateSugarCount();
                updateCreamCount();
                updateCupDescription();
            }
        });

        findViewById(R.id.tea).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeeType = "Tea";
                sugarCount = 0;
                creamCount = 0;
                updateSugarCount();
                updateCreamCount();
                updateCupDescription();
            }
        });

        findViewById(R.id.espresso).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeeType = "Espresso";
                sugarCount = 0;
                creamCount = 0;
                updateSugarCount();
                updateCreamCount();
                updateCupDescription();
            }
        });


        // Set up click listeners for sugar and cream buttons
        findViewById(R.id.sugar_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sugarCount++;
                updateSugarCount();  // Update the sugar count
                updateCupDescription();  // Update the cup description
            }
        });

        findViewById(R.id.sugar_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sugarCount > 0) {
                    sugarCount--;
                    updateSugarCount();  // Update the sugar count
                    updateCupDescription();  // Update the cup description
                }
            }
        });

        findViewById(R.id.cream_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creamCount++;
                updateCreamCount();  // Update the cream count
                updateCupDescription();  // Update the cup description
            }
        });

        findViewById(R.id.cream_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (creamCount > 0) {
                    creamCount--;
                    updateCreamCount();  // Update the cream count
                    updateCupDescription();  // Update the cup description
                }
            }
        });


        // Set up button click listeners for Account and Settings
        findViewById(R.id.account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, Account.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, Settings.class);
                startActivity(intent);

            }
        });


        // Add click listener for "Add to Order" button
        Button addToOrder = findViewById(R.id.addToOrder);
        addToOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Increment order count and update the display
                orderCount++;
                updateOrderCount();

// CODES ADDED TO SHOW ALL ON ORDER_DETAILS_ACTIVITY - START

                // Add the order description to the list of all orders
                allOrdersList.add(orderDesc.getText().toString());

// - END


                // Reset order description
                resetOrderDescription();
            }
        });


        // CODES ADDED FOR CLEAR ORDER BUTTON - START

        Button clearOrderButton = findViewById(R.id.clearOrder);
        clearOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TOAST - START
                if (orderCount <= 0) {
                    // Display a toast message indicating to add an order first
                    Toast.makeText(MenuActivity.this, "Please add an order first!", Toast.LENGTH_SHORT).show();
                    return;
                }
                // - END

                // Build an alert dialog for confirmation
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setMessage("Are you sure you want to delete all orders?")
                        .setTitle("Confirmation")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Reset order count and update the display
                                orderCount = 0;
                                updateOrderCount();

                                // Clear the order description
                                resetOrderDescription();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Do nothing, simply dismiss the dialog
                                dialog.dismiss();
                            }
                        });

                // Create and show the dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        // - END


    }

    private void resetOrderDescription() {
        orderDesc.setText("");
    }

    // Method to update the sugar count TextView
    private void updateSugarCount() {
        sugarCountTextView.setText(String.valueOf(sugarCount));
    }

    // Method to update the cream count TextView
    private void updateCreamCount() {
        creamCountTextView.setText(String.valueOf(creamCount));
    }

    private void updateCupDescription() {
        String description = cupSize + " " + coffeeType + " w/ " + sugarCount + " sugar(s) & " + creamCount + " cream(s)";
        orderDesc.setText(description);
    }

    private void updateOrderCount() {
        TextView orderCountTextView = findViewById(R.id.orderCount);

        // Set orderCount as the text
        orderCountTextView.setText(String.valueOf(orderCount + " " + "cup/s"));

        // Set a click listener to navigate to OrderDetailsActivity when clicked
        orderCountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TOAST - START
                if (orderCount <= 0) {
                    // Display a toast message indicating to add an order first
                    Toast.makeText(MenuActivity.this, "Please pick order first!", Toast.LENGTH_SHORT).show();
                    return;
                }
                // - END

                // Create an intent to navigate to OrderDetailsActivity
                Intent intent = new Intent(MenuActivity.this, OrderDetailsActivity.class);

// CODES ADDED TO SHOW ALL ON ORDER_DETAILS_ACTIVITY - START

                // Pass all orders to OrderDetailsActivity
                intent.putStringArrayListExtra("ALL_ORDERS", new ArrayList<>(allOrdersList));

                // - END

                startActivity(intent);
            }
        });
    }

}

