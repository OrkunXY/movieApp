package com.bilgeadam.controller;

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.UserLoginResponseDto;
import com.bilgeadam.entity.User;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final IUserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<User> register(String name,
                                         String surname,
                                         String email,
                                         String password,
                                         String repassword){
        return ResponseEntity.ok(userService.register(name, surname, email, password, repassword));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(String email, String password){

        return ResponseEntity.ok(userService.loginDto(email,password));

    }

    @GetMapping("/find-all")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<User>> findById(Integer id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<User> delete(Integer id){
        return ResponseEntity.ok(userService.delete(id));
    }

    @PostMapping("/register-dto")
    public ResponseEntity<UserRegisterRequestDto> registerDto(@RequestBody UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerDto(dto));
    }
    @GetMapping("/find-by-name")
    public ResponseEntity<List<User>> findByName(@RequestParam String name){
        List<User> users = userService.getUsersOrderedByName(name);
        return ResponseEntity.ok(users);
    }

}
