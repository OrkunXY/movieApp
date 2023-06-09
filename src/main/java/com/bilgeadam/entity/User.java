package com.bilgeadam.entity;

import com.bilgeadam.utility.enums.EStatus;
import com.bilgeadam.utility.enums.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 50)
    @Email
    private String email;
    @Column(length = 15)
    private String phone;

    @Column(length = 32)
    private String repassword;
    @Column(length = 32)
    private String password;


    @ElementCollection//m2m
    private List<Integer>genreId;

    @ElementCollection//m2m
    private List<Integer>movieId;

    @ElementCollection//12m
    private List<Integer> commentId;

    @Enumerated(EnumType.STRING)//Enum değer database'e gönderilirken ve çekilirken STRING formatında olur.
    @Builder.Default // bir property default degerini alir.
    private EStatus status= EStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EUserType userType=EUserType.USER;


}
