package com.myapp.pengeluaranku.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.UserException;
import com.myapp.pengeluaranku.mapper.UserMapper;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.util.ValidationUtil;
import com.myapp.pengeluaranku.validator.UserValidator;
import com.myapp.pengeluaranku.vo.UserReqVO;
import com.myapp.pengeluaranku.vo.UserResVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService{

@Autowired
UserRepository userRepository;

@Autowired
UserValidator userValidator;

@Autowired
UserMapper userMapper;

@Transactional
public String add(UserReqVO vo){
    String message = userValidator.validateAdd(vo);
    if(message!=null) throw new UserException(message, HttpStatus.BAD_REQUEST, StatusCode.ERROR);
    User model = new User();
    model.setCreatedBy("Daniel");
    model.setName(vo.getName());
    model.setAddress(vo.getAddress());
    model.setEmail(vo.getEmail());
    model.setPhone(vo.getPhone());
    userRepository.save(model);
        return "User tersimpan";


}

public String edit(UserReqVO vo, String uuid){
    // validate input
    userValidator.validateEdit(vo, uuid);
    User user = userRepository.findByUuid(uuid);
    user.setCreatedBy("Daniel");
    user.setName(vo.getName());
    user.setAddress(vo.getAddress());
    user.setEmail(vo.getEmail());
    user.setPhone(vo.getPhone());
    user.setModificationDate(new Date());
    user.setModifiedBy("Daniel");
    userRepository.saveAndFlush(user);


    return "User sukses terupdate";
}

public List<String> getAll(){
    List<User> listUser = userRepository.findAll();
    List<String> vos = new ArrayList<>();
    for(User user : listUser){
        vos.add(user.getName());
    }
    System.out.println(vos);
        return vos;
    
}

public String delete(String uuid) {
    if(ValidationUtil.isEmptyOrNull(uuid)){
        throw new UserException("Uuid can't be empty", HttpStatus.BAD_REQUEST, StatusCode.ERROR);
    }
    else{
        User user = userRepository.findByUuid(uuid);
        if(user == null){
            throw new UserException("Pengeluaran not found", HttpStatus.BAD_REQUEST, StatusCode.ERROR);
        }
        userRepository.delete(user);
    }
	return null;
}

public List<UserResVO> list(){
    List<User> result = userRepository.findAll();
    List<UserResVO> response = userMapper.toVO(result);
    return response;
}

}