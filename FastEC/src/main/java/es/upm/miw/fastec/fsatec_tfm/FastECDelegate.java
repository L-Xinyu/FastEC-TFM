package es.upm.miw.fastec.fsatec_tfm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import es.upm.miw.fastec.latte_core.delegates.LatteDelegate;
import es.upm.miw.fastec.latte_core.net.RestClient;
import es.upm.miw.fastec.latte_core.net.callback.IError;
import es.upm.miw.fastec.latte_core.net.callback.IFailure;
import es.upm.miw.fastec.latte_core.net.callback.ISuccess;

public class FastECDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_fastec;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        //Operations on controls
        //super.onBindView(savedInstanceState, rootView);
        testRestClient();
    }

    private void testRestClient(){
        RestClient.builder()
                .url("http://127.0.0.1/index")
                .loader(getContext())
                //.params("","")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                        Log.d("Test Interceptor",response);
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .build()
                .get();
    }
}
