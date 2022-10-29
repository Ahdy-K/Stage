package de.tekup.internshipapplicationservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DicrectApplication {
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


}
