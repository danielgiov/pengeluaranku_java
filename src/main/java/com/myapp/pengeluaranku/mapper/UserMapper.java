package com.myapp.pengeluaranku.mapper;

//import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
//import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
//import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

import com.myapp.pengeluaranku.domain.User;
import com.myapp.pengeluaranku.vo.UserReqVO;
import com.myapp.pengeluaranku.vo.UserResVO;

import org.mapstruct.*;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",
injectionStrategy = InjectionStrategy.CONSTRUCTOR,
unmappedSourcePolicy = ReportingPolicy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE,
nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper extends BaseMapper<User, UserReqVO, UserResVO>{
UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
     

}