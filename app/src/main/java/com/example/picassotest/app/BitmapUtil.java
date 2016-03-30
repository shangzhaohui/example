package com.example.picassotest.app;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by shangzhaohui on 16/3/27.
 */
public class BitmapUtil {
    public static final String dir = Environment.getExternalStorageDirectory().getAbsolutePath();
public static void  saveBitmap(Bitmap bm) {
        if (bm == null) {
            return;
        }
        File fileDir = new File(dir+"/pacassotest") ;
    if (!fileDir.exists()) {
        fileDir.mkdirs();
    }
        File f = new File(dir+"/pacassotest", "result.png");
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

}

}
