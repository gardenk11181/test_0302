package com.gardenlab.test_0302;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    int count=0;

    public MyButton(Context context) {
        super(context);
        init(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        setBackgroundColor(Color.CYAN);
        setTextColor(Color.BLACK);

        float textSize = getResources().getDimension(R.dimen.text_default);
        setTextSize(textSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch(action) {
            case MotionEvent.ACTION_DOWN:
                setBackgroundColor(Color.BLUE);
                setTextColor(Color.RED);
                setTextSize(getResources().getDimension(R.dimen.text_big));
                break;
            case MotionEvent.ACTION_UP:
                if(count%2==0) setBackgroundColor(Color.CYAN);
                if(count%2==1) setBackgroundColor(Color.BLACK);
                count++;
                setTextColor(Color.BLACK);
                setTextSize(getResources().getDimension(R.dimen.text_default));
                break;
        }

        invalidate();

        return true;
    }
}
