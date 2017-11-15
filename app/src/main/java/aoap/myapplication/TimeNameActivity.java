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

        EditText name_et = (EditText) findViewById(R.id.name_et);
        EditText time_et = (EditText) findViewById(R.id.time_et);

        Button next = (Button) findViewById(R.id.name_and_time_next_b);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSomePlace = new Intent(TimeNameActivity.this, ViewReservationsActivity.class);
            }
        };
    }
}
