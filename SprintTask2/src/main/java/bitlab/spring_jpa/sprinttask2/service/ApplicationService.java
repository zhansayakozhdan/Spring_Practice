package bitlab.spring_jpa.sprinttask2.service;

import bitlab.spring_jpa.sprinttask2.model.ApplicationRequest;
import bitlab.spring_jpa.sprinttask2.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public ApplicationRequest getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    public List<ApplicationRequest> getAllApplications() {
        return applicationRepository.findAll();
    }

    public ApplicationRequest addRequest(ApplicationRequest application) {
        return applicationRepository.save(application);
    }

   public ApplicationRequest editRequest(ApplicationRequest application){
        application.setHandled(true);
        return applicationRepository.save(application);
   }

    public void deleteRequest(ApplicationRequest applicationRequest) {
        applicationRepository.deleteById(applicationRequest.getId());
    }

    public List<ApplicationRequest> getApplicationsByHandled(boolean isHandled) {
        return applicationRepository.findAllByHandled(isHandled);
    }
}
