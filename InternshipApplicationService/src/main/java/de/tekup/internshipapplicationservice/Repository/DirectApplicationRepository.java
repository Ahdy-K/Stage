package de.tekup.internshipapplicationservice.Repository;

import de.tekup.internshipapplicationservice.models.DicrectApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface DirectApplicationRepository extends JpaRepository<DicrectApplication,Long> {
    DicrectApplication getInternshipByDate(Date date);
    List<DicrectApplication> getInternshipByEntrepriseId(Long entrepriseId);
    List<DicrectApplication> getInternshipByUserId(Long userId);
    DicrectApplication getById(Long id);
    List<DicrectApplication> getInternshipByUserIdAndAndEntrepriseId(Long userId, Long enterpriseId);
}
