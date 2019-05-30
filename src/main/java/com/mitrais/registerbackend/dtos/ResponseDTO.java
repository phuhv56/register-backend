package com.mitrais.registerbackend.dtos;

public class ResponseDTO
{
    private Integer code;
    private String message;
    private Object data;

    public ResponseDTO() {
        this.code = 0;
        this.message = "success";
        this.data = null;
    }

    public Integer getCode()
    {
        return code;
    }

    public ResponseDTO setCode(Integer code)
    {
        this.code = code;
        return this;
    }

    public String getMessage()
    {
        return message;
    }

    public ResponseDTO setMessage(String message)
    {
        this.message = message;
        return this;
    }

    public Object getData()
    {
        return data;
    }

    public ResponseDTO setData(Object data)
    {
        this.data = data;
        return this;
    }
}
