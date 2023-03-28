package com.bilgeadam.mapper;


import com.bilgeadam.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.UserLoginResponseDto;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    UserLoginResponseDto fromLoginResponseDto(final User dto);
    User fromUserRegisterRequestDto(final UserRegisterRequestDto dto);

}
