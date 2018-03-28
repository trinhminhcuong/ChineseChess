package com.example.cuong.chinesechess;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ChessBoard chessBoard;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageView);
        chessBoard=new ChessBoard(this,300,330,10,11);
        chessBoard.init();
        bitmap=chessBoard.drawBoard();

        imageView.setImageBitmap(bitmap);


    }
}
