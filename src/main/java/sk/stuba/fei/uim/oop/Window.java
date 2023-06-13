package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Window extends Movement{
    JFrame window;
    Canvas canvas;

    JButton dom;
    JButton presun;
    JButton dalsiaFarba;
    JLabel currCol;
    int currentAct;
    Color Mycolor;
    int firstCoord;
    ArrayList<Obj> coordinates;
    public Window() {
        window = new JFrame();
        canvas = new Canvas();
        dom = new JButton("Dom");
        presun = new JButton("Presun");
        dalsiaFarba = new JButton("Dalsia Farba");
        Mycolor = Color.red;
        currCol = new JLabel("Dom");
        currCol.setForeground(Mycolor);
        currCol.setHorizontalAlignment(SwingConstants.CENTER);
        currentAct = 1;
        firstCoord = 1;
        coordinates = new ArrayList<>();
        settings();
    }

    private void settings() {
        window.setPreferredSize(new Dimension(800,750));
        window.setLayout(new BorderLayout());
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
        window.add(canvas,BorderLayout.CENTER);

        JPanel temporary = new JPanel();
        temporary.setLayout(new GridLayout(1,4));
        dom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                currentAct = 1;
                currCol.setText("Dom");
            }
        });
        temporary.add(dom,0,0);
        presun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                currentAct = 2;
                currCol.setText("Presun");
            }
        });
        temporary.add(presun,0,1);
        dalsiaFarba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(Mycolor.equals(Color.red)){
                    Mycolor = Color.green;
                } else if (Mycolor.equals(Color.green)) {
                    Mycolor = Color.blue;
                } else if (Mycolor.equals(Color.blue)) {
                    Mycolor = Color.red;
                }
                currCol.setForeground(Mycolor);
            }
        });
        temporary.add(dalsiaFarba,0,2);



        temporary.add(currCol,0,3);
        temporary.setPreferredSize(new Dimension(800,50));
        window.add(temporary,BorderLayout.SOUTH);

        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        Obj temp =new Obj();
        temp.setMyColor(Mycolor);
        temp.setStartX(mouseEvent.getX());
        temp.setStartY(mouseEvent.getY());
        coordinates.add(temp);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        super.mouseDragged(mouseEvent);
        Obj temp;
        temp = coordinates.get(coordinates.size()-1);
        temp.setEndX(mouseEvent.getX());
        temp.setEndY(mouseEvent.getY());
        canvas.setCoordinates(coordinates);
        canvas.repaint();
        window.pack();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        super.mouseReleased(mouseEvent);
        firstCoord = 1;
    }
}
