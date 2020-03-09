package com.company.enumtest;

public enum Student {

    STU1("ABKM",1),
    STU2("TONY",2),
    STU3("TOM",3);

    private String stuName;
    private int stuNum;

    Student(String stuName,int stuNum) {
        this.stuName = stuName;
        this.stuNum = stuNum;
    }
}
