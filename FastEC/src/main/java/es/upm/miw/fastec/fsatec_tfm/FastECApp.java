package es.upm.miw.fastec.fsatec_tfm;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;

import es.upm.miw.fastec.latte.ec.icon.FontEcModule;
import es.upm.miw.fastec.latte_core.app.Latte;

public class FastECApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http//127.0.0.1/")
                .configure();
    }
}
