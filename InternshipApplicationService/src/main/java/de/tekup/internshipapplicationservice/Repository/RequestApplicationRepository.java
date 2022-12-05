package de.tekup.internshipapplicationservice.Repository;

import de.tekup.internshipapplicationservice.models.Offer;
import de.tekup.internshipapplicationservice.models.RequestApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RequestApplicationRepository extends JpaRepository<RequestApplication,Long> {
    RequestApplication findRequestApplicationById(Long id);
   // List<RequestApplication> findRequestApplicationsByUser_id(Long id);
    List<RequestApplication> findRequestApplicationsByOffer(Offer offer);
    @Query("select r from RequestApplication r where r.user_id=:uid")
    List<RequestApplication> findRequestApplicationsByUser_id(@Param("uid")Long uid);


    @Query("select r from RequestApplication r where r.user_id=:uid and r.offer.id=:offerid")
    List<RequestApplication> findRequestApplicationsByUser_idAndOffer(@Param("uid") Long uid,@Param("offerid") Long offerid);

}
