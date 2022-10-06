package de.tekup.internshipapplicationservice.Repository;

import de.tekup.internshipapplicationservice.models.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship,Long> {
    Internship getInternshipByDate(Date date);
    List<Internship> getInternshipByEntrepriseId(Long entrepriseId);
    List<Internship> getInternshipByUserId(Long userId);
    Internship getById(Long id);
    List<Internship> getInternshipByUserIdAndAndEntrepriseId(Long userId, Long enterpriseId);
}
