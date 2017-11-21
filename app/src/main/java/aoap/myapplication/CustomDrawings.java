package aoap.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Paint;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


/**
 * Created by artur on 11/15/17.
 */

public class CustomDrawings extends View {
    Paint paint1, paint2, paint3, paint4, paint5, paint6, paint7, paint8; //colors for the tables
    int width = this.getWidth(); //width and height of the screen
    int height = this.getHeight();
    Rect r1, r2, r3, r4, r5, r6, r7, r8; //the 8 tables
    Context context; //context to be grabbed from TableActivity. Needed to use intent.
    Intent intent;
    String tableNum;

    public CustomDrawings(Context context) {
        super(context);
        init(null);
    }

    public CustomDrawings(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(null);
    }

    public CustomDrawings(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(null);
    }

    public CustomDrawings(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(null);
    }

    public void init(@Nullable AttributeSet set) {
        //intnent was to use firebase here to check if the table is already taken.
        FirebaseDatabase theDB;
        DatabaseReference dbRef;
        theDB = FirebaseDatabase.getInstance();
        dbRef = theDB.getReference().child("Tables");

        dbRef.addValueEventListener(new ValueEventListener() { //attach listener
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) { //something changed!
                Map<String,String> tableMap = (Map<String,String>) dataSnapshot.getValue();
                Log.i("test", "DATASNAPSHOT: "+tableMap.get("Table 1"));
                invalidate();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

        //sets all the tables to green, as in free.
        final int c1=Color.GREEN,c2=Color.GREEN,c3=Color.GREEN,c4=Color.GREEN,
                c5=Color.GREEN,c6=Color.GREEN,c7=Color.GREEN,c8=Color.GREEN;

        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint5 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint6 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint7 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint8 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(c1);
        paint2.setColor(c2);
        paint3.setColor(c3);
        paint4.setColor(c4);
        paint5.setColor(c5);
        paint6.setColor(c6);
        paint7.setColor(c7);
        paint8.setColor(c8);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        width = this.getWidth();
        height = this.getHeight();

        //creates all the tables.
        r1 = new Rect(250, 150, 550, 450); //top left
        canvas.drawRect(r1, paint1);
        r8 = new Rect(width - 550, height - 450, width - 250, height - 150); //bottom right
        canvas.drawRect(r8, paint8);
        r7 = new Rect(250, height - 450, 550, height - 150); //bottom left
        canvas.drawRect(r7, paint7);
        r2 = new Rect(width - 550, 150, width - 250, 450); //top right
        canvas.drawRect(r2, paint2);
        r4 = new Rect(width - 550, 625, width - 250, 925); //2nd column, 2nd row
        canvas.drawRect(r4, paint4);
        r3 = new Rect(250, 625, 550, 925); //1st column, 2nd row
        canvas.drawRect(r3, paint3);
        r5 = new Rect(250, height - 900, 550, height - 600); //1st column, 3rd row
        canvas.drawRect(r5, paint5);
        r6 = new Rect(width - 550, height - 900, width - 250, height - 600); //1st column, 2nd row
        canvas.drawRect(r6, paint6);
    }


    public boolean onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        if (event.getAction() == MotionEvent.ACTION_UP) {
            //Log.i("test", "Action up");
            //Log.i("test", "touchX: " + touchX + ", touchY: " + touchY);
            if (r1.contains(touchX, touchY)) {
                tableNum = "1";
                //myRef.child("Table 1").setValue("true");
                paint1.setColor(paint1.getColor() == Color.GREEN ? Color.RED : Color.GREEN);
            } else if (r2.contains(touchX, touchY)) {
                tableNum = "2";
                //myRef.child("Table 2").setValue("true");
                paint2.setColor(paint2.getColor() == Color.GREEN ? Color.RED : Color.GREEN);
            } else if (r3.contains(touchX, touchY)) {
                tableNum = "3";
                //myRef.child("Table 3").setValue("true");
                paint3.setColor(paint3.getColor() == Color.GREEN ? Color.RED : Color.GREEN);
            } else if (r4.contains(touchX, touchY)) {
                tableNum = "4";
                //myRef.child("Table 4").setValue("true");
                paint4.setColor(paint4.getColor() == Color.GREEN ? Color.RED : Color.GREEN);
            } else if (r5.contains(touchX, touchY)) {
                tableNum = "5";
                //myRef.child("Table 5").setValue("true");
                paint5.setColor(paint5.getColor() == Color.GREEN ? Color.RED : Color.GREEN);
            } else if (r6.contains(touchX, touchY)) {
                tableNum = "6";
                //myRef.child("Table 6").setValue("true");
                paint6.setColor(paint6.getColor() == Color.GREEN ? Color.RED : Color.GREEN);
            } else if (r7.contains(touchX, touchY)) {
                tableNum = "7";
                //myRef.child("Table 7").setValue("true");
                paint7.setColor(paint7.getColor() == Color.GREEN ? Color.RED : Color.GREEN);
            } else if (r8.contains(touchX, touchY)) {
                tableNum = "8";
                //myRef.child("Table 8").setValue("true");
                paint8.setColor(paint8.getColor() == Color.GREEN ? Color.RED : Color.GREEN);
            }
            invalidate(); //changes color of selected square.

            context = TableActivity.context; //needed to use intent in non-activity
            intent = new Intent(context, TableActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("tab", tableNum);

            context.startActivity(intent);
        }
        return true;
    }
}
