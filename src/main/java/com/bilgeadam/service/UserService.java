package com.bilgeadam.service;

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.UserLoginResponseDto;
import com.bilgeadam.entity.User;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.utility.ICrudService;
import com.bilgeadam.utility.enums.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements ICrudService<User, Integer> {
    private final IUserRepository userRepository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }


    /**
     * */
    @Override
    public List<User> findAll() {
        List<User> userlist= userRepository.findAll();
        if(userlist.isEmpty()){
            throw new NullPointerException("Liste bos");
        }
        return userlist;
    }

    @Override
    public Optional<User> findById(Integer id) {
        Optional<User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser;
        }else {
            throw new NullPointerException("boyle bir kullanici yok");
        }

    }

    //builder register
    public User register(String name, String surname, String email, String password, String repassword){
        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .repassword(repassword)
                .build();
        if (!password.equals(repassword) || password.isBlank() || repassword.isBlank()){
            throw new RuntimeException("Şifreler aynı değildir.");
        }else {
            return userRepository.save(user);
        }
    }
    /*public String login(String email, String password){
        Optional<User> optionalUser= userRepository.findByEmailAndPassword(email, password);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("boyle bir kullanici bulunamadi");
        }
        return "giris basarili ";
    }*/
    //Sadece admin rolüne sahip kişiler bu işlemi gerçekleştirebilir.
    @Override
    public User delete(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            optionalUser.get().setStatus(EStatus.INACTIVE);
            userRepository.save(optionalUser.get());
            return optionalUser.get();
        }else {
            throw new NullPointerException("Böyle bir kullanıcı yok.");
        }
    }
    // Dto register
    public UserRegisterRequestDto registerDto(UserRegisterRequestDto dto){
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .repassword(dto.getRepassword())
                .build();
        if (!dto.getPassword().equals(dto.getRepassword())
                || dto.getPassword().isBlank() || dto.getRepassword().isBlank()){
            throw new RuntimeException("Şifreler aynı değildir.");
        }else {
            userRepository.save(user);
        }
        return dto;
    }
    public UserLoginResponseDto loginDto(String email, String password){
        Optional<User> optionalUser= userRepository.findByEmailAndPassword(email, password);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("boyle bir kullanici bulunamadi");
        }

        return IUserMapper.INSTANCE.fromLoginResponseDto(optionalUser.get());
    }
    public List<User> getUsersOrderedByName(String name) {
        return userRepository.findByNameOrderByNameAsc(name);
    }
    public boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }
    public List<User> searchByName(String keyword) {
        return userRepository.findByNameContainingIgnoreCase(keyword);
    }
    public List<User> findAllByNameOrderByNameAsc(String name) {
        return userRepository.findAllByNameOrderByNameAsc(name);
    }
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }











}