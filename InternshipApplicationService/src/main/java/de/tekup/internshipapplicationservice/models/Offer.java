package de.tekup.internshipapplicationservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private Long entrepriseId;
    @ElementCollection
    private List<String> technologies=new ArrayList<>();
    @ElementCollection
    private List<String> skills=new ArrayList<>();
    private String type;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate begin_date;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate end_date;
}
