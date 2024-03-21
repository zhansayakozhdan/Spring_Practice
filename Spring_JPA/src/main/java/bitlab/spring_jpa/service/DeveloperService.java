package bitlab.spring_jpa.service;

import bitlab.spring_jpa.model.Developer;
import bitlab.spring_jpa.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;

    public List<Developer> getSortedDevelopers() {
        List<Developer> developers = developerRepository.findAll();
        return developers;
    }

    public Developer addDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer getDeveloperById(Long id) {
        return developerRepository.findById(id).orElse(null);
    }

    public Developer editDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public List<Developer> search(String search) {
        return developerRepository.search(search);
    }
}
