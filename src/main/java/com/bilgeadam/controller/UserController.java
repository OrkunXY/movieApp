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

    @PutMapping("/update-dto")
    public ResponseEntity<User> updateDto(UserUpdateRequestDto dto){
        return ResponseEntity.ok(userService.updateDto(dto));
    }

    @PutMapping("/update-mapper")
    public ResponseEntity<User> updateMapper(UserUpdateRequestDto dto){
        return ResponseEntity.ok(userService.updateMapper(dto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id){
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

    @GetMapping("/pass-longer-than")
    public ResponseEntity<List<User>> passwordLongerThan(int num){
        return ResponseEntity.ok(userService.passwordLongerThan(num));
    }

    @GetMapping("/pass-longer-than2")
    public ResponseEntity<List<User>> passwordLongerThan2(int num){
        return ResponseEntity.ok(userService.passwordLongerThan2(num));
    }

    @GetMapping("/find-by-email-ends-with")
    public ResponseEntity<List<User>> findByEmailEndsWithIgnoreCase(String email){
        return ResponseEntity.ok(userService.findByEmailEndsWithIgnoreCase(email));
    }
}
