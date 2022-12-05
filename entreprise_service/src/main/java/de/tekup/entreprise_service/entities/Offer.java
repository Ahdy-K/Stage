package de.tekup.entreprise_service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {

    private String subject;
    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;
    @ElementCollection
    private List<String> technologies=new ArrayList<>();
    private String type;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate begin_date;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate end_date;
    @ElementCollection
    private List<String> skills=new ArrayList<>();
    private String title;


}
