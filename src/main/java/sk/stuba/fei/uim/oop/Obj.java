package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Obj extends JPanel {
    private int StartX;
    private int StartY;
    private int EndX;
    private int EndY;

    public int getStartX() {
        return StartX;
    }

    public void setStartX(int startX) {
        StartX = startX;
    }

    public int getStartY() {
        return StartY;
    }

    public void setStartY(int startY) {
        StartY = startY;
    }

    public int getEndX() {
        return EndX;
    }

    public void setEndX(int endX) {
        EndX = endX;
    }

    public int getEndY() {
        return EndY;
    }

    public void setEndY(int endY) {
        EndY = endY;
    }
    Color MyColor;

    public void setMyColor(Color myColor) {
        MyColor = myColor;
    }


    public Obj() {
    }

    @Override
    public boolean contains(int xM, int yM) {
        int x = Math.min(StartX,EndX);
        int y = Math.min(StartY,EndY);
        int width = Math.abs(StartX-EndX);
        int height = Math.abs(StartY-EndY);
        int[] xPoints = {x+width/2,x+width*3/4,x+width*3/4,x+width*1/4,x+width*1/4};
        int[] yPoints = {y,y+height/2,y+height,y+height,y+height/2};
        return this.getBounds().contains(xM,yM);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        int x = Math.min(StartX,EndX);
        int y = Math.min(StartY,EndY);
        int width = Math.abs(StartX-EndX);
        int height = Math.abs(StartY-EndY);
        g.setColor(MyColor);
        int[] xPoints = {x+width/2,x+width*3/4,x+width*3/4,x+width*1/4,x+width*1/4};
        int[] yPoints = {y,y+height/2,y+height,y+height,y+height/2};
        g.fillPolygon(xPoints,yPoints,5);
    }
}
