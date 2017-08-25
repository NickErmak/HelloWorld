package com.paranoid.helloworld;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class MainActivity extends AppCompatActivity {

    private ImageView iBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iBtn = (ImageView) findViewById(R.id.btnToast);
        iBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    iBtn.setImageDrawable(getDrawable(R.drawable.btn2));
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    iBtn.setImageDrawable(getDrawable(R.drawable.btn1));
                    toastCreate();
                }
                return true;
            }
        });
    }

    private void toastCreate() {
        StyleableToast styleableToast = new StyleableToast(this, getString(R.string.toastMessage), Toast.LENGTH_LONG);
        styleableToast.setBoldText();
        styleableToast.setBackgroundColor(ContextCompat.getColor(this, R.color.colorToast));
        styleableToast.setIcon(R.drawable.disk);
        styleableToast.spinIcon();
        styleableToast.show();
    }
}
