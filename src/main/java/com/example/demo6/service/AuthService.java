package com.example.demo6.service;
import com.example.demo6.domain.UserEntity;
public interface AuthService {
    String login(String username, String password);
    UserEntity addUser(UserEntity userEntity);

}
