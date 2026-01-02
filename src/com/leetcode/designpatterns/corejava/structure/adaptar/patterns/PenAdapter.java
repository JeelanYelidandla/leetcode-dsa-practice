package com.leetcode.designpatterns.corejava.structure.adaptar.patterns;

public class PenAdapter implements  Pen{
    PilotPen pilotPen = new PilotPen();
    @Override
    public void write(String str) {
        pilotPen.mark(str);
    }
}
