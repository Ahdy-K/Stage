package de.tekup.internshipapplicationservice.Service;

import de.tekup.internshipapplicationservice.Repository.InternshipRepository;
import de.tekup.internshipapplicationservice.models.Internship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InternshipService {
    @Autowired
    private InternshipRepository internshipRepository;
    public Internship getInternshipApplicationById(Long id){
        return this.internshipRepository.getById(id);
    }
    public List<Internship> getAllInernshipsApplications(){
        return this.internshipRepository.findAll();
    }
    public Internship updateInternshipApplication(Long internshipId, Internship internship){
        Internship newInternship = this.getInternshipApplicationById(internshipId);
        if(newInternship==null){
            throw new NoSuchElementException();
        }else {
            // update Internship
            if(internship.getCv()!=null)
                newInternship.setCv(internship.getCv());
            if(internship.getMotivationLetter()!=null)
                newInternship.setMotivationLetter(internship.getMotivationLetter());
        }
        return newInternship;
    }
    public Internship addInternship(Internship internship){
        Internship exp = new Internship();
        exp.setUserId(internship.getUserId());
        exp.setEntrepriseId(internship.getEntrepriseId());
        exp.setCv(internship.getCv());
        exp.setMotivationLetter(exp.getMotivationLetter());
        Date date = new Date();
        exp.setDate(date);
        System.out.println(exp.toString());
        return this.internshipRepository.save(exp);
    }
    public List<Internship> getUserSApplications(Long id){
        return this.internshipRepository.getInternshipByUserId(id);
    }
    public Internship getUserInternshipById(Long id){
        return this.internshipRepository.getById(id);
    }
    // !!! jointure n9sa
    public List<Internship> getUserSApplicationByEnterpriseId(Long userId,Long enterpriseId){

        return this.internshipRepository.getInternshipByUserIdAndAndEntrepriseId(userId, enterpriseId);
    }
    public List<Internship> getEntrepriseSApplications(Long id){
        return this.internshipRepository.getInternshipByUserId(id);
    }
}
