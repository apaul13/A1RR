package aoap.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.app.AlertDialog;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.*;


public class TableActivity extends AppCompatActivity {
    static Context context; //necessary for the customDrawings class to be able to access it.

    private FirebaseDatabase theDB;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        context = this.getBaseContext();

        //Was used to add all tables to the database.
        theDB = FirebaseDatabase.getInstance();
        dbRef = theDB.getReference().child("Tables");

        //Intent to get everything from the customDrawings class.
        Intent getCustomIntent = getIntent();
        Bundle bdCustom = getCustomIntent.getExtras();

        if(bdCustom != null)
        {
            final String tableNum = (String) bdCustom.get("tab");
            //If a tableNumber already exists, the user has selected a table.
            if (tableNum != null) {
                //Ask the user to confirm their table.
                new AlertDialog.Builder(this).setMessage("Are you sure you'd like table "+tableNum+"?").setTitle("Confirmation")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(TableActivity.this, "Table "+tableNum+" confirmed.", Toast.LENGTH_SHORT).show();
                                //If confirmed, go to DishActivity, and takes the table number too.
                                Intent toDishIntent = new Intent(TableActivity.this, DishActivity.class);
                                toDishIntent.putExtra("tab", tableNum);
                                startActivity(toDishIntent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show(); //nothing happens if don't like the table you chose.
            }
        }
    }
}

