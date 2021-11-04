package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JPanel{

    int [] mass = new int[188];
    static int j;

    Main(){
        JFrame fr = new JFrame("InsertionSort");
        fr.add(this);
        fr.setBounds(0,0,1920,1080);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setVisible(true);
        for (int i = 0; i < mass.length; i++)
            mass[i] =  new Random().nextInt(255);
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.insertionSort();

    }

    public void insertionSort(){
        int current;
        for (int i = 0; i < mass.length; i++) {
            current = mass[i];
            int j = i;
            while(j > 0 && mass[j - 1] > current){
                mass[j] = mass[j - 1];
                j--;
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
            mass[j] = current;
        }
    }

    public void paintComponent( Graphics g ){
        super.paintComponent(g);
        for (int i = 0; i < mass.length; i++){
            g.setColor(new Color(mass[i], 0, 255 - mass[i]));
            if (i == j){
                g.setColor(Color.BLACK);
                g.fillRect(i * 10 + 10,1000 - mass[i] * 4, 10, mass[i] * 4);
            }
            g.fillRect(i * 10 + 10,1000 - mass[i] * 4, 10, mass[i] * 4);
        }
    }
}