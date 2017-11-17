package aoap.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


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

