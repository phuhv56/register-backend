package com.mitrais.registerbackend.controllers;

import com.mitrais.registerbackend.dtos.UserDTO;
import com.mitrais.registerbackend.mappers.UserMapper;
import com.mitrais.registerbackend.models.User;
import com.mitrais.registerbackend.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController
{
    @Autowired
    private UserService userService;

    @ApiOperation(value = "Create new user", notes = "{\"user\": {}}")
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody UserDTO object) {
        try {
            User user = UserMapper.INSTANCE.userDtoToUser(object);
            return success(userService.create(user));
        } catch (Exception ex) {
            return error(ex);
        }
    }

}
