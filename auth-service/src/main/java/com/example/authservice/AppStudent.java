package com.example.authservice;

import lombok.Data;

import java.io.File;
import java.util.Date;
@Data
public class AppStudent {
    private Long id;

    private String email;

    private String firstName;

    private String lastName;


    private String phone;

    private String image;

    private Date DoB;

    private File CV;

    private String password;

    private String gender;

    private String address;

    private String intro;

    private  String university;

    private String profile;
}
