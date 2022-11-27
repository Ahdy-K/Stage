package de.tekup.internshipapplicationservice.Service;

import de.tekup.internshipapplicationservice.Repository.DirectApplicationRepository;
import de.tekup.internshipapplicationservice.models.DicrectApplication;
import de.tekup.internshipapplicationservice.models.Status;
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
        return this.internshipRepository.findDicrectApplicationsById(id);
    }

    public List<DicrectApplication> getAllInernshipsApplications(){
        return this.internshipRepository.findAll();
    }

    public List<DicrectApplication> getAllInernshipsApplicationsByEntreprise(Long entrepriseId){
        return this.internshipRepository.findDicrectApplicationsByEntrepriseId(entrepriseId);
    }


    public DicrectApplication addInternship(Long userId,Long entrepriseId){
        DicrectApplication exp = new DicrectApplication();
        exp.setUserId(userId);
        exp.setEntrepriseId(entrepriseId);
        exp.setStatus(Status.PENDING);
        Date date = new Date();
        exp.setDate(date);

        return this.internshipRepository.save(exp);
    }


    public List<DicrectApplication> getUserSApplications(Long id){
        return this.internshipRepository.findDicrectApplicationsByUserId(id);
    }

    public void deleteApplication(Long id){
        DicrectApplication application=internshipRepository.findDicrectApplicationsById(id);
        this.internshipRepository.delete(application);
    }

    public void acceptApplication(Long id){
        DicrectApplication application=internshipRepository.findDicrectApplicationsById(id);
        application.setStatus(Status.ACCEPTED);
        this.internshipRepository.save(application);

    }

    public void rejectApplication(Long id){
        DicrectApplication application=internshipRepository.findDicrectApplicationsById(id);
        application.setStatus(Status.REJECTED);
        this.internshipRepository.save(application);

    }



}
