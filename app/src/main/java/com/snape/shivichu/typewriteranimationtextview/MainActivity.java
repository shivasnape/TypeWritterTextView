package com.snape.shivichu.typewriteranimationtextview;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Handler animationCompleteCallBack = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Log.i("Log", "Animation Completed");
                return false;
            }
        });

        Typewritter typewriter = new Typewritter(this);
        typewriter.setCharacterDelay(100);
        typewriter.setTextSize(30);
        typewriter.setTypeface(null, Typeface.BOLD);
        typewriter.setPadding(20, 20, 20, 20);
        typewriter.setAnimationCompleteListener(animationCompleteCallBack);
        typewriter.animateText("ShivaSnape\nHardcore John Cena Fan.....");
        typewriter.setBackgroundResource(R.color.colorAccent);
        typewriter.setGravity(Gravity.CENTER);
        setContentView(typewriter);
    }
}
