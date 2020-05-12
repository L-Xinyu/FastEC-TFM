package es.upm.miw.fastec.fsatec_tfm;

import es.upm.miw.fastec.latte_core.actitives.ProxyActivity;
import es.upm.miw.fastec.latte_core.delegates.LatteDelegate;

public class MainActivity extends ProxyActivity {
    @Override
    public LatteDelegate setRootDelegate() {
        return new FastECDelegate();
    }
}
