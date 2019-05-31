package com.mitrais.registerbackend.exceptions;

public class CommonException extends Exception
{
    public CommonException() {

    }

    public CommonException(Exception ex)
    {
        super(ex);
    }

    public CommonException(int code, Exception ex)
    {
        super(ex);
        this.code = code;
    }

    public CommonException(int code, String message)
    {
        super(new Exception(message));
        this.code = code;
    }

    public CommonException(String message)
    {
        super(new Exception(message));
        this.code = 500;
    }

    private Integer code;
    private Object data;

    public Integer getCode()
    {
        return code;
    }

    public CommonException setCode(Integer code)
    {
        this.code = code;
        return this;
    }


    public Object getData()
    {
        return data;
    }

    public CommonException setData(Object data)
    {
        this.data = data;
        return this;
    }
}
