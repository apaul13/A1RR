package aoap.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent from = getIntent();

        String name = from.getStringExtra("name");
        String dish = from.getStringExtra("dish");
        String time = from.getStringExtra("time");
        String table = from.getStringExtra("table");
        String price = from.getStringExtra("price");

        TextView nameTV = findViewById(R.id.name_details);
        nameTV.setText("Name: " + name);

        TextView dishTV = findViewById(R.id.dish_details);
        dishTV.setText("Dish: " + dish);

        TextView timeTV = findViewById(R.id.time_details);
        timeTV.setText("Time: " + time);

        TextView tableTV = findViewById(R.id.table_details);
        tableTV.setText("Table: " + table);

        TextView priceTV = findViewById(R.id.price_details);
        priceTV.setText("Price: $" + price);

        Button toList = findViewById(R.id.toListButton);
        toList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent back = new Intent(DetailsActivity.this, ViewReservationsActivity.class);
                back.putExtra("source", "details");
                startActivity(back);
            }
        });
    }
}
