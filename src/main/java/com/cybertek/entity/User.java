package com.cybertek.entity;

import com.cybertek.utils.Gender;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean enabled;
    private String phoneNumber;
    private Gender gender;
    private Role role;

    public User(Long id, LocalDateTime insertSateTime, LocalDateTime lastUpdateDateTime, Long insertUserId, Long lastUpdateUserId, String firstName, String lastName, String userName, String password, boolean enabled, String phoneNumber, Gender gender, Role role) {
        super(id, insertSateTime, lastUpdateDateTime, insertUserId, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.role = role;
    }
}
