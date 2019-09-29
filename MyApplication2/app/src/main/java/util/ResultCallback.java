package util;

import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 异步结果回调
 */
public interface ResultCallback
{
    void onsucess(Response response);
    void onfail(Request request, IOException e);
}