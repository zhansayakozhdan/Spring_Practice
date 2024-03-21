package bitlab.spring_jpa.repository;

import bitlab.spring_jpa.model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<ApplicationRequest, Long> {

}
