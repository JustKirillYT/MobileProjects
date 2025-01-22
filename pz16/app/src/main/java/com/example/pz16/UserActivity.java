package com.example.pz16;

import static com.example.pz16.UserStaticInfo.POSITION;
import static com.example.pz16.UserStaticInfo.users;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Stack;

public class UserActivity extends AppCompatActivity {
    EditText NameTextView, StateTextView;

    private User activeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);
        int position = getIntent().getIntExtra(POSITION, 0);
        activeUser = users.get(position);
        Init();
        setUserInfo();
    }

    public void back(View view) {
        onBackPressed();
    }
    private void Init() {
        NameTextView = findViewById(R.id.NameTextView);
        StateTextView = findViewById(R.id.StateTextView);
    }

    public void setUserInfo() {
        NameTextView.setText(activeUser.getName());
        StateTextView.setText(activeUser.getState());
    }

    public void save(View view) {
        activeUser.setName(NameTextView.getText().toString());
        activeUser.setState(StateTextView.getText().toString());
        finish();
    }

}