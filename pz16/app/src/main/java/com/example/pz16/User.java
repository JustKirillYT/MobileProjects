package com.example.pz16;

public class User {
    private String Name, State;
    private int Age;

    private int StateSignal;
    public int getStateSignal() {
        return StateSignal;
    }

    public void setStateSignal(int stateSignal) {
    StateSignal = stateSignal;
    }

    public User(String name, String state, int age, int stateSignal) {
        Name = name;
        State = state;
        Age = age;
        StateSignal = stateSignal;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

