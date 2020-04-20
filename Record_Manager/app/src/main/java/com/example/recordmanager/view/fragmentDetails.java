package com.example.recordmanager.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recordmanager.R;

public class fragmentDetails extends Fragment {

    private TextView textView1,textView2,textView3,textView4,textView5;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_details, container, false);
        textView1 = view.findViewById(R.id.text1);
        textView2 = view.findViewById(R.id.text2);
        textView3 = view.findViewById(R.id.text3);
        textView4 = view.findViewById(R.id.text4);
        textView5 = view.findViewById(R.id.text5);
        assert getArguments() != null;
        textView1.setText(getArguments().getString("name"));
        textView2.setText(getArguments().getString("enrollment"));
        textView3.setText(getArguments().getString("age"));
        textView4.setText(getArguments().getString("bhawan"));
        textView5.setText(getArguments().getString("branch"));
        return view;
    }
}
