package aoap.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.Paint;

/**
 * Created by artur on 11/15/17.
 */

public class CustomDrawings extends View {
    Paint paint;

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
        //TODO: CONTINUE YOUTUBE VID
        //TODO: figure out floats?
        canvas.drawCircle(this.getWidth()/4,this.getHeight()/4,100,paint);
        canvas.drawCircle(this.getWidth()/1,this.getHeight()/2,100,paint);
        canvas.drawCircle(this.getWidth()/4,this.getHeight()/1,100,paint);
        canvas.drawCircle(this.getWidth()/4,this.getHeight()/1,100,paint);
        canvas.drawCircle(this.getWidth()/4,this.getHeight()/1,100,paint);
        //canvas.drawCircle(this.getWidth()/2,this.getHeight()/2,100,paint);


//        OvalShape table = new OvalShape();
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.WHITE);
//        canvas.drawPaint(paint);
//        paint.setColor(Color.parseColor("#da4747"));
//        table.draw(canvas,paint);

    }
}
