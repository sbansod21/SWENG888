package edu.psu.sweng888.practice2;

import kotlin.text.UStringsKt;

public class Course {
    private String name;
    private String description;
    private String number;
    private String credits;
    private String profName;

    public Course(String number, String name, String credits, String profName, String description) {
        this.name = name;
        this.number = number;
        this.credits = credits;
        this.profName = profName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNumber(){return number;}

    public String getProfName(){return profName;}

    public String getCredits(){return (credits + " credits");}
}
