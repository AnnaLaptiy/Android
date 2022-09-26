package com.example.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class myPaint extends View {
    private Paint mPaint = new Paint();
//Лучик Солнца
    private Rect mRect= new Rect();
    int x=1,y=258;


    public myPaint(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        // Рисуем жёлтый круг
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(400*3,98*2,45*2,mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(0, 650*3, 950*2, 680*4, mPaint);

// Рисуем текст
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(32*3);
        canvas.drawText("Лужайка только для котов", 30*3, 648*3, mPaint);

        //Лучик Солнца
        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(27*3);
        String str ="Лучик солнца!";
        canvas.save();
        canvas.rotate(-45, x + mRect.exactCenterX()*3, y + mRect.exactCenterY()*3);
// Рисуем текст
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str, x, y*4, mPaint);

// восстанавливаем холст
        canvas.restore();

        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        Bitmap bitmapResized = Bitmap.createScaledBitmap(bMap, 550, 550, false);
        canvas.drawBitmap(bitmapResized, 810, 1330, mPaint);

    }
}
