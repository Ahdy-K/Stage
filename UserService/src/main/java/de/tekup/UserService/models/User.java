package de.tekup.UserService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

// add entity annotation
@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email",unique = true,nullable = false)
    @Email(message="Please provide a valid email")
    @NotEmpty(message="Provide your Email")
    private String email;

    @Column(name = "firstName")
    @NotEmpty
    private String firstName;
    @Column(name = "lastName")
    @NotEmpty
    private String lastName;
    @Column(name = "phone")
    @NotEmpty
    private String phone;
    @Column(name = "image")
    private String image;
    @Column(name = "dateOfBirth")
    @NotEmpty
    private Date DoB;
    @Column(name = "cv")
    private File CV;


    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    @NotEmpty(message = "Please provide your address")
    private String address;


}
