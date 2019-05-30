package com.mitrais.registerbackend.exceptions;

public class CommonException extends Exception
{
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

    public void setCode(Integer code)
    {
        this.code = code;
    }


    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
