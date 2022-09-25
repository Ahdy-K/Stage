package de.tekup.internshipapplicationservice.ressource;

import de.tekup.internshipapplicationservice.Service.InternshipService;
import de.tekup.internshipapplicationservice.models.Internship;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/spontaneousapplications")
public class InternshipController {
    @Autowired
    private  InternshipService internshipService;
    // For test or admin only
    @GetMapping("/allinternships")
    public List<Internship> getAllInternships(){
        return this.internshipService.getAllInernshipsApplications();
    }
    // get user applications
    @GetMapping("/userapplications/{userid}")
    public List<Internship> getUserApplications(@PathVariable("userid") Long userid){
        return this.internshipService.getUserSApplications(userid);
    }
    // Returning a user specific application(by id)
    @GetMapping("/userapplications/{userid}/{id}")
    public Internship getUserInternshipById(@PathVariable("userid") Long userid, @PathVariable("id") Long id){
        return this.internshipService.getUserInternshipById(id);
    }

    // Manage Enreprise applications
    //get entreprise applications
    @GetMapping("/entrepriseapplications/{id}")
    public List<Internship> getEntrepriseApplications(@PathVariable("id") Long id){
        return this.internshipService.getEntrepriseSApplications(id);
    }
    @PostMapping("/apply/enterprise/{enterpriseId}")
    // userid
    public Internship applyForInternship(@PathVariable("enterpriseId") Long enterpriseId, Internship internship){
        // return some null fields
        return this.internshipService.addInternship(internship);
    }
    @PutMapping("/apply/enterprise/{enterpriseId}/{internshipId}")
    //get userId to return only user applications
    public Internship updateApplication(@PathVariable("internshipId") Long internshipId, Internship inetrnship){
        return this.internshipService.updateInternshipApplication(internshipId, inetrnship);
    }
}