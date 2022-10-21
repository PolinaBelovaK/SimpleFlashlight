package com.example.simpleflashlight;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class FlashClass {
    private boolean status = false;
    private Context context;

    public FlashClass(Context context) {
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void flashOn () {
        CameraManager cm = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cm != null;
            String CameraID = cm.getCameraIdList()[0];
            cm.setTorchMode(CameraID, true);
            status = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void flashOff () {
        CameraManager cm = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cm != null;
            String CameraID = cm.getCameraIdList()[0];
            cm.setTorchMode(CameraID, false);
            status = false;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public boolean isStatus() {
        return status;
    }
}
