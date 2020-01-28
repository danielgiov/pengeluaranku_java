package com.myapp.pengeluaranku.repository;

import java.util.List;

import com.myapp.pengeluaranku.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{

    User findByUuid(String uuid);

    User findByName(String name);

    User findByEmail(String email);

    User findByAddress(String address);

    User findByPhone(String Phone);


    List<User> findByIsDeleteIsNull();
}