package com.mitrais.registerbackend.controllers;

import com.mitrais.registerbackend.dtos.ResponseDTO;
import com.mitrais.registerbackend.exceptions.CommonException;
import com.mitrais.registerbackend.utils.LogUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@CrossOrigin(origins = "*")
public class BaseController
{

    protected ResponseEntity response(Object response) {
        ResponseDTO responseDTO = new ResponseDTO().setData(response);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    protected ResponseDTO error(Exception ex) {
        LogUtils.getInstance().error(ex);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(ex.getMessage());
        if (ex instanceof CommonException) {
            CommonException customException = (CommonException) ex;
            responseDTO.setCode(customException.getCode());
            responseDTO.setData(customException.getData());
        } else {
            responseDTO.setCode(500);
            responseDTO.setMessage("Internal Server Error " + ex.getMessage());
        }
        return responseDTO;
    }
}
