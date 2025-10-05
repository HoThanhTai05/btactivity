package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageButton btnSetting;
    private TextView tvUserName, tvEmail, tvPhone, tvSkype, tvWeb;
    private ImageView imgAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Ánh xạ view
        btnSetting = findViewById(R.id.btnSetting);
        tvUserName = findViewById(R.id.tvUserName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvSkype = findViewById(R.id.tvSkype);
        tvWeb = findViewById(R.id.tvWeb);
        imgAvatar = findViewById(R.id.imgAvatar);

        // Lấy email hoặc username từ LoginActivity
        String email = getIntent().getStringExtra("email");
        if (email == null) email = getIntent().getStringExtra("username");
        if (email == null) email = "mail@email.com";

        // Hiển thị
        tvUserName.setText(email.split("@")[0]);
        tvEmail.setText("email : " + email);

        // Bấm bánh răng quay về LoginActivity
        btnSetting.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
