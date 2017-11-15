package aoap.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);

        Button totalButton = findViewById(R.id.total_button);


        View.OnClickListener totalListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText priceET = findViewById(R.id.unit_price_et);
                EditText quantityET = findViewById(R.id.quantity_et);
                TextView totalTV = findViewById(R.id.total_tv);

                double price = Double.parseDouble(priceET.getText().toString());
                int quantity = Integer.parseInt(quantityET.getText().toString());
                double total = price * quantity;

                totalTV.setText("$" + total);
            }
        };

        totalButton.setOnClickListener(totalListener);
    }
}
