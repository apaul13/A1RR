package aoap.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        Intent getDishIntent = getIntent();
        Bundle bdDish = getDishIntent.getExtras();
        final String tableNum = (String) bdDish.get("tab");
        final String dish = (String) bdDish.get("dish");
        final String dishPrice = (String) bdDish.get("dishPrice");

        Button confirm = findViewById(R.id.confirmation_button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toViewReservation = new Intent(TimeNameActivity.this, ViewReservationsActivity.class);
                toViewReservation.putExtra("name", name_et.getText().toString());
                toViewReservation.putExtra("time", time_et.getText().toString());
                toViewReservation.putExtra("dish", dish);
                toViewReservation.putExtra("tab", tableNum);
                toViewReservation.putExtra("dishPrice", dishPrice);
                toViewReservation.putExtra("source", "timeName");
                startActivity(toViewReservation);
            }
        };
        confirm.setOnClickListener(listener);
    }
}
