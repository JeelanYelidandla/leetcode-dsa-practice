package com.leetcode.designpatterns.corejava.structure.adaptar.patterns;

public class SchoolMain {
    public static void main(String[] args) {
        AssignmentWork aw= new AssignmentWork();
        Pen pen =  new PenAdapter();
        aw.setPen(pen);
        aw.writeAssignment("writing by red pen");

    }
}
