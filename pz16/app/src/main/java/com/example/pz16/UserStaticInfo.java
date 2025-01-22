package com.example.pz16;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UserStaticInfo {
    public final static String POSITION = "position";
    public static List<User> users = new ArrayList<>();
    public UserStaticInfo() {
        if(users.size() == 0)
            AddUsersIntList();
    }
    private void AddUsersIntList() {
        users.add(new User("Иван", "Болеет",19, 0));
        users.add(new User("Кирилл", "Влюблен",23,1));
        users.add(new User("Виолетта", "Красивая",19,2));
    }
}
