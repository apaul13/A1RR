package aoap.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
