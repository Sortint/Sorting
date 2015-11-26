/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inzinerija;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;

public class Main extends JApplet {

    private static final long serialVersionUID = 1L;
    private static SortPanel sortPanel;
    private static final int size = 100;
    private static int sleepTime = 2;
    private static String animationName = "";

    public Main() {
        //setLayout(new GridLayout(1, 1, 0, 0));
        
        SortPanelsHolder sortPanelHolder = new SortPanelsHolder();
        sortPanelHolder.setLayout(new GridLayout(0, 3, 0, 0));
        sortPanelHolder.setBackground(Color.BLACK);
        sortPanelHolder.setForeground(Color.BLACK);
       // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 620 /*/ 3*/;
        int height = 500/* / 3*/;

        sortPanel = (new MergeSortPanel(" Merge Sort ", sleepTime, width, height));

        sortPanel.setVisible(false);
        sortPanelHolder.add(sortPanel);

        add(sortPanelHolder);
        createAndShowGUI();

    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Algoritmu veikimas");
        JPanel panel = new JPanel();
        frame.setResizable(false);

        panel.setLayout(new GridBagLayout());
        frame.setLayout(new GridBagLayout());

        //JPanel algorithmPan = new JPanel();
        JPanel optionsPan = new JPanel();
        JPanel feedBackPan = new JPanel();
      //  Main main = new Main(algorithmPan);

       // frame.add(main);
        GridBagConstraints grid = new GridBagConstraints();

        //algorithmPan.setBorder(BorderFactory.createTitledBorder("Algoritmo veikimas"));
        optionsPan.setBorder(BorderFactory.createTitledBorder("Algoritmo nustatymai"));
        feedBackPan.setBorder(BorderFactory.createTitledBorder("Algoritmo griztamas rysys"));

        //Algoritmo atvaizdavimas
        // algorithmPan.setPreferredSize(new Dimension(640, 500));
        grid.fill = GridBagConstraints.FIRST_LINE_START;
        grid.gridx = 0;
        grid.gridy = 0;
       // Mariaus(sortPanel);
        panel.add(sortPanel, grid);

        //Options atvaizdavimas
        optionsPan.setPreferredSize(new Dimension(330, 600));
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridheight = 2;
        grid.gridx = 1;
        grid.gridy = 0;
        Options(optionsPan);
        panel.add(optionsPan, grid);

        //Feedback atvaizdavimas
        feedBackPan.setPreferredSize(new Dimension(640, 100));
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridx = 0;
        grid.gridy = 1;
        Feedback(feedBackPan);
        panel.add(feedBackPan, grid);

        //kita
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridx = 2;
        grid.gridy = 2;
        frame.add(panel, grid);
        frame.setLocation(50, 50);
        frame.setTitle("SortAlg");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 640));
        frame.pack();
        frame.setVisible(true);

        int[] list = new int[size];

        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }
        for (int i = 0; i < list.length; i++) {
            int index = (int) (Math.random() * list.length);
            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }
        beginAnimation("Random", list);
    }

    public static void main(String[] args) {
        Main main = new Main();

    }

    private void Mariaus(JPanel sortPanel) {

        SortPanelsHolder sortPanelHolder = new SortPanelsHolder();
        sortPanelHolder.setLayout(new GridLayout(0, 3, 0, 0));
        sortPanelHolder.setBackground(Color.BLACK);
        sortPanelHolder.setForeground(Color.BLACK);
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 620 /*/ 3*/;
        int height = 500/* / 3*/;

        sortPanel = (new MergeSortPanel(" Merge Sort ", sleepTime, width, height));

        sortPanel.setVisible(false);
        sortPanelHolder.add(sortPanel);

        add(sortPanelHolder);

    }

    static class SortPanelsHolder extends JPanel {

        private static final long serialVersionUID = 1L;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            Font animationNameFont = new Font(Font.MONOSPACED, Font.BOLD, 100);
            FontMetrics animationNameFontFontMetrix = getFontMetrics(animationNameFont);
            g.setFont(animationNameFont);
            int x = (getWidth() - animationNameFontFontMetrix.stringWidth(animationName)) / 2;
            int y = (getHeight() - animationNameFontFontMetrix.getLeading()) / 2;
            g.drawString(animationName, x, y);
        }
    }

    public static void beginAnimation(String animationName, int[] list) {
        try {

            //Main.animationName = animationName;
           // sortPanel.repaint();
            //Thread.sleep(2000);
            Main.animationName = "";
            sortPanel.repaint();
            sortPanel.setList(list);
            sortPanel.setVisible(true);
            Thread.sleep(1000);
            ExecutorService executor = Executors.newFixedThreadPool(1/*sortPanel.size()*/);
            executor.execute(sortPanel);
            executor.shutdown();
            while (!executor.isTerminated()) {
                Thread.sleep(100);
            }
            Thread.sleep(1000);
            //sortPanel.setVisible(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void Options(JPanel pan2) {
        pan2.setLayout(new BoxLayout(pan2, BoxLayout.PAGE_AXIS));
        JButton sound = new JButton("Sound On/Off");
        sound.setVisible(false);
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

        pan2.add(Box.createRigidArea(new Dimension(0, 20)));
        pan2.add(sound);
        pan2.add(Box.createRigidArea(new Dimension(0, 20)));
        pan2.add(run);
        pan2.add(Box.createRigidArea(new Dimension(0, 20)));
        pan2.add(Reset);
        pan2.add(Box.createRigidArea(new Dimension(0, 20)));
        pan2.add(amount);
        pan2.add(Box.createRigidArea(new Dimension(0, 10)));
        pan2.add(slideA);
        pan2.add(Box.createRigidArea(new Dimension(0, 30)));
        pan2.add(generate);
        pan2.add(Box.createRigidArea(new Dimension(0, 20)));
        pan2.add(speed);
        pan2.add(Box.createRigidArea(new Dimension(0, 10)));
        pan2.add(slideS);
        pan2.add(Box.createRigidArea(new Dimension(0, 30)));
        pan2.add(algo);
        pan2.add(Box.createRigidArea(new Dimension(0, 20)));
        pan2.add(text);

    }

    private static void Feedback(JPanel pan3) {
        JTextArea text = new JTextArea();
        String content = "Labas, cia yra algoritmo veikimo duomenu rezultatai";
        text.setText(content);
        text.setPreferredSize(new Dimension(620, 70));
        pan3.add(text);
    }
}
