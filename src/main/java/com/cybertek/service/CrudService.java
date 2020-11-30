package com.cybertek.service;

import com.cybertek.dto.RoleDTO;

import java.util.List;

public interface CrudService<T, ID> {

    //save user
    T save(T object);
    //find user by user name
    T findById(ID id);
    //return all users
    List<T> findAll();
    //delete
    void delete(T obj);
    void deleteById(ID id);
    //update
    void update (T object);
}
