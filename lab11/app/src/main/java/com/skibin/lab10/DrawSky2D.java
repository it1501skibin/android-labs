package com.skibin.lab10;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class DrawSky2D extends View {

    private Paint mPaint = new Paint();
    private Bitmap skyBitmap, starBitmap, shipBitmap, moonBitmap;

    public DrawSky2D(Context context) {
        super(context);

        // Выводим значок из ресурсов
        Resources res = this.getResources();
        skyBitmap = BitmapFactory.decodeResource(res, R.drawable.sky);
        starBitmap = BitmapFactory.decodeResource(res, R.drawable.star);
        shipBitmap = BitmapFactory.decodeResource(res, R.drawable.space_ship);
        moonBitmap = BitmapFactory.decodeResource(res, R.drawable.moon);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        canvas.drawBitmap(skyBitmap, width - skyBitmap.getWidth(), height - skyBitmap.getHeight() - 10, mPaint);
        canvas.drawBitmap(starBitmap, width - starBitmap.getWidth() - 100, 30, mPaint);
        canvas.drawBitmap(starBitmap, width - starBitmap.getWidth() - 470, height - starBitmap.getHeight() - 410, mPaint);
        canvas.drawBitmap(shipBitmap, width - shipBitmap.getWidth() - 30, height - shipBitmap.getHeight() - 20, mPaint);
        canvas.drawBitmap(moonBitmap, width - moonBitmap.getWidth() - 180, height - moonBitmap.getHeight() - 550, mPaint);
    }
}
