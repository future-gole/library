package com.example.demo6.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.domain.UserEntity;
import com.example.demo6.service.UserEntityService;
import com.example.demo6.utils.R;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserEntityService userService;
    @PostMapping("/getusers")
    public R getUsers() {
        List<UserEntity> entitys = userService.getUsers();
        return R.success(entitys);
    }
    @PostMapping("/updateuser")
    public R updateUser(@RequestBody UserEntity userEntity) {
        System.out.println("userEntity = " + userEntity);
        int yn = userService.updateUser(userEntity);
        System.out.println("yn = " + yn);
        String str= "update success";
        return R.success(str);
    }
    @PostMapping("/deleteuser")
    public R deleteUser(@RequestBody UserEntity userEntity) {
        userService.deleteUser(userEntity);
        String str = "update success";
        return R.success(str);
    }
}
