package com.example.demo6.service;
import java.util.List;

import com.example.demo6.domain.UserEntity;

public interface UserEntityService {
    UserEntity getUserByName(String username);
    UserEntity saveUser(UserEntity userEntity);
    int updateUser(UserEntity userEntity);
    void deleteUser(UserEntity userEntity);
    List<UserEntity> getUsers();

}
