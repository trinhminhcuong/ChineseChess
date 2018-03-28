package com.example.cuong.chinesechess;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cuong on 3/28/2018.
 */

public class ChessBoard {


    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    private int[][] board;
    private int player;
    private Context context;
    private int bitmapWidth;
    private int bitmapHeight;
    private int colQty;
    private int rowQty;
    private List<Line> listLine;


    private Bitmap nguaden;
    private Bitmap xeden;
    private Bitmap tuongden;
    private Bitmap siden;
    private Bitmap tuongjden;
    private Bitmap phaoden;
    private Bitmap chotden;

    private Bitmap nguado;
    private Bitmap xedo;
    private Bitmap tuongdo;
    private Bitmap sido;
    private Bitmap tuongjdo;
    private Bitmap phaodo;
    private Bitmap chotdo;



    public ChessBoard(Context context, int bitmapWidth, int bitmapHeight, int colQty, int rowQty) {
        this.context = context;
        this.bitmapWidth = bitmapWidth;
        this.bitmapHeight = bitmapHeight;
        this.colQty = colQty;
        this.rowQty = rowQty;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getBitmapWidth() {
        return bitmapWidth;
    }

    public void setBitmapWidth(int bitmapWidth) {
        this.bitmapWidth = bitmapWidth;
    }

    public int getBitmapHeight() {
        return bitmapHeight;
    }

    public void setBitmapHeight(int bitmapHeight) {
        this.bitmapHeight = bitmapHeight;
    }

    public int getColQty() {
        return colQty;
    }

    public void setColQty(int colQty) {
        this.colQty = colQty;
    }

    public int getRowQty() {
        return rowQty;
    }

    public void setRowQty(int rowQty) {
        this.rowQty = rowQty;
    }

    public void init(){
        bitmap= Bitmap.createBitmap(bitmapWidth,bitmapHeight, Bitmap.Config.ARGB_8888);
        canvas=new Canvas(bitmap);
        paint=new Paint();
        int storkeWidth=1;
        paint.setStrokeWidth(storkeWidth);
        board=new int[rowQty][colQty];
        player=0;
        listLine=new ArrayList<>();

        int cellWidth=bitmapWidth/colQty;
        int cellHeight=bitmapHeight/rowQty;






       // bmCross= BitmapFactory.decodeResource(context.getResources(),R.drawable.circle);
       // bmTick=BitmapFactory.decodeResource(context.getResources(),R.drawable.xicon);



        for(int i=1;i<rowQty-1;i++){
            listLine.add(new Line(cellWidth,i*cellHeight,bitmapWidth-cellWidth,i*cellHeight));
        }

        listLine.add(new Line(cellWidth,10*cellHeight,9*cellWidth,10*cellHeight) );

        for (int j=1;j<colQty-1;j++){
            listLine.add(new Line(j*cellWidth,cellHeight,j*cellWidth,cellHeight*5));
            listLine.add(new Line(j*cellWidth,cellHeight*6,j*cellWidth,bitmapHeight-cellHeight));
        }

        listLine.add(new Line(cellWidth*9,cellHeight,cellWidth*9,10*cellHeight));
        listLine.add(new Line(cellWidth,cellHeight*5,cellWidth,cellHeight*6));
        listLine.add(new Line(cellWidth*4,cellHeight,cellWidth*6,cellHeight*3));
        listLine.add(new Line(cellWidth*6,cellHeight,cellWidth*4,cellHeight*3));
        listLine.add(new Line(cellWidth*4,cellHeight*10,cellWidth*6,cellHeight*8));
        listLine.add(new Line(cellWidth*6,cellHeight*10,cellWidth*4,cellHeight*8));


    }

    public Bitmap drawBoard(){
        Line line;
        int cellWidth=bitmapWidth/colQty;
        int cellHeight=bitmapHeight/rowQty;
        int halfWidth=cellWidth/2;
        int halfHeight=cellHeight/2;

        xeden=BitmapFactory.decodeResource(context.getResources(),R.drawable.xeden);
        canvas.drawBitmap(xeden,new Rect(0,0,xeden.getWidth(),xeden.getHeight()),new Rect(halfWidth,halfHeight,cellWidth+halfWidth,cellHeight+halfHeight),paint);
        canvas.drawBitmap(xeden,new Rect(0,0,xeden.getWidth(),xeden.getHeight()),new Rect(8*cellWidth-halfWidth,halfHeight,9*cellWidth-halfWidth,halfHeight+cellHeight),paint);

        nguaden=BitmapFactory.decodeResource(context.getResources(),R.drawable.nguaden);
        canvas.drawBitmap(nguaden,new Rect(0,0,nguaden.getWidth(),nguaden.getHeight()),new Rect(2*cellWidth-halfWidth,halfHeight,3*cellWidth-halfWidth,cellHeight+halfHeight),paint);
        canvas.drawBitmap(nguaden,new Rect(0,0,nguaden.getWidth(),nguaden.getHeight()),new Rect(9*cellWidth-halfWidth,halfHeight,10*cellWidth-halfWidth,cellHeight+halfHeight),paint);

        siden=BitmapFactory.decodeResource(context.getResources(),R.drawable.siden);
        canvas.drawBitmap(siden,new Rect(0,0,siden.getWidth(),siden.getHeight()),new Rect(4*cellWidth-halfWidth,halfHeight,4*cellWidth+halfWidth,halfHeight+cellHeight),paint);
        canvas.drawBitmap(siden,new Rect(0,0,siden.getWidth(),siden.getHeight()),new Rect(6*cellWidth-halfWidth,halfHeight,6*cellWidth+halfWidth,cellHeight+halfHeight),paint);

        tuongjden=BitmapFactory.decodeResource(context.getResources(),R.drawable.tuongjden);
        canvas.drawBitmap(tuongjden,new Rect(0,0,siden.getWidth(),siden.getHeight()),new Rect(3*cellWidth-halfWidth,halfHeight,3*cellWidth+halfWidth,halfHeight+cellHeight),paint);
        canvas.drawBitmap(tuongjden,new Rect(0,0,siden.getWidth(),siden.getHeight()),new Rect(7*cellWidth-halfWidth,halfHeight,7*cellWidth+halfWidth,halfHeight+cellHeight),paint);

        tuongden=BitmapFactory.decodeResource(context.getResources(),R.drawable.tuongden);
        canvas.drawBitmap(tuongden,new Rect(0,0,tuongden.getWidth(),tuongden.getHeight()),new Rect(5*cellWidth-halfWidth,halfHeight,5*cellWidth+halfWidth,halfHeight+cellHeight),paint);

        chotden=BitmapFactory.decodeResource(context.getResources(),R.drawable.chotden);
        for(int i=1;i<colQty;i=i+2) {
            canvas.drawBitmap(chotden,new Rect(0,0,chotden.getWidth(),chotden.getHeight()),new Rect(i*cellWidth-halfWidth,4*cellHeight-halfHeight,i*cellWidth+halfWidth,4*cellHeight+halfHeight),paint);
        }

        phaoden=BitmapFactory.decodeResource(context.getResources(),R.drawable.phaoden);
        for(int j=2;j<colQty;j=j+6){
            canvas.drawBitmap(phaoden,new Rect(0,0,phaoden.getWidth(),phaoden.getHeight()),new Rect(j*cellWidth-halfWidth,3*cellHeight-halfHeight,j*cellWidth+halfWidth,3*cellHeight+halfHeight),paint);
        }

        for(int i=0;i<listLine.size();i++){
            line=listLine.get(i);
            canvas.drawLine(line.getStartX(),line.getStartY(),line.getStopX(),line.getStopY(),paint);
        }

        xedo=BitmapFactory.decodeResource(context.getResources(),R.drawable.xedo);
        for(int i=1;i<colQty;i=i+8){
            canvas.drawBitmap(xedo,new Rect(0,0,xedo.getWidth(),xedo.getHeight()),new Rect(i*cellWidth-halfWidth,10*cellHeight-halfHeight,i*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        }

        nguado=BitmapFactory.decodeResource(context.getResources(),R.drawable.nguado);
        for(int i=2;i<colQty;i=i+6){
            canvas.drawBitmap(nguado,new Rect(0,0,nguado.getWidth(),nguado.getHeight()),new Rect(i*cellWidth-halfWidth,10*cellHeight-halfHeight,i*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        }

        tuongjdo=BitmapFactory.decodeResource(context.getResources(),R.drawable.tuongjdo);
        for(int i=3;i<colQty;i=i+4){
            canvas.drawBitmap(tuongjdo,new Rect(0,0,tuongjdo.getWidth(),tuongjdo.getHeight()),new Rect(i*cellWidth-halfWidth,10*cellHeight-halfHeight,i*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        }

        tuongdo=BitmapFactory.decodeResource(context.getResources(),R.drawable.tuongdo);
        canvas.drawBitmap(tuongdo,new Rect(0,0,tuongdo.getWidth(),tuongdo.getHeight()),new Rect(5*cellWidth-halfWidth,10*cellHeight-halfHeight,5*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);

        sido=BitmapFactory.decodeResource(context.getResources(),R.drawable.sido);
        canvas.drawBitmap(sido,new Rect(0,0,sido.getWidth(),sido.getHeight()),new Rect(4*cellWidth-halfWidth,10*cellHeight-halfHeight,4*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);
        canvas.drawBitmap(sido,new Rect(0,0,sido.getWidth(),sido.getHeight()),new Rect(6*cellWidth-halfWidth,10*cellHeight-halfHeight,6*cellWidth+halfWidth,10*cellHeight+halfHeight),paint);

        phaodo=BitmapFactory.decodeResource(context.getResources(),R.drawable.phaodo);
        for(int j=2;j<colQty;j=j+6){
            canvas.drawBitmap(phaodo,new Rect(0,0,phaodo.getWidth(),phaodo.getHeight()),new Rect(j*cellWidth-halfWidth,8*cellHeight-halfHeight,j*cellWidth+halfWidth,8*cellHeight+halfHeight),paint);
        }

        chotdo=BitmapFactory.decodeResource(context.getResources(),R.drawable.chotdo);
        for(int i=1;i<colQty;i=i+2) {
            canvas.drawBitmap(chotdo,new Rect(0,0,chotdo.getWidth(),chotdo.getHeight()),new Rect(i*cellWidth-halfWidth,7*cellHeight-halfHeight,i*cellWidth+halfWidth,7*cellHeight+halfHeight),paint);
        }

        return bitmap;
    }


}
