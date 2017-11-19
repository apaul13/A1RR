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
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.Paint;
import android.widget.Toast;


/**
 * Created by artur on 11/15/17.
 */

public class CustomDrawings extends View {
    Paint paint1,paint2, paint3, paint4, paint5, paint6, paint7, paint8;
    Paint[] paints = {paint1,paint2, paint3, paint4, paint5, paint6, paint7, paint8};
    int width = this.getWidth();
    int height = this.getHeight();
    Rect r1,r2,r3,r4,r5,r6,r7,r8;

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


//        for (Paint p: paints) {
//            p.setColor(Color.GREEN);
//        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        width = this.getWidth();
        height = this.getHeight();

        //left,top,right,bottom
        r1 = new Rect(250,150,550,450); //top left
        canvas.drawRect(r1, paint1);
        r2 = new Rect(width-550,height-450,width-250,height-150); //bottom right
        canvas.drawRect(r2, paint2);
        r3 = new Rect(250,height-450,550,height-150); //bottom left
        canvas.drawRect(r3, paint3);
        r4= new Rect(width-550,150,width-250,450); //top right
        canvas.drawRect(r4, paint4);
        r5= new Rect(width-550,650,width-250,950); //2nd column, 2nd row
        canvas.drawRect(r5, paint5);
        r6= new Rect(250,650,550,950); //1st column, 2nd row
        canvas.drawRect(r6, paint6);
        r7= new Rect(250,height-950,550,height-650); //1st column, 3rd row
        canvas.drawRect(r7, paint7);
        r8= new Rect(width-550,height-950,width-250,height-650); //1st column, 2nd row
        canvas.drawRect(r8, paint8);

        //TODO: figure out floats so coords aren't hard coded. doubles DON'T work
        //bottom 4
//        canvas.drawCircle(width - 400, height - 300, 150, paint); //bottom right
//        canvas.drawCircle(400, this.getHeight() - 300, 150, paint); //bottom left
//        canvas.drawCircle(this.getWidth() - 400, this.getHeight() - 800, 150, paint); //right
//        canvas.drawCircle(400, this.getHeight() - 800, 150, paint); //left
//        //top 4
//        canvas.drawCircle(this.getWidth() - 400, 300, 150, paint); //top right
//        canvas.drawCircle(400, 300, 150, paint); //top left
//        canvas.drawCircle(this.getWidth() - 400, 800, 150, paint); //right
//        canvas.drawCircle(400, 800, 150, paint); //left
    }


    public boolean onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();


        if (event.getAction() == MotionEvent.ACTION_UP) {
            //Log.i("test", "Action up");
            Log.i("test", "touchX: "+touchX+", touchY: "+touchY);
            if (r1.contains(touchX,touchY)) {
                paint1.setColor(paint1.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r2.contains(touchX,touchY)) {
                paint2.setColor(paint2.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r3.contains(touchX,touchY)) {
                paint3.setColor(paint3.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r4.contains(touchX,touchY)) {
                paint4.setColor(paint4.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r5.contains(touchX,touchY)) {
                paint5.setColor(paint5.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r6.contains(touchX,touchY)) {
                paint6.setColor(paint6.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r7.contains(touchX,touchY)) {
                paint7.setColor(paint7.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            } else if (r8.contains(touchX,touchY)) {
                paint8.setColor(paint8.getColor() == Color.GREEN ? Color.WHITE : Color.GREEN);
            }
            invalidate();
            Intent intent = new Intent(CustomDrawings.this,DishActivity.class);
        }
        return true;
    }


//    public boolean onTouchEvent(MotionEvent event) {
//        //Log.i("test", "waiting for events!");
//        int touchX = (int) event.getX();
//        int touchY = (int) event.getY();
//
//        if (event.getAction() == MotionEvent.ACTION_UP) {
//            //Log.i("test", "Action up");
//            Log.i("test", "height: "+height+", width: "+width);
//            Log.i("test", "TouchX: "+touchX+", TouchY: "+touchY+", equationL: "
//                    +(Math.pow((touchX - width+400),2) + Math.pow((touchY - height+300),2))
//                    +", equationR: "+(22500));
//            if (    //if the click was in a circle
//                    //bottom 4
//                    (Math.pow(touchX - width+400,2) + Math.pow(touchY - height+300,2))  < (22500) ||
//                    (Math.pow(touchX - 400,2) + Math.pow(touchY - height+300,2))  < (22500) ||
//                    (Math.pow(touchX - width + 400,2) + Math.pow(touchY - height + 800,2))  < (22500) ||
//                    (Math.pow(touchX - 400,2) + Math.pow(touchY - height + 800,2))  < (22500) ||
//                    //top 4
//                    (Math.pow(touchX - width + 400,2) + Math.pow(touchY - 300,2))  < (22500) ||
//                    (Math.pow(touchX - 400,2) + Math.pow(touchY - 300,2))  < (22500) ||
//                    (Math.pow(touchX - width + 400,2) + Math.pow(touchY - 800,2)) < (22500) ||
//                    (Math.pow(touchX - 400,2) + Math.pow(touchY - 800,2))  < (22500))
//            {
//                Log.i("test", "A TABLE WAS CLICKED!");
//            }
//        }
//        return true;
//    }
}
