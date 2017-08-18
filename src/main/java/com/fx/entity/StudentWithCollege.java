package com.fx.entity;

public class StudentWithCollege extends Student{

    private College college;

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
