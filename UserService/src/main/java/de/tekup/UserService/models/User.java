package de.tekup.UserService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.List;
// add entity annotation
@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    @NotEmpty(message = "Please provide your address")
    private String address;
    //
    // attributes after account creation
    @Column(name = "cv")
    private String CV;
  // attributes after account creation
    @Column(name = "cv")
    private String CV;
    @ElementCollection
    //@MapKeyColumn(name = "urlName")
    @Column(name = "urls",nullable = true)
    private List<String> urls;
    @Column(name = "speciality",nullable = true)
    private String speciality;
    @Column(name = "skills",nullable = true)
    @ElementCollection
    private List<String> skills;
    @Column(name = "softSkills",nullable = true)
    @ElementCollection
    private List<String> softSkills;
    @Column(name = "level",nullable = true)
    private String grade;
    @Column(name = "intro",nullable = true)
    private String intro;

}
