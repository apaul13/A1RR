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
import com.google.firebase.database.DatabaseReference;


public class TableActivity extends AppCompatActivity {
    static Context context; //static?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        context = this.getBaseContext();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Tables");

        Log.i("test", "sent bytes");
//        myRef.child("Table 1").setValue("false");
//        myRef.child("Table 2").setValue("false");
//        myRef.child("Table 3").setValue("false");
//        myRef.child("Table 4").setValue("false");
//        myRef.child("Table 5").setValue("false");
//        myRef.child("Table 6").setValue("false");
//        myRef.child("Table 7").setValue("false");
//        myRef.child("Table 8").setValue("false");


        Button a = findViewById(R.id.b1);
        a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TableActivity.this, TimeNameActivity.class);
                startActivity(intent);
            }
        });
        Intent getCustomIntent = getIntent();
        Bundle bdCustom = getCustomIntent.getExtras();

        Intent getDishIntent = getIntent();
        Bundle bdDish = getDishIntent.getExtras();
        final String dish = (String) bdDish.get("dish");
        final String dishPrice = (String) bdDish.get("dishPrice");
        Log.i("test","dish: "+dish);

        if(bdCustom != null)
        {
            //String tableConfirmation = (String) bd.get("val");
            final String tableNum = (String) bdCustom.get("tab");
            if (tableNum != null) {
                new AlertDialog.Builder(this).setMessage("Are you sure you'd like table "+tableNum+"?").setTitle("Confirmation")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(TableActivity.this, "Yaay", Toast.LENGTH_SHORT).show();
                                //
                                Intent toTimeNameIntent = new Intent(TableActivity.this, TimeNameActivity.class);
                                toTimeNameIntent.putExtra("tab", tableNum);
                                toTimeNameIntent.putExtra("dish", dish);
                                toTimeNameIntent.putExtra("dishPrice", dishPrice);
                                startActivity(toTimeNameIntent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();
            }
            //Log.i("test", "getName.get(val1): "+getName);
        }

    }

}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(new MyView(this));
//    }
//
//    public class MyView extends View {
//        public MyView(Context context) {
//            super(context);
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            //int x = getWidth();
//            //int y = getHeight();
//            int radius;
//            radius = 100;
//            Paint paint = new Paint();
//            paint.setStyle(Paint.Style.FILL);
//            paint.setColor(Color.WHITE);
//            canvas.drawPaint(paint);
//            paint.setColor(Color.parseColor("#da4747"));
//            canvas.drawCircle(0,0,radius,paint);
//        }
//    }
//}

