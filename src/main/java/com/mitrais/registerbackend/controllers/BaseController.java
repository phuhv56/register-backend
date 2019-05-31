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

    protected ResponseEntity success(Object response) {
        ResponseDTO responseDTO = new ResponseDTO().setData(response);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    protected ResponseEntity error(Exception ex) {
        LogUtils.getInstance().error(ex);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(ex.getMessage());
        if (ex instanceof CommonException) {
            CommonException customException = (CommonException) ex;
            responseDTO.setCode(customException.getCode());
            responseDTO.setMessage(customException.getMessage());
            responseDTO.setData(customException.getData());
        } else {
            responseDTO.setCode(500);
            responseDTO.setMessage("Internal Server Error " + ex.getMessage());
        }
        return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
