package com.example.filter_demo.builder;

import java.sql.SQLOutput;

public class App {
    public static void main(String[] args) {
        Cv cv = Cv.create("John", "john@gmail.com")
                .addEducation("Kindergarten")
                .addEducation("Primary School")
                .addEducation("High School")
                .addSkill("C#")
                .addSkill("CSS")
                .addSkill("SQL")
                .addSkill("Devops")
                .addSkill("Junit")
                .addWorkExperience( WorkExperience.create()
                        .withCompany("UWV")
                        .from("jan 2012")
                        .until("dec 2019")
                        .build())
                .addWorkExperience(WorkExperience.create()
                        .withCompany("LIDL")
                        .from("dec 2019")
                        .until("feb 2020")
                        .build())
                .addWorkExperience(WorkExperience.create()
                        .withCompany("CAPGEMINI")
                        .from("feb 2020")
                        .until("present")
                        .build())


                .build();
        System.out.println(cv);
    }

}
