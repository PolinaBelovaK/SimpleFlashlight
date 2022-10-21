package com.example.simpleflashlight;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private FlashClass flashClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        imageButton = findViewById(R.id.power);
        flashClass = new FlashClass(this);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void OnClickFlash (View view) {
        if (flashClass.isStatus()) {
            flashClass.flashOff();
            imageButton.setBackgroundResource(R.drawable.power);
        }else{
            flashClass.flashOn();
            imageButton.setBackgroundResource(R.drawable.standby);
        }
    }
}