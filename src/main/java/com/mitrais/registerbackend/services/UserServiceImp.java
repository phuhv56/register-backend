package com.mitrais.registerbackend.services;

import com.mitrais.registerbackend.exceptions.CommonException;
import com.mitrais.registerbackend.models.User;
import com.mitrais.registerbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) throws CommonException
    {
        User checkExistPhoneNumber = userRepository.findByPhoneNumber(user.getPhoneNumber());

        if (checkExistPhoneNumber!= null) {
            throw new CommonException().setData("Phone number " + user.getPhoneNumber() + " already exists!");
        }

        User checkExistEmail = userRepository.findByEmail(user.getEmail());

        if (checkExistEmail!= null) {
            throw new CommonException().setData("Email " + user.getEmail() + " already exists!");
        }
        User userResult = userRepository.save(user);
        return userResult;
    }
}
