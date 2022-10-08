package de.tekup.internshipapplicationservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean status;

    private Long user_id;

    @ManyToOne
    private Offer offer;

    private File cv ;

    private File motivation_letter;

    private LocalDate date;
}
