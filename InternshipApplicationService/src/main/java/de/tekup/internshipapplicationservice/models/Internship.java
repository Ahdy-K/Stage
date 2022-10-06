package de.tekup.internshipapplicationservice.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "entrepriseId")
    private Long entrepriseId;
    @Column(name = "date")
    private Date date;
    @Column(name = "cv")
    private File cv;
    @Column(name = "motivationLetter")
    private File motivationLetter;


    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getEntrepriseId() {
        return entrepriseId;
    }

    public Date getDate() {
        return date;
    }

    public File getCv() {
        return cv;
    }

    public File getMotivationLetter() {
        return motivationLetter;
    }
    // setters

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setEntrepriseId(Long entrepriseId) {
        this.entrepriseId = entrepriseId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCv(File cv) {
        this.cv = cv;
    }

    public void setMotivationLetter(File motivationLetter) {
        this.motivationLetter = motivationLetter;
    }
}
