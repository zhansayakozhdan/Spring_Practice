package bitlab.spring_jpa.sprinttask2.controller;

import bitlab.spring_jpa.sprinttask2.model.ApplicationRequest;
import bitlab.spring_jpa.sprinttask2.model.Course;
import bitlab.spring_jpa.sprinttask2.service.ApplicationService;
import bitlab.spring_jpa.sprinttask2.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class HomeController {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<ApplicationRequest> applications = applicationService.getAllApplications();

        log.info("Sending data from the controller to the front");
        model.addAttribute("zayavki", applications);
        return "home";
    }
    @GetMapping("/application/request")
    public String addingPage(Model model){
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "addRequest";
    }

    /**
     * Добавление заявки
     * @param application новая заявка
     * @return
     */
    @PostMapping("/application/add")
    public String addRequestPage(ApplicationRequest application) {
        applicationService.addRequest(application);
        return "redirect:/";
    }

    /**
     * @PathVariable Long id -> считали параметр айдишки
     * Страница детального просмотра данных
     */
    @GetMapping("/request/{id}")
    public String detailsPage(@PathVariable Long id, Model model){
        ApplicationRequest application = applicationService.getApplicationById(id);
        model.addAttribute("zayavka", application);

        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "details";
    }

    /**
     * При вызове editRequest мы только меняем поле handled на true
     * @param applicationRequest
     * @return
     */
    @PostMapping("/request/edit")
    public String editRequest(ApplicationRequest applicationRequest){
        applicationService.editRequest(applicationRequest);
        return "redirect:/";
    }

    /**
     * Удаление заявки
     * @param applicationRequest
     */
    @PostMapping("/request/delete")
    public String deleteRequest(ApplicationRequest applicationRequest){
        applicationService.deleteRequest(applicationRequest);
        return "redirect:/";
    }

    /**
     * Новые необработанные заявки
     * У сервиса вызываем метод .getApplicationsByHandled(false) в параметры задаем какие заявки нам нужны
     * не обработанные = false
     */
    @GetMapping("/new/requests")
    public String allNewRequestsPage(Model model){
        List<ApplicationRequest> newRequests = applicationService.getApplicationsByHandled(false);
        model.addAttribute("newZayavki", newRequests);
        return "newRequests";
    }

    /**
     * Обработанные заявки
     * У сервиса вызываем метод .getApplicationsByHandled(true) в параметры задаем какие заявки нам нужны
     * обработанные = true
     */
    @GetMapping("/finished/requests")
    public String allFinishedRequestsPage(Model model){
        List<ApplicationRequest> finishedRequests = applicationService.getApplicationsByHandled(true);
        model.addAttribute("finishedZayavki", finishedRequests);
        return "finishedRequests";
    }

}
