package com.example.authservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    private Long id;
    private String name;
    private Status status;
    public String email;
    private String password;
    private String description;
    private String logo;


}
enum Status{
    STARTUP,
    ENTREPRISE

}
enum Role{
    STUDENT,
    ENTREPRISE

}
