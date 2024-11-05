package com.example.filter_demo.builder;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String photo;
    private List<String> skills = new ArrayList<>();
    private String name;
    private int age;
    private String email;
    private List<String> education = new ArrayList<>();
    private List<WorkExperience> workExperience= new ArrayList<>();

    public Cv(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static Cv create(String name, String email){
        return new Cv(name, email);

    }
    public Cv withPhoto (String photo){
        this.photo = photo;
        return this;
    }
    public Cv withAge (int age){
        this.age = age;
        return this;
    }
    public Cv addSkill(String skill){
        skills.add(skill);
        return this;
    }
    public Cv addEducation(String education){
        this.education.add(education);
        return this;
    }
    public Cv addWorkExperience(WorkExperience workExperience){
        this.workExperience.add(workExperience);
        return this;
    }
    public Cv build(){
        return this;
    }


    @Override
    public String toString() {
        return "Cv{" +
                "photo='" + photo + '\'' +
                ", skills=" + skills +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", education=" + education +
                ", workExperience=" + workExperience +
                '}';
    }
}
