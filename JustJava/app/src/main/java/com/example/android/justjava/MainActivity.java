package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream);
        Boolean whippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate);
        Boolean chocolate = chocolateCheckBox.isChecked();
        EditText nameTextView = (EditText) findViewById(R.id.name_text);
        String name = nameTextView.getText().toString();

        String priceMessage = "Name : " + name +
                "\nAdd whipped cream?" +whippedCream+
                "\nAdd chocolate?"+chocolate+
                "\nQuantity : "+ quantity +
                "\nTotal: " + NumberFormat.getCurrencyInstance().format(calculatePrice(quantity,whippedCream,chocolate)) +
                "\nThank You!";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just Java Order Summary for " + name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }

    /**
     * This method displays the given price on the screen.
     */
    private int calculatePrice(int number, boolean whippedCream, boolean chocolate) {
        int price = 5;
        if (whippedCream==true) {
            price += 1;
        }
        if (chocolate==true) {
            price += 2;
        }
        return price*number;
    }

    public void increment(View view) {
        if (quantity >= 100) {
            Toast toast = Toast.makeText(this,"Oops! Too much coffee",Toast.LENGTH_SHORT);
            toast.show();
        } else {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }

    public void decrement(View view) {
        if (quantity <= 1) {
            Toast toast = Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }
}