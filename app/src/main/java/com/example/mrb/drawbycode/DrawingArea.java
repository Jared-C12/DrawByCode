package com.example.mrb.drawbycode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrb on 16-04-26.
 */
public class DrawingArea extends View // You need to extend the View class
{

    Paint pntTextPaint;     // Painting object to handle the paint jobs for graphics
    Paint pntGraphicsPaint; // Painting object to handle the paint jobs for text

    boolean blnShowText;
    int intTextPosition;

    public DrawingArea(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DrawingArea,
                0, 0);

        try {
            blnShowText = a.getBoolean(R.styleable.DrawingArea_displayText, false);
            intTextPosition = a.getInteger(R.styleable.DrawingArea_labelPosition, 0);
        } finally {
            a.recycle();
        }

        init(); // Calling the init() method happens once, when we set up our Paint objects
    }

    private void init()
    {
        // This method is called once when the DrawingArea object is made.
        // It is best practice to handle the set-up of our Paint objects here rather than in onDraw()

        pntTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntGraphicsPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        pntGraphicsPaint.setColor(Color.BLACK);
        pntGraphicsPaint.setStrokeWidth(5);

    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        // This method exists to handle re-drawing of the DrawingArea object in the event of a
        //   resize of our App. For example, tilting the device may require us to redraw our content.
        // More instructions are meant to be added at the bottom if required.
        super.onSizeChanged(w, h, oldw, oldh);
    }

    protected void onDraw(Canvas canvas)
    {
        // This method is where we issue our actual drawing commands.
        // The Canvas parameter is what we draw ON; the Paint objects defined above are what we draw WITH.
        super.onDraw(canvas);
        // stick man
        /*
        canvas.drawCircle((float) 300.0, (float) 300.0, (float) 60.0, pntGraphicsPaint);
        canvas.drawLine((float) 300.0, (float) 300.0, (float) 300.0, (float) 700.0, pntGraphicsPaint);
        canvas.drawLine((float)300.0,(float)700.0,(float)150.0,(float)900.0,pntGraphicsPaint);
        canvas.drawLine((float)300.0,(float)700.0,(float)450.0,(float)900.0,pntGraphicsPaint);
        canvas.drawLine((float)300.0,(float)400.0,(float)450.0,(float)500.0,pntGraphicsPaint);
        canvas.drawLine((float)300.0,(float)400.0,(float)150.0,(float)500.0,pntGraphicsPaint);
        */

        // grid pattern
       /* float startX = (float) 5.0;
        float startY = (float)1.5;
        for(int numLinesX = 0; numLinesX< 15; numLinesX++) {
            canvas.drawLine((float)startX, (float) 0.0, (float)startX, (float) 1100.0, pntGraphicsPaint);
            startX+=50.0;
        }
        for(int numLinesY = 0; numLinesY < 22; numLinesY++) {
            canvas.drawLine((float) 5.0, (float) startY, (float) 800.0, (float) startY, pntGraphicsPaint);
            startY += 50.0;
        }
        */
        // Checkerboard pattern
        float startX = (float)0.0;
        float startY = (float)0.0;
        float endX = (float)150.0;
        float endY = (float)150.0;
        // first column
        for(int i = 0; i< 4; i++){
            canvas.drawRect(startX,startY,endX,endY,pntGraphicsPaint);
            startY+=300.0;
            endY+=300.0;
        }
        // second column
        startX = (float) 150.0;
        startY = (float)150.0;
        endX = (float) 300.0;
        endY = (float)300.0;
        for(int i = 0; i < 3; i++){
            canvas.drawRect(startX,startY,endX,endY,pntGraphicsPaint);
            startY+=300.0;
            endY+=300.0;
        }
        //third column
        startX = (float) 300.0;
        startY = (float)0.0;
        endX = (float) 450.0;
        endY = (float)150.0;
        for(int i = 0; i< 4; i++){
            canvas.drawRect(startX,startY,endX,endY,pntGraphicsPaint);
            startY+=300.0;
            endY+=300.0;
        }
        // fourth column
        startX = (float) 450.0;
        startY = (float)150.0;
        endX = (float) 600.0;
        endY = (float)300.0;
        for(int i = 0; i < 3; i++){
            canvas.drawRect(startX,startY,endX,endY,pntGraphicsPaint);
            startY+=300.0;
            endY+=300.0;
        }
        //fifth column
        startX = (float) 600.0;
        startY = (float)0.0;
        endX = (float) 750.0;
        endY = (float)150.0;
        for(int i = 0; i< 4; i++){
            canvas.drawRect(startX,startY,endX,endY,pntGraphicsPaint);
            startY+=300.0;
            endY+=300.0;
        }
    }


}
