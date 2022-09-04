package com.android.aps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.android.aps.databinding.ActivityAdminDashBinding;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboard extends AppCompatActivity {
    ActivityAdminDashBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminDashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] name = {"Dr. Kumar B I D", "Prof. Nandeeswar S B", "Mrs. Pallavi H B", "Ms. Shravya S", "Mrs. Shruthi B S", "Mrs. Vidya V Patil"};
        String[] designation = {"HOD and Professor, ISE", "Associate Professor, ISE", "Assistant Professor, ISE", "Assistant Professor, ISE", "Assistant Professor, ISE", "Assistant Professor, ISE"};

        final ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< name.length;i++){

            User user = new User(name[i],designation[i]);
            userArrayList.add(user);

        }

        ListAdapter listAdapter;
        listAdapter = new ListAdapter(AdminDashboard.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(AdminDashboard.this,AdminActivity.class);
                startActivity(i);

            }
        });

    }
}
