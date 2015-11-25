/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inzinerija;

import java.awt.*;
import javax.swing.*;


public class Inzinerija {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Algoritmu veikimas");
        JPanel panel = new JPanel();
        frame.setResizable(false);

        panel.setLayout(new GridBagLayout());
        frame.setLayout(new GridBagLayout());

        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        JPanel pan3 = new JPanel();

        GridBagConstraints c = new GridBagConstraints();

        pan1.setBorder(BorderFactory.createTitledBorder("Algoritmo veikimas"));
        pan2.setBorder(BorderFactory.createTitledBorder("Algoritmo nustatymai"));
        pan3.setBorder(BorderFactory.createTitledBorder("Algoritmo griztamas rysys"));

        pan1.setPreferredSize(new Dimension(640, 500));
        c.fill = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        mariaus(pan1);
        panel.add(pan1, c);

        pan2.setPreferredSize(new Dimension(330, 600));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 2;
        c.gridx = 1;
        c.gridy = 0;
        nustatymai(pan2);
        panel.add(pan2, c);

        pan3.setPreferredSize(new Dimension(640, 100));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        feedback(pan3);
        panel.add(pan3, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        frame.add(panel, c);
        frame.setLocation(50, 50);
        frame.setTitle("Title");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 640));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void mariaus(JPanel panel) {
        //Mariaus kodas
    }

    private static void nustatymai(JPanel pan2) {
        pan2.setLayout(new BoxLayout(pan2, BoxLayout.PAGE_AXIS));
        JButton sound = new JButton("Sound On/Off");
        JButton run = new JButton("RUN");
        JButton Reset = new JButton("Reset");
        JLabel amount = new JLabel("Amount:");
        JSlider slideA = new JSlider(JSlider.HORIZONTAL);
        JButton generate = new JButton("Generate");
        JLabel speed = new JLabel("Speed:");
        JSlider slideS = new JSlider(JSlider.HORIZONTAL);
        String[] petStrings = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
        JComboBox algo = new JComboBox(petStrings);
        JTextArea text = new JTextArea();
        String content = "paaiskinimas";
        text.setText(content);
        text.setPreferredSize(new Dimension(20, 20));
       
        sound.setAlignmentX(Component.CENTER_ALIGNMENT);
        run.setAlignmentX(Component.CENTER_ALIGNMENT);
        Reset.setAlignmentX(Component.CENTER_ALIGNMENT);
        amount.setAlignmentX(Component.CENTER_ALIGNMENT);
        slideA.setAlignmentX(Component.CENTER_ALIGNMENT);
        generate.setAlignmentX(Component.CENTER_ALIGNMENT);
        speed.setAlignmentX(Component.CENTER_ALIGNMENT);
        slideS.setAlignmentX(Component.CENTER_ALIGNMENT);
        algo.setAlignmentX(Component.CENTER_ALIGNMENT);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);

        pan2.add(Box.createRigidArea(new Dimension(0,20)));
        pan2.add(sound);
        pan2.add(Box.createRigidArea(new Dimension(0,20)));
        pan2.add(run);
        pan2.add(Box.createRigidArea(new Dimension(0,20)));
        pan2.add(Reset);
        pan2.add(Box.createRigidArea(new Dimension(0,20)));
        pan2.add(amount);
        pan2.add(Box.createRigidArea(new Dimension(0,10)));
        pan2.add(slideA);
        pan2.add(Box.createRigidArea(new Dimension(0,30)));
        pan2.add(generate);
        pan2.add(Box.createRigidArea(new Dimension(0,20)));
        pan2.add(speed);
        pan2.add(Box.createRigidArea(new Dimension(0,10)));
        pan2.add(slideS);
        pan2.add(Box.createRigidArea(new Dimension(0,30)));
        pan2.add(algo);
        pan2.add(Box.createRigidArea(new Dimension(0,20)));
        pan2.add(text);

    }

    private static void feedback(JPanel pan3) {
        JTextArea text = new JTextArea();
        String content = "Labas, cia yra algoritmo veikimo duomenu rezultatai";
        text.setText(content);
        text.setPreferredSize(new Dimension(620, 70));
        pan3.add(text);
    }

}
