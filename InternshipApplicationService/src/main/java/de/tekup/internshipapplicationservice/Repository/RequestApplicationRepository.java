package de.tekup.internshipapplicationservice.Repository;

import de.tekup.internshipapplicationservice.models.Offer;
import de.tekup.internshipapplicationservice.models.RequestApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RequestApplicationRepository extends JpaRepository<RequestApplication,Long> {
    RequestApplication findRequestApplicationById(Long id);
   // List<RequestApplication> findRequestApplicationsByUser_id(Long id);
    List<RequestApplication> findRequestApplicationsByOffer(Offer offer);

}
