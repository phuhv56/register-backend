package com.mitrais.registerbackend.services;

import com.mitrais.registerbackend.exceptions.CommonException;
import com.mitrais.registerbackend.models.User;

public interface UserService
{
    User create(User user) throws CommonException;
}
