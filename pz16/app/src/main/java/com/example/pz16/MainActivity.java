package com.example.pz16;

import static com.example.pz16.UserStaticInfo.POSITION;
import static com.example.pz16.UserStaticInfo.users;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FrameLayout userPanel;
    Context context;
    LayoutInflater layoutInFlater;

    TextView NameTextView, StateTextView,AgeTextView;

    //List<User> users = new ArrayList<>();

    static UserListAdapter userListAdapter;

    public static void updateList() {
        userListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        //AddUsersIntList();
        new UserStaticInfo();
    }



    private void Init() {
        listView = findViewById(R.id.listView);
        context = this;
        layoutInFlater = LayoutInflater.from(context);
        userListAdapter = new UserListAdapter();
        listView.setAdapter(userListAdapter);
        NameTextView = findViewById(R.id.NameTextView);
        AgeTextView = findViewById(R.id.AgeTextView);
        StateTextView = findViewById(R.id.StateTextView);
        userPanel = findViewById(R.id.userPanel);

    }

    public void backToList(View view) {

        UserVisibility(false);
    }

    private void UserVisibility(boolean b) {
    if(b) {
        userPanel.setVisibility(View.VISIBLE);

    }
    else {
        userPanel.setVisibility(View.GONE);
    }
    }

    private class UserListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public User getItem(int position) {
            return users.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            User currentUser = (User) getItem(position);
            convertView = layoutInFlater.inflate(R.layout.item_user, parent, false);
            TextView nameView = convertView.findViewById(R.id.NameTextView);
            TextView stateView = convertView.findViewById(R.id.StateTextView);
            nameView.setText(currentUser.getName());
            stateView.setText(currentUser.getState());
            FrameLayout StateRound = convertView.findViewById(R.id.StateRound);
            switch (currentUser.getStateSignal())
            {
                case 0:
                    StateRound.setBackgroundResource(R.drawable.back_offline);
                    break;
                case 1:
                    StateRound.setBackgroundResource(R.drawable.back_online);
                    break;
                case 2:
                    StateRound.setBackgroundResource(R.drawable.back_depa);
                    break;

            }

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InitPanel(getItem(position));
                    UserVisibility(true);
                }
            });
            return convertView;
        }
    }

    private void InitPanel(User item) {

        NameTextView.setText(item.getName());
        StateTextView.setText(item.getState());
        AgeTextView.setText(String.valueOf(item.getAge()));

    }

    public void GoToUserProfile(int position) {
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra(POSITION, position);
        startActivity(intent);
    }
}