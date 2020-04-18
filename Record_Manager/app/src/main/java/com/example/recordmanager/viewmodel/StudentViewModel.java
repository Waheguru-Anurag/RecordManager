package com.example.recordmanager.viewmodel;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.recordmanager.model.Student;
import com.example.recordmanager.model.StudentLiveData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel extends ViewModel {
    private static final DatabaseReference ref =
            FirebaseDatabase.getInstance().getReference("students");

    private final StudentLiveData liveData = new StudentLiveData(ref);

    @NonNull
    public LiveData<List<Student>> getStudentLiveData(){
        StudentLiveData liveData = new StudentLiveData(ref);

        return Transformations.map(liveData, new Deserializer());
    }

    private class Deserializer implements Function<DataSnapshot, List<Student>> {
        @Override
        public List<Student> apply(DataSnapshot dataSnapshot) {
            List<Student> students = new ArrayList<>();
            for(DataSnapshot snap : dataSnapshot.getChildren()){
                Student student = snap.getValue(Student.class);
                students.add(student);
            }
            return students;
        }
    }
}