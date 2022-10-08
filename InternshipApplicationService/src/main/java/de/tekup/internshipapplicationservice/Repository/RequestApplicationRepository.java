package de.tekup.internshipapplicationservice.Repository;

import de.tekup.internshipapplicationservice.models.Offer;
import de.tekup.internshipapplicationservice.models.RequestApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestApplicationRepository extends JpaRepository<RequestApplication,Long> {
    RequestApplication findRequestApplicationById(Long id);
    List<RequestApplication> findRequestApplicationByUser_id(Long id);
    List<RequestApplication> findRequestApplicationsByOffer(Offer offer);

}
