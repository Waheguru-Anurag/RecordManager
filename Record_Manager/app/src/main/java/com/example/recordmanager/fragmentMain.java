package com.example.recordmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class fragmentMain extends Fragment {

    private StudentAdapter adapter;
    FloatingActionButton floatingActionButton;
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentmain, parent, false);
        floatingActionButton = view.findViewById(R.id.fab);
        StudentViewModel viewModel = new ViewModelProvider(this).get(StudentViewModel.class);

        LiveData<List<Student>> liveData = viewModel.getStudentLiveData();

        liveData.observe(getViewLifecycleOwner(), new Observer<List<Student>>() {
            @Override
            public void onChanged(final List<Student> students) {
                if (students.size() != 0) {
                    RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
                    recyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new StudentAdapter(students);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setNestedScrollingEnabled(false);
                    adapter.setOnItemClickListener(new StudentAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Student student = students.get(position);
                            Bundle bundle = new Bundle();
                            bundle.putString("name", student.getName());
                            bundle.putString("enrollment", student.getEnrollment());
                            bundle.putString("bhawan", student.getBhawan());
                            bundle.putString("age", student.getAge());
                            bundle.putString("branch", student.getBranch());
                            Navigation.findNavController(view).navigate(R.id.fragmentDetails,bundle);
                        }
                    });
                }
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragmentUpload);
            }
        });
        return view;
    }

}