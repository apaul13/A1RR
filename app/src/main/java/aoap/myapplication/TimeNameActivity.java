package aoap.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TimeNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_name);

        final EditText name_et = findViewById(R.id.name_et);
        final EditText time_et = findViewById(R.id.time_et);

        Intent from = getIntent();

        final String price = from.getStringExtra("price");
        final String table = from.getStringExtra("table");
        final String dish = from.getStringExtra("dish");

        Button confirm = findViewById(R.id.confirmation_button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toViewReservation = new Intent(TimeNameActivity.this, ViewReservationsActivity.class);
                toViewReservation.putExtra("name", name_et.getText().toString());
                toViewReservation.putExtra("time", time_et.getText().toString());
                toViewReservation.putExtra("dish", dish);
                toViewReservation.putExtra("table", table);
                toViewReservation.putExtra("price", price);
                toViewReservation.putExtra("source", "timeName");
                startActivity(toViewReservation);
            }
        };
        confirm.setOnClickListener(listener);
    }
}
