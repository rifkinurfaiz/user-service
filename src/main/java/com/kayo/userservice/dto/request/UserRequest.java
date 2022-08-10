package com.kayo.userservice.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequest implements Serializable {
    private String username;

    private String firstName;

    private String lastName;

    private String phone;
}
