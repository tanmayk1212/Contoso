package com.dac.JPA.REST.repository;

import org.springframework.data.repository.CrudRepository;

import com.dac.JPA.REST.entites.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
