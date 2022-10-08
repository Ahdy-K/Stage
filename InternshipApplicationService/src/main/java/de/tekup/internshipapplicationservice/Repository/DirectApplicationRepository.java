package de.tekup.internshipapplicationservice.Repository;

import de.tekup.internshipapplicationservice.models.DicrectApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DirectApplicationRepository extends JpaRepository<DicrectApplication,Long> {
    DicrectApplication getInternshipByDate(Date date);
    List<DicrectApplication> getInternshipByEntrepriseId(Long entrepriseId);
    List<DicrectApplication> getInternshipByUserId(Long userId);
    DicrectApplication getById(Long id);
    List<DicrectApplication> getInternshipByUserIdAndAndEntrepriseId(Long userId, Long enterpriseId);
}
