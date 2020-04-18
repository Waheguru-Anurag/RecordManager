package com.example.recordmanager.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.recordmanager.R;
import com.example.recordmanager.model.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fragmentStudentUploadActivity extends Fragment {
    private View view;
    private EditText edit1, edit2, edit3, edit4, edit5;
    Student student;
    Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_student_upload_details, container, false);
        edit1 = (EditText) view.findViewById(R.id.editext1);
        edit2 = (EditText) view.findViewById(R.id.editext2);
        edit3 = (EditText) view.findViewById(R.id.editext3);
        edit4 = (EditText) view.findViewById(R.id.editext4);
        edit5 = (EditText) view.findViewById(R.id.editext5);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Upload();
            }
        });
        return view;
    }

    public void Upload() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("students");
        String id = ref.push().getKey();
        ref.child(id).setValue(new Student(edit1.getText().toString().trim(), edit2.getText().toString().trim(), edit3.getText().toString().trim()
                , edit4.getText().toString().trim(), edit5.getText().toString().trim()));
        Navigation.findNavController(view).navigate(R.id.action_fragmentUpload_to_fragmentMain);
    }

}
