package de.tekup.internshipapplicationservice.Service;

import de.tekup.internshipapplicationservice.Repository.OfferRepository;
import de.tekup.internshipapplicationservice.Repository.RequestApplicationRepository;
import de.tekup.internshipapplicationservice.models.Offer;
import de.tekup.internshipapplicationservice.models.RequestApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestApplicationRepository requestApplicationRepository;
    private final OfferRepository offerRepository;

    //a user can make a request
    public void makeRequest(Long offerId, RequestApplication request) {
        Offer offer=offerRepository.findOfferById(offerId);
        request.setOffer(offer);
        requestApplicationRepository.save(request);

    }


    //for admin only
    public List<RequestApplication> getRequests() {
        return requestApplicationRepository.findAll();
    }



    //get request by Id
    public RequestApplication getRequestById(Long id) {
        return requestApplicationRepository.findRequestApplicationById(id);
    }


    public RequestApplication updateRequest(Long requestId , RequestApplication newRequest) {
        RequestApplication request =requestApplicationRepository.findRequestApplicationById(requestId);
        if(newRequest.getCv()!=null)
            request.setCv(newRequest.getCv());
        if(newRequest.getMotivation_letter()!=null)
            request.setMotivation_letter(newRequest.getMotivation_letter());

        return requestApplicationRepository.save(request);
    }


    public void deleteRequest(Long id) {
        RequestApplication request=requestApplicationRepository.findRequestApplicationById(id);
        requestApplicationRepository.delete(request);

    }
    public List<RequestApplication> getRequestByUserId(Long userId){
        return  requestApplicationRepository.findRequestApplicationByUser_id(userId);

    }
    public List<RequestApplication> getRequestByOffer(Long offerid){
        Offer offer =offerRepository.findOfferById(offerid);
        return  requestApplicationRepository.findRequestApplicationsByOffer(offer);

    }
}
