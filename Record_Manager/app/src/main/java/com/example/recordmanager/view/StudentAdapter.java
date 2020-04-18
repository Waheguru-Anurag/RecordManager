package com.example.recordmanager.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordmanager.R;
import com.example.recordmanager.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    List<Student> student ;
    Student currentstudent;
    private OnItemClickListener Listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        Listener = listener;
    }

    public StudentAdapter(List<Student> student) {
        this.student = student;
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView enrollment;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text);
            enrollment = itemView.findViewById(R.id.text2);
        }
        StudentHolder(View itemView , final OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.text);
            enrollment = itemView.findViewById(R.id.text2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_item,parent,false);

        return new StudentHolder(itemview, Listener);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        if(student!=null) {
            currentstudent = student.get(position);
            holder.name.setText(currentstudent.getName());
            holder.enrollment.setText(currentstudent.getEnrollment());
        }
    }

    @Override
    public int getItemCount() {
        return student.size();
    }
}
