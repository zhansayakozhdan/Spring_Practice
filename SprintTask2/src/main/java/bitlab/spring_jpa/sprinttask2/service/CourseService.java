package bitlab.spring_jpa.sprinttask2.service;

import bitlab.spring_jpa.sprinttask2.model.Course;
import bitlab.spring_jpa.sprinttask2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElse(null);
    }
}
