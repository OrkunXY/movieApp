package com.bilgeadam.controller;

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.request.UserUpdateRequestDto;
import com.bilgeadam.dto.response.UserLoginResponseDto;
import com.bilgeadam.entity.User;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.bilgeadam.constants.EndPointList.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(SAVE)
    public ResponseEntity<User> register(String name,String surname,String email,String password,String repassword){
        return ResponseEntity.ok(userService.register(name, surname, email, password, repassword));
    }

    @PostMapping(REGISTER)
    public ResponseEntity<UserRegisterRequestDto> registerDto(@RequestBody UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerDto(dto));
    }

    @PostMapping(REGISTERMAPPER)
    public ResponseEntity<UserRegisterRequestDto> registerMapper(@RequestBody @Valid UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerMapper(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> login(String email, String password){
        return ResponseEntity.ok(userService.login(email, password));
    }
    @PostMapping(LOGINDTO)
    public ResponseEntity<String> loginDto(@RequestBody UserLoginResponseDto dto){
        return ResponseEntity.ok(userService.loginDto(dto));
    }
    @PostMapping(LOGINMAPPER)
    public ResponseEntity<UserLoginResponseDto> loginMapper(@RequestBody UserLoginResponseDto dto){
        return ResponseEntity.ok(userService.loginMapper(dto));
    }

    @PostMapping(CLOGIN)
    public ResponseEntity customLogin(@RequestBody UserLoginResponseDto dto){
        return userService.customLogin(dto);
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<Optional<User>> findById(Integer id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(UPDATEDTO)
    public ResponseEntity<User> updateDto(UserUpdateRequestDto dto){
        return ResponseEntity.ok(userService.updateDto(dto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<User> updateMapper(UserUpdateRequestDto dto){
        return ResponseEntity.ok(userService.updateMapper(dto));
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<User> delete(Integer id){
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping(FINDBYNAME)
    public ResponseEntity<List<User>> findByOrderByName(){
        return ResponseEntity.ok(userService.findByOrderByName());
    }

    @GetMapping(FINDBYNAMECONTAINS)
    public ResponseEntity<List<User>> findAllByNameContainsIgnoreCase(String value){
        return ResponseEntity.ok(userService.findAllByNameContainsIgnoreCase(value));
    }

    @GetMapping(EXISTNAME)
    public ResponseEntity<Boolean> existsByNameIgnoreCase(String value){
        return ResponseEntity.ok(userService.existsByNameIgnoreCase(value));
    }

    @GetMapping(FINDBYMAIL)
    public ResponseEntity<List<User>> findByEmailIgnoreCase(String email){
        return ResponseEntity.ok(userService.findByEmailIgnoreCase(email));
    }

    @GetMapping(PASSLTHAN)
    public ResponseEntity<List<User>> passwordLongerThan(int num){
        return ResponseEntity.ok(userService.passwordLongerThan(num));
    }

    @GetMapping(PASSLTHAN2)
    public ResponseEntity<List<User>> passwordLongerThan2(int num){
        return ResponseEntity.ok(userService.passwordLongerThan2(num));
    }

    @GetMapping(FINDBYEMAILENDSWITH)
    public ResponseEntity<List<User>> findByEmailEndsWithIgnoreCase(String email){
        return ResponseEntity.ok(userService.findByEmailEndsWithIgnoreCase(email));
    }
    @GetMapping(ORDER_BY_USER)
    public ResponseEntity<List<User>> orderByUser(){return ResponseEntity.ok(userService.orderByUser());}
    @GetMapping(FIND_BY_NAME)
    public ResponseEntity<String> findByName(String name){return ResponseEntity.ok(userService.findByName(name));}
    @GetMapping(FIND_BY_NAME_CONTAINING)
    public ResponseEntity<List<User>> findByNameContainingIgnoreCase(String name){return ResponseEntity.ok(userService.findByNameContainingIgnoreCase(name));}
    @GetMapping(EXISTS_ALL_BY_NAME)
    public ResponseEntity<Boolean> existsAllByNameIgnoreCase(String name){return ResponseEntity.ok(userService.existsAllByNameIgnoreCase(name));}
    @GetMapping(FIND_ALL_BY_EMAIL)
    public ResponseEntity<User> findAllByEmailIgnoreCase(String email){return ResponseEntity.ok(userService.findAllByEmailIgnoreCase(email));}
    @GetMapping(FIND_PASSWORD_GREATERTHAN_JQSQL)
    public ResponseEntity<List<User>> findAllPasswordGreaterThanJpql(Integer value){return ResponseEntity.ok(userService.findAllPasswordGreaterThanJpql(value));}
    @GetMapping(FIND_PASSWORD_GREATERTHAN_NATIVE)
    public ResponseEntity<List<User>> findAllPasswordGreaterThanNative(Integer value){return ResponseEntity.ok(userService.findAllPasswordGreaterThanNative(value));}
    @GetMapping(FIND_EMAIL_ENDSWITH)
    public ResponseEntity<List<User>> findAllByEmailEndsWith(String value){return ResponseEntity.ok(userService.findAllByEmailEndsWith(value));}

}
