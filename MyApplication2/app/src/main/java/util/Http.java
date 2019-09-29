package util;
import okhttp3.*;

import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * okhttp2客户端
 */
public class Http
{
    private static Http http;
    private OkHttpClient okHttpClient;
    private String token = "";
    private Http()
    {
        this.okHttpClient = new OkHttpClient();
    }

    public static Http getInstance() {
        if (http == null) {
            synchronized (Http.class) {
                if (http == null) {
                    http = new Http();
                }
            }
        }
        return http;
    }


    /**
     * 同步get
     * @param url 访问地址
     * @param params 访问参数
     * @return 请求结果
     * @throws IOException
     */
    public Response get(String url, Map<String,String> params) throws IOException
    {

        Request request = this.getBase(url, params);
        return okHttpClient.newCall(request).execute();

    }

    /**
     * 异步get
     * @param url 访问地址
     * @param params 访问参数
     * @param resultCallback 回调
     */
//    public void getAsyn(String url,Map<String,String> params,
//                        ResultCallback resultCallback)
//    {
//        Request request = this.getBase(url, params);
//        responseResult(resultCallback, request);
//    }

    /**
     * 异步unGet（携带文件）
     * @param url 访问地址
     * @param params 参数
     * @param file 文件
     * @param fileKey 文件键值
     * @param resultCallback 结果回调
     */
//    public void unGetFileAsyn(String url,Map<String,String> params,
//                              File file,String fileKey,ResultCallback resultCallback,RequestMethod method)
//    {
//        if(params==null)
//        {
//            params = new HashMap<String,String>();
//        }
//        Request request = this.buildMultipartFormRequest(url, file, fileKey, params,method);
//        responseResult(resultCallback, request);
//    }

    /**
     * 同步unGet（携带文件）
     * @param url 访问地址
     * @param params 参数
     * @param file 文件
     * @param fileKey 文件键值
     * @return Response
     * @exception IOException
     */
//    public Response unGetFile(String url,Map<String,String> params,
//                              File file,String fileKey,RequestMethod method) throws IOException
//    {
//        if(params==null)
//        {
//            params = new HashMap<String,String>();
//        }
//        Request request = this.buildMultipartFormRequest(url, file, fileKey, params,method);
//        return okHttpClient.newCall(request).execute();
//    }


    /**
     * 异步unGet（不携带文件）
     * @param url 访问地址
     * @param params 参数
     * @param resultCallback 结果回调
     */
//    public void unGetAsyn(String url, Map<String, String> params,
//                          ResultCallback resultCallback,RequestMethod method)
//    {
//        Request request = this.unGetBase(url, params, method);
//        responseResult(resultCallback, request);
//    }

    /**
     * 同步unGet（不携带文件）
     * @param url 访问地址
     * @param params 参数
     * @return Response
     * @exception IOException
     */
//    public Response unGet(String url, Map<String, String> params,RequestMethod method) throws IOException
//    {
//        Request request = this.unGetBase(url, params, method);
//        return okHttpClient.newCall(request).execute();
//    }


    /**
     * unGet文件参数创建
     * @param url 访问地址
     * @param params 参数
     * @param file 文件
     * @param fileKey 文件键值
     * @return Request
     */
//    private Request buildMultipartFormRequest(String url, File file,
//                                              String fileKey, Map<String,String> params,RequestMethod method)
//    {
//
//        MultipartBuilder builder = new MultipartBuilder()
//                .type(MultipartBuilder.FORM);
//
//        for(Map.Entry<String, String> entry:params.entrySet())
//        {
//            builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
//                    RequestBody.create(null, entry.getValue()));
//
//        }
//
//        if (file != null)
//        {
//            String fileName = file.getName();
//            RequestBody fileBody = RequestBody.create(MediaType.parse(guessMimeType(fileName)), file);
//            builder.addPart(Headers.of("Content-Disposition",
//                    "form-data; name=\"" + fileKey + "\"; filename=\"" + fileName + "\""),
//                    fileBody);
//
//        }
//        RequestBody requestBody = builder.build();
//
//        switch(method.getValue())
//        {
//            case "POST":
//                return new Request.Builder()
//                        .url(url)
//                        .post(requestBody)
//                        .header("token", token)
//                        .build();
//            case "PUT":
//                return new Request.Builder()
//                        .url(url)
//                        .put(requestBody)
//                        .header("token", token)
//                        .build();
//            case "DELETE":
//                return new Request.Builder()
//                        .url(url)
//                        .delete(requestBody)
//                        .header("token", token)
//                        .build();
//            default:
//                return new Request.Builder()
//                        .url(url)
//                        .post(requestBody)
//                        .header("token", token)
//                        .build();
//
//        }
//
//    }


    /**
     * get 同步和异步公共方法
     * @param url 访问地址
     * @param params 访问参数
     * @return Request
     */
    private Request getBase(String url,Map<String,String> params)
    {
        if(params==null)
        {
            params = new HashMap<String,String>();
        }
        String requestUrl = url + "?";
        for(Map.Entry<String, String> entry : params.entrySet())
        {
            requestUrl = requestUrl + entry.getKey() + "=" + entry.getValue() + "&";
        }
        return new Request.Builder()
                .url(requestUrl)
                .header("token", token)
                .build();
    }

    /**
     * unGet 同步异步公共方法
     * @param url 访问地址
     * @param params 参数
     */
//    private Request unGetBase(String url, Map<String, String> params, RequestMethod method)
//    {
//        if(params==null)
//        {
//            params = new HashMap<String,String>();
//        }
//        FormEncodingBuilder builder = new FormEncodingBuilder();
//        for(Map.Entry<String, String> entry:params.entrySet())
//        {
//            builder.add(entry.getKey(), entry.getValue());
//        }
//        RequestBody requestBody = builder.build();
//
//
//        switch(method.getValue())
//        {
//            case "POST":
//                return new Request.Builder()
//                        .url(url)
//                        .header("token", token)
//                        .post(requestBody)
//                        .build();
//            case "PUT":
//                return new Request.Builder()
//                        .url(url)
//                        .header("token", token)
//                        .put(requestBody)
//                        .build();
//            case "DELETE":
//                return new Request.Builder()
//                        .url(url)
//                        .header("token", token)
//                        .delete(requestBody)
//                        .build();
//            default:
//                return new Request.Builder()
//                        .url(url)
//                        .header("token", token)
//                        .post(requestBody)
//                        .build();
//
//        }
//    }


    /**
     * 异步监听回调
     */
//    private void responseResult(ResultCallback resultCallback,Request request)
//    {
//        okHttpClient.newCall(request).enqueue(new Callback(){
//
//            @Override
//            public void onFailure(Request request, IOException e) {
//
//                if(resultCallback!=null)
//                {
//                    resultCallback.onfail(request, e);
//                }
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//
//                if(resultCallback!=null)
//                {
//                    resultCallback.onsucess(response);
//                }
//
//            }
//
//        });
//    }

    /**
     * 获取文件的类型
     */
    private String guessMimeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = fileNameMap.getContentTypeFor(path);
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
