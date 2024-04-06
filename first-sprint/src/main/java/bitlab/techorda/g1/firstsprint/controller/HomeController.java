package bitlab.techorda.g1.firstsprint.controller;

import bitlab.techorda.g1.firstsprint.db.DbManager;
import bitlab.techorda.g1.firstsprint.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Model model){
        List<Student> students = DbManager.getStudents();
        model.addAttribute("studenty", students);
        return "home";
    }

    /**
     * для отображения новой странички
     * @return
     */
    @GetMapping("/addStudent")
    public String createStudentPage(){
        return "addStudent";
    }

    /**
     * для добавления студента
     * @param student
     * @return
     */
    @PostMapping("/students/add")
    public String addStudentPage(Student student){
        student.setMark(DbManager.resultGrade(student.getExam()));
        DbManager.addStudent(student);
        return "redirect:/";
    }
}
