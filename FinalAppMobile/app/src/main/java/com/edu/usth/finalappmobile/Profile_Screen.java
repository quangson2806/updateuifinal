package com.edu.usth.finalappmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile_Screen extends AppCompatActivity {
    private TextView userAvatar;
    private TextView emailUser,userNameUser,phoneUser;
    private Button editUser;
    private ImageView avatarUser;
    private String email, password;
    private FirebaseDatabase database;
    private DatabaseReference userRef;
    private static final String USER = "user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);


        String email = getIntent().getStringExtra("email");


        emailUser  = (TextView) findViewById(R.id.email_profile);
        userNameUser = (TextView) findViewById(R.id.username_profile);
        phoneUser = (TextView) findViewById(R.id.phonenumber_user);
        editUser = (Button) findViewById(R.id.button3);

        database = FirebaseDatabase.getInstance();
        userRef = database.getReference(USER);



        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    if (ds.child("email").getValue().equals(email)) {
                        emailUser.setText(ds.child("email").getValue(String.class));
                        userNameUser.setText(ds.child("username").getValue(String.class));
                        phoneUser.setText(ds.child("phone").getValue(String.class));
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}