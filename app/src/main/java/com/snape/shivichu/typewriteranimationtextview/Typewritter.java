package com.snape.shivichu.typewriteranimationtextview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by Shivichu on 22-05-2017.
 */

public class Typewritter extends android.support.v7.widget.AppCompatTextView {

    private static final String TAG = Typewritter.class.getSimpleName();
    private CharSequence mText;
    private int mIndex;
    private long mDelay = 500;
    Handler animationCompleteCallBack;

    public Typewritter(Context context) {
        super(context);
    }

    public void setAnimationCompleteListener(Handler animationCompleteCallBack) {
        this.animationCompleteCallBack = animationCompleteCallBack;
    }

    public Typewritter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if (mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            } else {
                if (null != animationCompleteCallBack)
                    animationCompleteCallBack.sendMessage(new Message());
                else
                    Log.i(TAG, "Animation Complete Listener not set...");
            }
        }
    };

    public void animateText(CharSequence text) {
        mText = text;
        mIndex = 0;
        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setCharacterDelay(long millis) {
        mDelay = millis;
    }
}