package util;

/**
 * 请求方法枚举类
 */
public enum RequestMethod
{
    GET("GET"),POST("POST"),DELETE("DELETE"),PUT("PUT");

    private final String value;
    RequestMethod(String value)
    {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
