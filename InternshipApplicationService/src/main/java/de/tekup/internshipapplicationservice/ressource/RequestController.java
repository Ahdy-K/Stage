package de.tekup.internshipapplicationservice.ressource;

import de.tekup.internshipapplicationservice.Service.RequestService;
import de.tekup.internshipapplicationservice.models.Offer;
import de.tekup.internshipapplicationservice.models.RequestApplication;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {

    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/makerequest/{offerId}")
    public void makeRequest(@PathVariable("offerId") Long offerId,@RequestBody RequestApplication request) {
        requestService.makeRequest(offerId,request);


    }


    //for admin only
    @GetMapping("/getRequests")
    public List<RequestApplication> getRequests() {
        return requestService.getRequests();
    }



    //get request by Id
    @GetMapping("/getRequest/{id}")
    public RequestApplication getRequestById(@PathVariable("id") Long id) {
        return requestService.getRequestById(id);
    }

    @PutMapping("/update/{requestId}")
    public RequestApplication updateRequest(@PathVariable("requestId") Long requestId ,@RequestBody RequestApplication newRequest) {
        return  requestService.updateRequest(requestId,newRequest);

    }


    @DeleteMapping("/delete/{id}")
    public void deleteRequest(@PathVariable("id") Long id) {
        requestService.deleteRequest(id);

    }
   /* @GetMapping("/getRequestByUser/{userId}")
    public List<RequestApplication> getRequestByUserId(@PathVariable("userId") Long userId){
        return  requestService.getRequestByUserId(userId);

    }*/
    @GetMapping("/getRequestByOffer/{offerid}")
    public List<RequestApplication> getRequestByOffer(@PathVariable("offerid") Long offerid){
        return  requestService.getRequestByOffer(offerid);

    }
}
