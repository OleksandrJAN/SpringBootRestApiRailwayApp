package com.railwayApp.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 63)
    private String username;

    @Column(name = "password", nullable = false, length = 63)
    private String password;

    @Column(name = "email", nullable = false, unique = true, length = 127)
    private String email;

    @Column(name = "first_name", nullable = false, length = 63)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 63)
    private String lastName;

    @Column(name = "patronymic", length = 63)
    private String patronymic;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "phone_number", length = 63)
    private String phoneNumber;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<UserRole> roles;
}
