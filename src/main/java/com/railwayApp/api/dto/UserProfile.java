package com.railwayApp.api.dto;

import com.railwayApp.api.domain.Gender;
import com.railwayApp.api.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {
    private String username;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Gender gender;
    private String email;
    private String phoneNumber;

    public UserProfile(User user) {
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.patronymic = user.getPatronymic();
        this.gender = user.getGender();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }

}
