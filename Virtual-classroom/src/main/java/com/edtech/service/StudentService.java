package com.edtech.service;

import com.edtech.model.Student;
import com.edtech.util.CustomLogger;

public class StudentService {
    private final ClassroomService classroomService;

    public StudentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public void addStudent(String id, String classroomName) {
        if (!classroomService.classrooms.containsKey(classroomName)) {
            CustomLogger.warn("Classroom " + classroomName + " does not exist.");
            return;
        }
        Student student = new Student(id, classroomName);
        classroomService.classrooms.get(classroomName).addStudent(student);
        CustomLogger.info("Student " + id + " has been enrolled in " + classroomName + ".");
    }

    public void listStudents(String classroomName) {
        if (!classroomService.classrooms.containsKey(classroomName)) {
            CustomLogger.warn("Classroom " + classroomName + " does not exist.");
            return;
        }
        var students = classroomService.classrooms.get(classroomName).getStudents();
        if (students.isEmpty()) {
            CustomLogger.info("No students enrolled in " + classroomName + ".");
            return;
        }
        CustomLogger.info("Students in " + classroomName + ":");
        students.forEach(student -> CustomLogger.info(student.getId()));
    }
}
