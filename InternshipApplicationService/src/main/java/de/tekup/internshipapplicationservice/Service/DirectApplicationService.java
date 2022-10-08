package de.tekup.internshipapplicationservice.Service;

import de.tekup.internshipapplicationservice.Repository.DirectApplicationRepository;
import de.tekup.internshipapplicationservice.models.DicrectApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DirectApplicationService {

    private final DirectApplicationRepository internshipRepository;
    public DicrectApplication getInternshipApplicationById(Long id){
        return this.internshipRepository.getById(id);
    }

    public List<DicrectApplication> getAllInernshipsApplications(){
        return this.internshipRepository.findAll();
    }

    public DicrectApplication updateInternshipApplication(Long internshipId, DicrectApplication internship){
        DicrectApplication newInternship = this.getInternshipApplicationById(internshipId);
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
    public DicrectApplication addInternship(DicrectApplication internship){
        DicrectApplication exp = new DicrectApplication();
        exp.setUserId(internship.getUserId());
        exp.setEntrepriseId(internship.getEntrepriseId());
        exp.setCv(internship.getCv());
        exp.setMotivationLetter(exp.getMotivationLetter());
        Date date = new Date();
        exp.setDate(date);
        System.out.println(exp.toString());
        return this.internshipRepository.save(exp);
    }
    public List<DicrectApplication> getUserSApplications(Long id){
        return this.internshipRepository.getInternshipByUserId(id);
    }
    public DicrectApplication getUserInternshipById(Long id){
        return this.internshipRepository.getById(id);
    }
    // !!! jointure n9sa
    public List<DicrectApplication> getUserSApplicationByEnterpriseId(Long userId, Long enterpriseId){

        return this.internshipRepository.getInternshipByUserIdAndAndEntrepriseId(userId, enterpriseId);
    }
    public List<DicrectApplication> getEntrepriseSApplications(Long id){
        return this.internshipRepository.getInternshipByUserId(id);
    }
}
