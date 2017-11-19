package aoap.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button makeReservationButton = findViewById(R.id.new_reservation_button);
        Button viewReservationButton = findViewById(R.id.view_reservation_button);

        View.OnClickListener makeReservationListener = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent toDishIntent = new Intent(MainActivity.this, DishActivity.class);
                startActivity(toDishIntent);
            }
        };

        View.OnClickListener viewReservationListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent toViewReservationIntent = new Intent(MainActivity.this, ViewReservationsActivity.class);
                toViewReservationIntent.putExtra("source", "mainActivity");
                startActivity(toViewReservationIntent);
            }
        };

        makeReservationButton.setOnClickListener(makeReservationListener);
        viewReservationButton.setOnClickListener(viewReservationListener);

    }
}
