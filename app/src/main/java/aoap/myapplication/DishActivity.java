package aoap.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class DishActivity extends AppCompatActivity {

    private double total;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);

        Button totalButton = findViewById(R.id.total_button);
        Button nextButton = findViewById(R.id.dish_next_button);

        final Spinner dishSpinner = findViewById(R.id.dishes_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, MENU);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dishSpinner.setAdapter(adapter);
        dishSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                        TextView priceTV = findViewById(R.id.priceTV);
                        if (position == 0) {
                            priceTV.setText("2.50");
                            pos = 0;
                        } else if (position == 1) {
                            priceTV.setText("1.70");
                            pos = 1;
                        } else if (position == 2) {
                            priceTV.setText("1.50");
                            pos = 2;
                        } else if (position == 3) {
                            priceTV.setText("2.35");
                            pos = 3;
                        } else if (position == 4) {
                            priceTV.setText("1.50");
                            pos = 4;
                        } else if (position == 5) {
                            priceTV.setText("8.00");
                            pos = 5;
                        } else if (position == 6) {
                            priceTV.setText("4.00");
                            pos = 6;
                        } else if (position == 7) {
                            priceTV.setText("5.25");
                            pos = 7;
                        } else if (position == 8) {
                            priceTV.setText("12.00");
                            pos = 8;
                        } else if (position == 9) {
                            priceTV.setText("3.00");
                            pos = 9;
                        } else if (position == 10) {
                            priceTV.setText("7.50");
                            pos = 10;
                        } else if (position == 11) {
                            priceTV.setText("9.45");
                            pos = 11;
                        } else if (position == 12) {
                            priceTV.setText("20.00");
                            pos = 12;
                        } else if (position == 13) {
                            priceTV.setText("3.75");
                            pos = 13;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        //Nothing happens
                    }
                }
        );


        View.OnClickListener totalListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView priceTV = findViewById(R.id.priceTV);
                EditText quantityET = findViewById(R.id.quantity_et);
                TextView totalTV = findViewById(R.id.total_tv);

                double price = Double.parseDouble(priceTV.getText().toString());
                int quantity = Integer.parseInt(quantityET.getText().toString());
                total = price * quantity;

                DecimalFormat precision = new DecimalFormat("##0.00");
                totalTV.setText("$" + precision.format(total).toString());
            }
        };

        View.OnClickListener nextListener = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DecimalFormat precision = new DecimalFormat("##0.00");
                Intent nextIntent = new Intent(DishActivity.this, TableActivity.class);
                nextIntent.putExtra("dishPrice", precision.format(total).toString());
                nextIntent.putExtra("dish", MENU[pos]);
                startActivity(nextIntent);
            }
        };

        totalButton.setOnClickListener(totalListener);
        nextButton.setOnClickListener(nextListener);
    }

    private static String[] MENU = new String[] {
            "Cheese Burger", "Fries", "Sodey Pop", "Chicken Nuggets", "Chocolate Milk", "Yummy Kalamari",
            "Orange Chicken", "Ghost Pepper Burrito", "Lobster", "Burnt Toast", "Beer", "Pizza", "Filet Mignon", "Salad"
    };

}
