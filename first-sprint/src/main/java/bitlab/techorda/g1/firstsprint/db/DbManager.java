package bitlab.techorda.g1.firstsprint.db;

import bitlab.techorda.g1.firstsprint.model.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class DbManager {
    @Getter
    private static List<Student> students = new ArrayList<>();
    private static Long id = 10L;
    static {
        students.add(new Student(1L, "Zhansaya", "Kozhdan", 98, "A"));
        students.add(new Student(2L, "Dias", "Kozhdan", 74, "C"));
        students.add(new Student(3L, "Omar", "Turarov", 50, "D"));
        students.add(new Student(4L, "Anet", "Satkali", 49, "F"));
        students.add(new Student(5L, "Madina", "Kozhdan", 100, "A"));
        students.add(new Student(6L, "Ulan", "Omarov", 45, "F"));
        students.add(new Student(7L, "Kamilya", "Kozhdan", 95, "A"));
        students.add(new Student(8L, "Alisultan", "Kozhdan", 89, "B"));
        students.add(new Student(9L, "Aigul", "Duisemuratova", 100, "A"));
    }

    public static void addStudent(Student student){
        student.setId(id);
        id++;
        students.add(student);
    }

    public static String resultGrade(int exam){
        if (exam >= 90) {
            return "A";
        } else if (exam >= 75) {
            return "B";
        } else if (exam >= 60) {
            return "C";
        } else if (exam >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
