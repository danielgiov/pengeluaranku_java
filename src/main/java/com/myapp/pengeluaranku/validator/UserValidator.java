package com.myapp.pengeluaranku.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.enums.StatusCode;
import com.myapp.pengeluaranku.exception.UserException;
import com.myapp.pengeluaranku.repository.UserRepository;
import com.myapp.pengeluaranku.vo.UserReqVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserValidator extends BaseValidator{
@Autowired
UserRepository userRepository;
    public String validateAdd(UserReqVO vo){
        if(vo.getName()==null||vo.getName().isEmpty()) {
            return "Name can't be empty";    
        }

        // email validator
        if(vo.getEmail()==null||vo.getEmail().isEmpty()) {
            return "Email can't be empty";
            
        }
        // List<User> model = userRepository.findlistByEmail(vo.getEmail());
        // if(model.size() > 0){
        //     return "Email already exist";
        // }
        
        User model = userRepository.findByEmail(vo.getEmail());
        if(model!= null){
            return "Email already exist";
        }

        // User model = userRepository.findByName(vo.getName());
        // if(model!=null){
        //     return "Name already exist";
        // }


        // if(vo.getAddress()==null||vo.getAddress().isEmpty()) {
        //     return "Address can't be empty";    
        // }

        if(vo.getPhone()==null||vo.getPhone().isEmpty()) {
            return "Phone can't be empty";    
        }
        return null;
    }
    
    public String validateEditNotFound(UserReqVO vo, String uuid) {
        User user = userRepository.findByUuid(uuid);
        if(user==null) return "Uuid Not Found";


        


        return null;
    }

    public String validateEditBadRequest(UserReqVO vo, String uuid) {
        if(isEmptyOrNull(uuid)) return "Uuid can't be empty";
        if(isEmptyOrNull(vo.getName())) return "Name can't be empty";
        //if(isEmptyOrNull(vo.getAddress())) return "Address can't be empty";
        if(isEmptyOrNull(vo.getEmail())) return "Email can't be empty";
        if(isEmptyOrNull(vo.getPhone())) return "Phone can't be empty";

        User model = userRepository.findByEmail(vo.getEmail());
        if(model != null)
        {
            
            Boolean uuidSame = model.getUuid().equals(uuid);
            if(uuidSame == false)
            {
                return "Email Already Exist !";
            }
        }
        
        
        return null;
    }

	public void validateEdit(UserReqVO vo, String uuid) {
        String validateEditBadRequest = validateEditBadRequest(vo,uuid);
        if(validateEditBadRequest!=null) throw new UserException(validateEditBadRequest, HttpStatus.BAD_REQUEST, StatusCode.ERROR);

        String validateEditNotFound = validateEditNotFound(vo,uuid);
        if(validateEditNotFound!=null) throw new UserException(validateEditNotFound, HttpStatus.NOT_FOUND, StatusCode.DATA_NOT_FOUND);
		
	}
}