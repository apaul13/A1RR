package aoap.myapplication;

import android.app.Activity;
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
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.Paint;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by artur on 11/15/17.
 */

public class CustomDrawings extends View {
    Paint paint1, paint2, paint3, paint4, paint5, paint6, paint7, paint8;
    Paint[] paints = {paint1, paint2, paint3, paint4, paint5, paint6, paint7, paint8};
    int width = this.getWidth();
    int height = this.getHeight();
    Rect r1, r2, r3, r4, r5, r6, r7, r8;
    Context context;
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

//                Log.i("test", "test1");
//                Map<String,String> tableMap = dataSnapshot.getValue(HashMap.class);
//                Log.i("test", "DATASNAPSHOT: "+tableMap.get("Table1"));
//                //Log.d("test", "datasnapshot: " + dataSnapshot.getValue(String.class));

        Log.i("test", "test");

        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint5 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint6 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint7 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint8 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(Color.GREEN);
        paint2.setColor(Color.GREEN);
        paint3.setColor(Color.GREEN);
        paint4.setColor(Color.GREEN);
        paint5.setColor(Color.GREEN);
        paint6.setColor(Color.GREEN);
        paint7.setColor(Color.GREEN);
        paint8.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        width = this.getWidth();
        height = this.getHeight();

        //left,top,right,bottom
        r1 = new Rect(250, 150, 550, 450); //top left
        canvas.drawRect(r1, paint1);
        r2 = new Rect(width - 550, height - 450, width - 250, height - 150); //bottom right
        canvas.drawRect(r2, paint2);
        r3 = new Rect(250, height - 450, 550, height - 150); //bottom left
        canvas.drawRect(r3, paint3);
        r4 = new Rect(width - 550, 150, width - 250, 450); //top right
        canvas.drawRect(r4, paint4);
        r5 = new Rect(width - 550, 650, width - 250, 950); //2nd column, 2nd row
        canvas.drawRect(r5, paint5);
        r6 = new Rect(250, 650, 550, 950); //1st column, 2nd row
        canvas.drawRect(r6, paint6);
        r7 = new Rect(250, height - 950, 550, height - 650); //1st column, 3rd row
        canvas.drawRect(r7, paint7);
        r8 = new Rect(width - 550, height - 950, width - 250, height - 650); //1st column, 2nd row
        canvas.drawRect(r8, paint8);
    }


    public boolean onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        if (event.getAction() == MotionEvent.ACTION_UP) {
            //Log.i("test", "Action up");
            //Log.i("test", "touchX: " + touchX + ", touchY: " + touchY);
            if (r1.contains(touchX, touchY)) {
                tableNum = "one";
                //myRef.child("Table 1").setValue("true");
                paint1.setColor(paint1.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r2.contains(touchX, touchY)) {
                //myRef.child("Table 2").setValue("true");
                paint2.setColor(paint2.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r3.contains(touchX, touchY)) {
                //myRef.child("Table 3").setValue("true");
                paint3.setColor(paint3.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r4.contains(touchX, touchY)) {
                //myRef.child("Table 4").setValue("true");
                paint4.setColor(paint4.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r5.contains(touchX, touchY)) {
                //myRef.child("Table 5").setValue("true");
                paint5.setColor(paint5.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r6.contains(touchX, touchY)) {
                //myRef.child("Table 6").setValue("true");
                paint6.setColor(paint6.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r7.contains(touchX, touchY)) {
                //myRef.child("Table 7").setValue("true");
                paint7.setColor(paint7.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r8.contains(touchX, touchY)) {
                //myRef.child("Table 8").setValue("true");
                paint8.setColor(paint8.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            }
            invalidate();

            context = TableActivity.context;
            intent = new Intent(context, TableActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.i("test", "intent starting");
            intent.putExtra("table", tableNum);

            context.startActivity(intent);
        }
        return true;
    }
}
