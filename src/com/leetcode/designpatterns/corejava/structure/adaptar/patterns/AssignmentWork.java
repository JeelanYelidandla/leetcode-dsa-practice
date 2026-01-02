package com.leetcode.designpatterns.corejava.structure.adaptar.patterns;

public class AssignmentWork {
    Pen pen;

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public void writeAssignment(String write){
            pen.write(write);
    }
}
