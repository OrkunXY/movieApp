package com.bilgeadam.controller;

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.UserLoginResponseDto;
import com.bilgeadam.entity.User;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(String name,String surname,String email,String password,String repassword){
        return ResponseEntity.ok(userService.register(name, surname, email, password, repassword));
    }

    @PostMapping("/register-dto")
    public ResponseEntity<UserRegisterRequestDto> registerDto(@RequestBody UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerDto(dto));
    }

    @PostMapping("/register-mapper")
    public ResponseEntity<UserRegisterRequestDto> registerMapper(@RequestBody @Valid UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerMapper(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(String email, String password){
        return ResponseEntity.ok(userService.login(email, password));
    }
    @PostMapping("/login-dto")
    public ResponseEntity<String> loginDto(@RequestBody UserLoginResponseDto dto){
        return ResponseEntity.ok(userService.loginDto(dto));
    }
    @PostMapping("/login-mapper")
    public ResponseEntity<UserLoginResponseDto> loginMapper(@RequestBody UserLoginResponseDto dto){
        return ResponseEntity.ok(userService.loginMapper(dto));
    }

    @PostMapping("/custom-login")
    public ResponseEntity customLogin(@RequestBody UserLoginResponseDto dto){
        return userService.customLogin(dto);
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

    @GetMapping("/find-by-order-name-asc")
    public ResponseEntity<List<User>> findByOrderByName(){
        return ResponseEntity.ok(userService.findByOrderByName());
    }

    @GetMapping("/find-by-name-contains")
    public ResponseEntity<List<User>> findAllByNameContainsIgnoreCase(String value){
        return ResponseEntity.ok(userService.findAllByNameContainsIgnoreCase(value));
    }

    @GetMapping("/exist-name")
    public ResponseEntity<Boolean> existsByNameIgnoreCase(String value){
        return ResponseEntity.ok(userService.existsByNameIgnoreCase(value));
    }

    @GetMapping("/find-by-email")
    public ResponseEntity<List<User>> findByEmailIgnoreCase(String email){
        return ResponseEntity.ok(userService.findByEmailIgnoreCase(email));
    }
}
