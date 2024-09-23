package com.edtech.model;

public class Student {
    private String id;
    private String classroomName;

    public Student(String id, String classroomName) {
        this.id = id;
        this.classroomName = classroomName;
    }

    public String getId() {
        return id;
    }

    public String getClassroomName() {
        return classroomName;
    }
}
