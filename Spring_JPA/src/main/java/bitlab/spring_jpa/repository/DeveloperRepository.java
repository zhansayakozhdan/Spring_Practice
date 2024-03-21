package bitlab.spring_jpa.repository;

import bitlab.spring_jpa.model.ApplicationRequest;
import bitlab.spring_jpa.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    @Query("SELECT d FROM Developer d "
            + "WHERE d.name ilike concat('%', :search, '%') "
            + "OR d.age = :search "
            + "OR d.birthPlace ilike concat('%', :search, '%') ")
    List<Developer> search(String search);
}
