package es.upm.miw.fastec.latte_core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import es.upm.miw.fastec.latte_core.app.Latte;

public class DimenUtil {

    public static int getScreenWidth(){
        //Get the width of the screen
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        //Get the height of the screen
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
