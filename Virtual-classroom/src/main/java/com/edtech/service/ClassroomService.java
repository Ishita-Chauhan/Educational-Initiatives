package com.edtech.service;

//importing
import com.edtech.model.Classroom;
import com.edtech.util.CustomLogger;

import java.util.HashMap;
import java.util.Map;

public class ClassroomService {
    public final Map<String, Classroom> classrooms = new HashMap<>();

    public void addClassroom(String name) {
        if (classrooms.containsKey(name)) {
            CustomLogger.warn("Classroom " + name + " already exists.");
            return;
        }
        classrooms.put(name, new Classroom(name));
        CustomLogger.info("Classroom " + name + " has been created.");
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            CustomLogger.info("No classrooms available.");
            return;
        }
        CustomLogger.info("Classrooms:");
        classrooms.keySet().forEach(CustomLogger::info);
    }
}
