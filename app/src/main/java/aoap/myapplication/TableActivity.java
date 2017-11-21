package aoap.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.Activity;
import android.app.AlertDialog.Builder;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.*;//DatabaseReference;


public class TableActivity extends AppCompatActivity {
    static Context context; //static?
    static String dish;
    static String dishPrice;

    private FirebaseDatabase theDB;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        context = this.getBaseContext();

        theDB = FirebaseDatabase.getInstance();
        dbRef = theDB.getReference().child("Tables");


        Intent getCustomIntent = getIntent();
        Bundle bdCustom = getCustomIntent.getExtras();

        if(bdCustom != null)
        {
            final String tableNum = (String) bdCustom.get("tab");

            if (tableNum != null) {
                new AlertDialog.Builder(this).setMessage("Are you sure you'd like table "+tableNum+"?").setTitle("Confirmation")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(TableActivity.this, "Yaay", Toast.LENGTH_SHORT).show();
                                //
                                Intent toDishIntent = new Intent(TableActivity.this, DishActivity.class);
                                toDishIntent.putExtra("tab", tableNum);
                                startActivity(toDishIntent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();
            }
        }
    }
}

