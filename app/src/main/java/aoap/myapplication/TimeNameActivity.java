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

        final EditText name_et = (EditText) findViewById(R.id.name_et);
        final EditText time_et = (EditText) findViewById(R.id.time_et);

        Button confirm = (Button) findViewById(R.id.confirmation_button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSomePlace = new Intent(TimeNameActivity.this, ViewReservationsActivity.class);
                toSomePlace.putExtra("name", name_et.getText());
                toSomePlace.putExtra("time", time_et.getText());
                toSomePlace.putExtra("source", "timeName");
                startActivity(toSomePlace);
            }
        };
        confirm.setOnClickListener(listener);
    }
}
