package com.edtech.service;

import com.edtech.model.Assignment;
import com.edtech.util.CustomLogger;
import com.edtech.util.CustomLogger;

public class AssignmentService {
    private final ClassroomService classroomService;

    public AssignmentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public void scheduleAssignment(String classroomName, String details) {
        if (!classroomService.classrooms.containsKey(classroomName)) {
            CustomLogger.warn("Classroom " + classroomName + " does not exist.");
            return;
        }
        Assignment assignment = new Assignment(details);
        classroomService.classrooms.get(classroomName).addAssignment(assignment);
        CustomLogger.info("Assignment for " + classroomName + " has been scheduled.");
    }

    public void submitAssignment(String studentId, String classroomName, String details) {
        if (!classroomService.classrooms.containsKey(classroomName)) {
            CustomLogger.warn("Classroom " + classroomName + " does not exist.");
            return;
        }

        var assignments = classroomService.classrooms.get(classroomName).getAssignments();
        for (Assignment assignment : assignments) {
            if (assignment.getDetails().equals(details) && !assignment.isSubmitted()) {
                assignment.markSubmitted();
                CustomLogger.info("Assignment submitted by Student " + studentId + " in " + classroomName + ".");
                return;
            }
        }
        CustomLogger.warn("No matching assignment found for submission.");
    }

    public void listAssignments(String classroomName) {
        if (!classroomService.classrooms.containsKey(classroomName)) {
            CustomLogger.warn("Classroom " + classroomName + " does not exist.");
            return;
        }
        var assignments = classroomService.classrooms.get(classroomName).getAssignments();
        if (assignments.isEmpty()) {
            CustomLogger.info("No assignments scheduled for " + classroomName + ".");
            return;
        }
        CustomLogger.info("Assignments for " + classroomName + ":");
        assignments.forEach(assignment -> CustomLogger.info(assignment.getDetails() + (assignment.isSubmitted() ? " (Submitted)" : "")));
    }
}
