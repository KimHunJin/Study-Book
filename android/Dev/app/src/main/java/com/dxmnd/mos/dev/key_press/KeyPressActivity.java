package com.dxmnd.mos.dev.key_press;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.dxmnd.mos.dev.R;

public class KeyPressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_press);
    }

    private int count = 0;
    private boolean isVolumeDown = false;

    public boolean onKeyDown(int keycode, KeyEvent event)
    {
        switch(keycode)
        {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if(isVolumeDown == false) {
                    isVolumeDown = true;
                }
                break;

            case KeyEvent.KEYCODE_VOLUME_UP:
                break;
        }
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN : {
                if(isVolumeDown) {
                    count++;
                    if(count > 2) {
                        count = 0;
                        Toast.makeText(getApplicationContext(), count+"", Toast.LENGTH_SHORT).show();
                    }
                    isVolumeDown = false;
                }
                break;
            }
            default:{
                isVolumeDown = false;
            }
        }
        return true;
    }
}
