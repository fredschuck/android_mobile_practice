package com.example.assignment_02;

import java.io.Serializable;
public class User implements Serializable{
    String name;
    int age, mood;

    public User(String name, int age, int mood){
        this.name = name;
        this.age = age;
        this.mood = mood;
    }

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public User(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }
}
