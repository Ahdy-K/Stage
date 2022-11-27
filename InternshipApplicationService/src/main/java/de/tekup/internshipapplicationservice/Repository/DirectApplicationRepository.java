package de.tekup.internshipapplicationservice.Repository;

import de.tekup.internshipapplicationservice.models.DicrectApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface DirectApplicationRepository extends JpaRepository<DicrectApplication,Long> {

    DicrectApplication findDicrectApplicationsByDate(Date date);
    List<DicrectApplication> findDicrectApplicationsByEntrepriseId(Long entrepriseId);
    List<DicrectApplication> findDicrectApplicationsByUserId(Long userId);
    DicrectApplication findDicrectApplicationsById(Long id);
    List<DicrectApplication> findDicrectApplicationsByUserIdAndEntrepriseId(Long userId, Long enterpriseId);
}
