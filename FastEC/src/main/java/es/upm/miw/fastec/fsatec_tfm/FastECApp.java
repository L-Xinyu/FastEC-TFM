package es.upm.miw.fastec.fsatec_tfm;

import android.app.Application;

import es.upm.miw.fastec.latte_core.app.Latte;

public class FastECApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http//127.0.0.1/")
                .configure();
    }
}
