package bitlab.spring_jpa.service;

import bitlab.spring_jpa.model.ApplicationRequest;
import bitlab.spring_jpa.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    public List<ApplicationRequest> getAllRequests(){
        List<ApplicationRequest> requests = requestRepository.findAll();
        return requests;
    }

    public ApplicationRequest addApplicationRequest(ApplicationRequest request){
        return requestRepository.save(request);
    }
}
