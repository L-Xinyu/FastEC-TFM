package es.upm.miw.fastec.fsatec_tfm;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import es.upm.miw.fastec.latte_core.delegates.LatteDelegate;

public class FastECDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_fastec;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        //Operations on controls
        super.onBindView(savedInstanceState, rootView);
    }
}
