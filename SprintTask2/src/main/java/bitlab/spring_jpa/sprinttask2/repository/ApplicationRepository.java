package bitlab.spring_jpa.sprinttask2.repository;

import bitlab.spring_jpa.sprinttask2.model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationRequest, Long> {
    List<ApplicationRequest> findAllByHandled(boolean isHandle);
}
