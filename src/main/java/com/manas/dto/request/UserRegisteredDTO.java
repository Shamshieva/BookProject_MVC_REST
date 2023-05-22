package com.manas.dto.request;

import com.manas.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisteredDTO {
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;
}
