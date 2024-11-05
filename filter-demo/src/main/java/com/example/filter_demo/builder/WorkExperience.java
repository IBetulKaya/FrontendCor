package com.example.filter_demo.builder;

public class WorkExperience {

    private String company;
    private String startDate;
    private String endDate;

    public static WorkExperience create(){
        return new WorkExperience();
    }


    public WorkExperience withCompany(String company){
        this.company = company;
        return this;
    }

    public WorkExperience from (String startDate){
        this.startDate = startDate;
        return this;
    }
    public WorkExperience until (String endDate){
        this.endDate = endDate;
        return this;
    }

    public WorkExperience build(){
        return this;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "company='" + company + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
