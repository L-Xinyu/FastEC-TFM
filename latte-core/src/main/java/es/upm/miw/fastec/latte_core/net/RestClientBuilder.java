package es.upm.miw.fastec.latte_core.net;

import android.content.Context;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import es.upm.miw.fastec.latte_core.net.callback.IError;
import es.upm.miw.fastec.latte_core.net.callback.IFailure;
import es.upm.miw.fastec.latte_core.net.callback.IRequest;
import es.upm.miw.fastec.latte_core.net.callback.ISuccess;
import es.upm.miw.fastec.latte_core.ui.LoaderStyle;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RestClientBuilder {
    private String mUrl = null;
    private static final Map<String,Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private LoaderStyle mLoaderStyle = null;
    private Context mContext = null;
    private File mFile = null;

    RestClientBuilder(){
    }

    public final RestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String,Object> params){
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key,Object value){
        PARAMS.put(key,value);
        return this;
    }

    public final RestClientBuilder raw(String raw){
        this.mBody = RequestBody.create(MediaType.parse("applocation/json;charset=UTF-8"),raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest){
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess){
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure){
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError){
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder loader(LoaderStyle style,Context context){
        this.mLoaderStyle = style;
        this.mContext = context;
        return this;
    }
    //use default loader
    public final RestClientBuilder loader(Context context){
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallSpinFadeLoaderIndicator;
        return this;
    }

    public final RestClientBuilder file(File file){
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String file){
        this.mFile = new File(file);
        return this;
    }

    public final RestClient build(){
        return new RestClient(mUrl,PARAMS,mIRequest,mISuccess,mIFailure,mIError,mBody,mLoaderStyle,mContext,mFile);
    }
}
