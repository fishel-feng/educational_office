package com.fx.entity;

public class TeacherWithCollege extends Teacher {

    private College college;

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
