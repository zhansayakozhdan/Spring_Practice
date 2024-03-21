package bitlab.spring_jpa.sprinttask2.repository;

import bitlab.spring_jpa.sprinttask2.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
