package de.tekup.internshipapplicationservice.ressource;

import de.tekup.internshipapplicationservice.Service.DirectApplicationService;
import de.tekup.internshipapplicationservice.models.DicrectApplication;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/spontaneousapplications")
public class InternshipController {
    @Autowired
    private DirectApplicationService internshipService;
    // For test or admin only
    @GetMapping("/allinternships")
    public List<DicrectApplication> getAllInternships(){
        return this.internshipService.getAllInernshipsApplications();
    }
    // get user applications
    @GetMapping("/userapplications/{userid}")
    public List<DicrectApplication> getUserApplications(@PathVariable("userid") Long userid){
        return this.internshipService.getUserSApplications(userid);
    }

    //get entreprise applications
    @GetMapping("/entrepriseapplications/{id}")
    public List<DicrectApplication> getEntrepriseApplications(@PathVariable("id") Long id){
        return this.internshipService.getAllInernshipsApplicationsByEntreprise(id);
    }
    @PostMapping("/apply/enterprise/{enterpriseId}/{userId}")
    // userid
    public DicrectApplication applyForInternship(@PathVariable("userId") Long userId,@PathVariable("enterpriseId") Long enterpriseId){
        return this.internshipService.addInternship(userId,enterpriseId);
    }

    @DeleteMapping("/deleteapplication/{id}")
    public void deleteApplication(@PathVariable("id") Long id ){
         this.internshipService.deleteApplication(id);
    }

    @PutMapping("/rejectapplication/{id}")
    public void rejectapplication(@PathVariable("id") Long id ){
        this.internshipService.rejectApplication(id);
    }
    @PutMapping("/accesptapplication/{id}")
    public void accesptapplication(@PathVariable("id") Long id ){
        this.internshipService.acceptApplication(id);
    }

}
