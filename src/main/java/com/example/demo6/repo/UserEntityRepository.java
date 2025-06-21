package com.example.demo6.repo;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo6.domain.UserEntity;


import jakarta.transaction.Transactional;

@Transactional
public interface UserEntityRepository extends CrudRepository<UserEntity, Integer>{
    @Query(value = "select * from user_entity", nativeQuery = true)
    List<UserEntity> findAll();
    @Query(value = "select * from user_entity where username=?1", nativeQuery = true)
    UserEntity getUserByName(String username);

    @Modifying
    @Query(value = "UPDATE user_entity r SET r.username = ?1, r.phone = ?2, r.usertype = ?3 WHERE r.id = ?4", nativeQuery = true)
    int modifyById(
            String username,
            String phone,
            String usertype,
            int id
    );

}

