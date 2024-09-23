package com.edtech;

import com.edtech.service.ClassroomService;
import com.edtech.service.StudentService;
import com.edtech.service.AssignmentService;
import com.edtech.util.CustomLogger;

import java.util.Scanner;

public class VirtualClassroomManager {
    private final ClassroomService classroomService;
    private final StudentService studentService;
    private final AssignmentService assignmentService;

    public VirtualClassroomManager() {
        this.classroomService = new ClassroomService();
        this.studentService = new StudentService(classroomService);
        this.assignmentService = new AssignmentService(classroomService);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String command;

        CustomLogger.info("Welcome to the Virtual Classroom Manager!");

        do {
            CustomLogger.info("Enter command (type 'exit' to quit):");
            command = scanner.nextLine();
            processCommand(command);
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
        CustomLogger.info("Exiting the Virtual Classroom Manager.");
    }

    private void processCommand(String command) {
        try {
            String[] parts = command.split(" ", 3);
            String action = parts[0];

            switch (action.toLowerCase()) {
                case "add_classroom":
                    classroomService.addClassroom(parts[1]);
                    break;
                case "add_student":
                    studentService.addStudent(parts[1], parts[2]);
                    break;
                case "schedule_assignment":
                    assignmentService.scheduleAssignment(parts[1], parts[2]);
                    break;
                case "submit_assignment":
                    assignmentService.submitAssignment(parts[1], parts[2], parts[3]);
                    break;
                case "list_classrooms":
                    classroomService.listClassrooms();
                    break;
                case "list_students":
                    studentService.listStudents(parts[1]);
                    break;
                case "list_assignments":
                    assignmentService.listAssignments(parts[1]);
                    break;
                default:
                    CustomLogger.warn("Unknown command: " + action);
            }
        } catch (Exception e) {
            CustomLogger.error("Error processing command: " + command, e);
        }
    }

    public static void main(String[] args) {
        new VirtualClassroomManager().start();
    }
}
