package es.upm.miw.fastec.latte_core.actitives;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import es.upm.miw.fastec.latte_core.R;
import es.upm.miw.fastec.latte_core.delegates.LatteDelegate;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity {

    public abstract LatteDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState){

        final FrameLayout container = new FrameLayout(this);
        container.setId(R.id.delegate_container);

        setContentView(container);
        if (savedInstanceState == null){
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
