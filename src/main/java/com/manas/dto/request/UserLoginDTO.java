package com.manas.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {

    private String username;

    private String password;

    private int otp;


}
