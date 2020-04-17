package com.example.recordmanager;

import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Student {
    private String name;
    private String enrollment;
    private String branch;
    private String age;
    private String bhawan;


    public Student(String name, String enrollment, String age, String bhawan, String branch){
        this.name = name;
        this.enrollment = enrollment;
        this.bhawan = bhawan;
        this.age = age;
        this.branch = branch;
    }

    public Student(){
    }

    public String getName() {
        return name;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public String getBranch() {
        return branch;
    }

    public String getAge() {
        return age;
    }

    public String getBhawan() {
        return bhawan;
    }

}
