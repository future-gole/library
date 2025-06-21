package com.example.demo6.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo6.domain.UserEntity;
import com.example.demo6.repo.UserEntityRepository;
@Service
public class UserEntityServiceImpl implements UserEntityService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserEntityRepository userEntityRepository;
    @Override
    public UserEntity getUserByName(String username) {
        return userEntityRepository.getUserByName(username);
    }

    @Override
    public UserEntity saveUser(UserEntity entity) {
        if (null == entity.getCreateTime()) {
            entity.setCreateTime(new Date());
        }
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        UserEntity user = userEntityRepository.getUserByName(entity.getUsername());
        if (null == user) {
            userEntityRepository.save(entity);
            user = entity;
        }
        return user;
    }
    public List<UserEntity>getUsers(){
        List<UserEntity> uList = userEntityRepository.findAll();
        return uList;
    }
    public int updateUser(UserEntity user) {
        return userEntityRepository.modifyById(user.getUsername(), user.getPhone(), user.getUsertype(), user.getId().intValue());

    }
    public void deleteUser(UserEntity user) {
        userEntityRepository.deleteById(user.getId().intValue());
    }
}

