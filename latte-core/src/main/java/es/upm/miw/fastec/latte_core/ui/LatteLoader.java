package es.upm.miw.fastec.latte_core.ui;

import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatDialog;

import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

import es.upm.miw.fastec.latte_core.R;
import es.upm.miw.fastec.latte_core.util.DimenUtil;

public class LatteLoader {
    //Set loading zoom ratio, adjust according to screen size
    private static final int LOADER_SIZE_SCALE = 8;
    //Offset
    private static final int LOADER_OFFSET_SCALE =10;
    //Create a ArrayList to store all loaders
    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();
    //Default loading style
    private static final String DEFAULT_LOADER = LoaderStyle.BallSpinFadeLoaderIndicator.name();

    public static void showLoading(Context context,Enum<LoaderStyle> type){
        showLoading(context,type.name());
    }

    public static void showLoading(Context context,String type){

        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type,context);
        dialog.setContentView(avLoadingIndicatorView);

        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();

        final Window dialogWindow = dialog.getWindow();

        if (dialogWindow != null){
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth/LOADER_SIZE_SCALE;
            lp.height = deviceHeight/LOADER_SIZE_SCALE;
            lp.height = lp.height + deviceHeight/LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context){
        showLoading(context,DEFAULT_LOADER);
    }

    public static void stopLoading(){
        for (AppCompatDialog dialog:LOADERS){
            if (dialog != null){
                if (dialog.isShowing()){
                    dialog.cancel();
                }
            }
        }
    }
}
