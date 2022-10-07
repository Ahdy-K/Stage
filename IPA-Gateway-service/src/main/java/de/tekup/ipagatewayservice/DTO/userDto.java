package de.tekup.ipagatewayservice.DTO;

import lombok.Data;

import java.io.File;
import java.util.Date;
@Data
public class userDto {
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
}
