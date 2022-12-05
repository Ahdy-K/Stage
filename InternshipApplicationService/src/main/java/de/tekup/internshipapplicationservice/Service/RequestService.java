package de.tekup.internshipapplicationservice.Service;

import de.tekup.internshipapplicationservice.Repository.OfferRepository;
import de.tekup.internshipapplicationservice.Repository.RequestApplicationRepository;
import de.tekup.internshipapplicationservice.models.Offer;
import de.tekup.internshipapplicationservice.models.RequestApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestApplicationRepository requestApplicationRepository;
    private final OfferRepository offerRepository;

    //a user can make a request
    public ResponseEntity<RequestApplication> makeRequest(Long offerId, Long userId) {
        List<RequestApplication> requestApplication=requestApplicationRepository.findRequestApplicationsByUser_idAndOffer(offerId,userId);
        if(requestApplication.isEmpty()){
            Offer offer=offerRepository.findOfferById(offerId);
            RequestApplication request=new RequestApplication();
            request.setOffer(offer);
            request.setStatus(false);
            Date date = new Date();
            request.setDate(date);
            request.setUser_id(userId);
            return ResponseEntity.ok().body(requestApplicationRepository.save(request));

        }
        else{
            return
                    ResponseEntity.badRequest().body(null);

        }

    }



    //for admin only
    public List<RequestApplication> getRequests() {
        return requestApplicationRepository.findAll();
    }



    //get request by Id
    public RequestApplication getRequestById(Long id) {
        return requestApplicationRepository.findRequestApplicationById(id);
    }





    public void deleteRequest(Long id) {
        RequestApplication request=requestApplicationRepository.findRequestApplicationById(id);
        requestApplicationRepository.delete(request);

    }
    public void ConfirmRequest(Long id){
        RequestApplication request=requestApplicationRepository.findRequestApplicationById(id);
        request.setStatus(true);
        requestApplicationRepository.save(request);

    }
   /* public List<RequestApplication> getRequestByUserId(Long userId){
        return  requestApplicationRepository.findRequestApplicationsByUser_id(userId);

    }*/
    public List<RequestApplication> getRequestByOffer(Long offerid){
        Offer offer =offerRepository.findOfferById(offerid);
        return  requestApplicationRepository.findRequestApplicationsByOffer(offer);

    }
    public List<RequestApplication> getRequestByUser(Long UserId){

        return  requestApplicationRepository.findRequestApplicationsByUser_id(UserId);

    }
    public List<RequestApplication> getRequestByUserAndOffer(Long UserId,Long offerId){

        return  requestApplicationRepository.findRequestApplicationsByUser_idAndOffer(UserId,offerId);

    }
}
