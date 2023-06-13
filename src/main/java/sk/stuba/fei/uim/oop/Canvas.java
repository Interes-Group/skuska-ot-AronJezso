package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private ArrayList<Obj> coordinates;

    public ArrayList<Obj> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Obj> coordinates) {
        this.coordinates = coordinates;
    }

    public Canvas() {
        coordinates = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillRect(0,0,800,700);
        for(Obj t:this.coordinates){
            t.paint(g);
        }
    }
}
