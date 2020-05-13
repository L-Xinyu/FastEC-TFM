package es.upm.miw.fastec.latte_core.net;

import java.util.Map;
import java.util.WeakHashMap;

import es.upm.miw.fastec.latte_core.net.callback.IError;
import es.upm.miw.fastec.latte_core.net.callback.IFailure;
import es.upm.miw.fastec.latte_core.net.callback.IRequest;
import es.upm.miw.fastec.latte_core.net.callback.ISuccess;
import okhttp3.RequestBody;

public class RestClient {

    private final String URL;
    private static final WeakHashMap<String,Object> PARAMS = RestCreator.getParams();
    private final IRequest IREQUEST;
    private final ISuccess ISUCCESS;
    private final IFailure IFAILURE;
    private final IError IERROR;
    private final RequestBody BODY;

    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body) {
        this.URL = url;
        PARAMS.putAll(params);
        this.IREQUEST = request;
        this.ISUCCESS = success;
        this.IFAILURE = failure;
        this.IERROR = error;
        this.BODY = body;
    }

    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }
}
