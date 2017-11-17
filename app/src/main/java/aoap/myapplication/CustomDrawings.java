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
    Paint paint;
    int width = this.getWidth();
    int height = this.getHeight();

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

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);

        //Rect rect = new Rect(10,10,200,200);
        //canvas.drawRect(rect, paint);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        //TODO: figure out floats so coords aren't hard coded. doubles DON'T work
        //bottom 4
        canvas.drawCircle(width-400,height-300,150,paint); //bottom right
        canvas.drawCircle(400,this.getHeight()-300,150,paint); //bottom left
        canvas.drawCircle(this.getWidth()-400,this.getHeight()-800,150,paint); //right
        canvas.drawCircle(400,this.getHeight()-800,150,paint); //left
        //top 4
        canvas.drawCircle(this.getWidth()-400, 300,150,paint); //top right
        canvas.drawCircle(400, 300,150,paint); //top left
        canvas.drawCircle(this.getWidth()-400, 800,150,paint); //right
        canvas.drawCircle(400, 800,150,paint); //left

//        View.OnTouchListener listener = new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                int touchX = (int) event.getX();
//                int touchY = (int) event.getY();
//
//                if (touchX - .getWidth())
//
//                switch(event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        System.out.println("Touching down!");
//                        for(Rect rect : rectangles){
//                            if(rect.contains(touchX,touchY)){
//                                System.out.println("Touched Rectangle, start activity.");
//                                Intent i = new Intent(<your activity info>);
//                                startActivity(i);
//                            }
//                        }
//                        break;
////                    case MotionEvent.ACTION_UP:
////                        System.out.println("Touching up!");
////                        break;
////                    case MotionEvent.ACTION_MOVE:
////                        System.out.println("Sliding your finger around on the screen.");
////                        break;
//                }
//                return true;
//            }
//        }

        View.OnClickListener tableClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("test", "A TABLE WAS CLICKED!");
            }
        };







//        OvalShape table = new OvalShape();
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.WHITE);
//        canvas.drawPaint(paint);
//        paint.setColor(Color.parseColor("#da4747"));
//        table.draw(canvas,paint);

    }
}
