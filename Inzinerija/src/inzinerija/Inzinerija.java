package inzinerija;

import Algorithms.SortPanel;
import Algorithms.SelectionSortPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import test1.Main;

public class Inzinerija extends JFrame  implements ActionListener {

    private final long serialVersionUID = 1L;
    private  SortPanel sortPanel/*, tempPanel*/;
    private JPanel panel;
    //JFrame frame;
    private final int size = 100;
    private final int[] list = new int[size];
    private static  int sleepTime = 1;
    
    //JDesktopPane desktop;
    
    //+++
     public static void main(String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if ("Run".equals(action)) {
            
            System.out.println("RUN");
            //createFrame();
            SwingWorker worker = new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() throws Exception {
                    beginAnimation(list);
                    return null;
                }
                
            };
            worker.execute();
            

            System.out.println("end");

        }
        if ("Generate".equals(action)) {
            System.out.println("generate");
            for (int i = 0; i < list.length; i++) {
                list[i] = i + 1;
            }
            for (int i = 0; i < list.length; i++) {
                int index = (int) (Math.random() * list.length);
                int temp = list[i];
                list[i] = list[index];
                list[index] = temp;
            }
        }
    }

    protected void createFrame() {
        SwingWorker worker = new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() throws Exception {
                Main frame = new Main();
                frame.setVisible(true); //necessary as of 1.3
                  GridBagConstraints grid = new GridBagConstraints();
                grid.fill = GridBagConstraints.FIRST_LINE_START;
             grid.gridx = 0;
        grid.gridy = 0;
        //
                panel.add(frame);
                try {
                    frame.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
                return null;
            }

        };
        worker.execute();

    }


    public Inzinerija()  {
        //super("Inzinerija");
        
        int width = 640 /*/ 3*/;
        int height = 500/* / 3*/;
        
        //desktop = new JDesktopPane(); //a specialized layered pane

        //tempPanel = (new SelectionSortPanel(" Selection Sort ", sleepTime, width, height));
       // tempPanel.setPreferredSize(new Dimension(width, height));
        //tempPanel.setVisible(false);

        //frame = new JFrame("Algoritmu veikimas");
        //JPanel panel = new JPanel();
        setResizable(false);

        setLayout(new GridBagLayout());
        setLayout(new GridBagLayout());

        JPanel optionsPan = new JPanel();
        
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints grid = new GridBagConstraints();

        optionsPan.setBorder(BorderFactory.createTitledBorder("Algoritmo nustatymai"));
        //feedBackPan.setBorder(BorderFactory.createTitledBorder("Algoritmo griztamas rysys"));

        //Algoritmo atvaizdavimas
        grid.fill = GridBagConstraints.FIRST_LINE_START;
        grid.gridx = 0;
        grid.gridy = 0;
        //createFrame();
        for (int i = 0; i < list.length; i++) {
                list[i] = i + 1;
            }
            for (int i = 0; i < list.length; i++) {
                int index = (int) (Math.random() * list.length);
                int temp = list[i];
                list[i] = list[index];
                list[index] = temp;
            }

            sortPanel = (new SelectionSortPanel(" Selection Sort ", sleepTime, 640, 500));
            sortPanel.setPreferredSize(new Dimension(640, 500));
            repaint();

            sortPanel.setVisible(true);

            sortPanel.setList(list);
        
        panel.add(sortPanel, grid);

       // initialPaint(tempPanel);

        //Options atvaizdavimas
        optionsPan.setPreferredSize(new Dimension(330, 600));
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridheight = 2;
        grid.gridx = 1;
        grid.gridy = 0;
        Options(optionsPan);
        panel.add(optionsPan, grid);

        //Feedback atvaizdavimas
        
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridx = 0;
        grid.gridy = 1;
        panel.add(new FeedbackPanel(), grid);

        //kita
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridx = 2;
        grid.gridy = 2;
        add(panel, grid);
        setLocation(50, 50);
        setTitle("SortAlg");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 640));
        pack();
        //createFrame();
       // desktop.add(panel);
        setContentPane(panel);//

    }

   

    public static void createAndShowGUI() {
        
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(false);
        
        //Create and set up the window.
        Inzinerija frame = new Inzinerija();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        
        
        
    }

    public void initialPaint(SortPanel tempPanel) {
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }
        for (int i = 0; i < list.length; i++) {
            int index = (int) (Math.random() * list.length);
            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }
        tempPanel.setList(list);
        tempPanel.setVisible(true);

    }

    public void beginAnimation(int[] list) {
        try {


//            for (int i = 0; i < list.length; i++) {
//                list[i] = i + 1;
//            }
//            for (int i = 0; i < list.length; i++) {
//                int index = (int) (Math.random() * list.length);
//                int temp = list[i];
//                list[i] = list[index];
//                list[index] = temp;
//            }
//
//            sortPanel = (new SelectionSortPanel(" Selection Sort ", sleepTime, 640, 500));
//            sortPanel.setPreferredSize(new Dimension(640, 500));
//            repaint();
//
//            sortPanel.setVisible(true);
//
//            sortPanel.setList(list);
//
//            Thread.sleep(1000);

            ExecutorService executor = Executors.newFixedThreadPool(1);
            executor.execute(sortPanel);
            executor.shutdown();
            while (!executor.isTerminated()) {
                Thread.sleep(100);
            }

            // sortPanel.run();
            Thread.sleep(1000);
            //sortPanel.setVisible(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void Options(JPanel pan2) {
        pan2.setLayout(new BoxLayout(pan2, BoxLayout.PAGE_AXIS));

        JButton sound = new JButton("Sound On/Off");
        sound.setVisible(false);

        JButton run = new JButton("Run");

        JButton reset = new JButton("Reset");
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

        run.addActionListener(this);
        reset.addActionListener(this);

        sound.setAlignmentX(Component.CENTER_ALIGNMENT);
        run.setAlignmentX(Component.CENTER_ALIGNMENT);
        reset.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        pan2.add(reset);
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

    class FeedbackPanel extends JPanel {
        
        public FeedbackPanel(){
           // super();
            setBorder(BorderFactory.createTitledBorder("Algoritmo griztamas rysys"));
            setPreferredSize(new Dimension(640, 100));
            JTextArea text = new JTextArea();
            String content = "Labas, cia yra algoritmo veikimo duomenu rezultatai";
            text.setText(content);
            text.setPreferredSize(new Dimension(620, 70));
            add(text);
            setLocation(0, 500);
            //panel.add(this, grid);            
        }
        
        
    }
    

}
