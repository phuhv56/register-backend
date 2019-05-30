package com.mitrais.registerbackend.repositories;

import com.mitrais.registerbackend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
}
