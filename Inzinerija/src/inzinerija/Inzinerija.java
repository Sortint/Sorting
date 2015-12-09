package inzinerija;

import Algorithms.QuickSortPanel;
import Descriptions.Algo;
import Algorithms.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Inzinerija extends JFrame {

    private final long serialVersionUID = 1L;
    private SortPanel sortPanel/*, tempPanel*/;
    private JPanel panel;
    //JFrame frame;
    private  int size = 100;
    private int[] list = new int[size];
    private int sleepTime = 1;

    public static void main(String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

//    protected void createFrame() {
//        SwingWorker worker = new SwingWorker<Void, Void>() {
//
//            @Override
//            protected Void doInBackground() throws Exception {
//                Main frame = new Main();
//                frame.setVisible(true); //necessary as of 1.3
//                GridBagConstraints grid = new GridBagConstraints();
//                grid.fill = GridBagConstraints.FIRST_LINE_START;
//                grid.gridx = 0;
//                grid.gridy = 0;
//                //
//                panel.add(frame);
//                try {
//                    frame.setSelected(true);
//                } catch (java.beans.PropertyVetoException e) {
//                }
//                return null;
//            }
//
//        };
//        worker.execute();
//
//    }

    public Inzinerija() {
        int width = 640 /*/ 3*/;
        int height = 500/* / 3*/;

        setResizable(false);

        setLayout(new GridBagLayout());

        //JPanel optionsPan = new JPanel();
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints grid = new GridBagConstraints();

        // optionsPan.
        //Algoritmo atvaizdavimas
        grid.fill = GridBagConstraints.FIRST_LINE_START;
        grid.gridx = 0;
        grid.gridy = 0;

        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }
        for (int i = 0; i < list.length; i++) {
            int index = (int) (Math.random() * list.length);
            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }

        sortPanel = new ShellSortPanel(" Fuck Sort ", sleepTime, 640, 500);
        sortPanel.setPreferredSize(new Dimension(640, 500));
        repaint();

        sortPanel.setVisible(true);

        sortPanel.setList(list);

        panel.add(sortPanel, grid);

        //Options atvaizdavimas
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridheight = 2;
        grid.gridx = 1;
        grid.gridy = 0;
        //Options(optionsPan);
        panel.add(new OptionsPanel(), grid);

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

    public void beginAnimation(int[] list) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(1);
            executor.execute(sortPanel);
            executor.shutdown();
            while (!executor.isTerminated()) {
                Thread.sleep(100);
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class FeedbackPanel extends JPanel {

        public FeedbackPanel() {
            // super();
            setBorder(BorderFactory.createTitledBorder("Algoritmo griztamas rysys"));
            setPreferredSize(new Dimension(640, 100));
            JTextArea text = new JTextArea();
            String content = "Labas, cia yra algoritmo veikimo duomenu rezultatai";
            text.setText(content);
            text.setPreferredSize(new Dimension(620, 70));
            add(text);
            setLocation(0, 500);            
        }

    }

    class OptionsPanel extends JPanel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String action = ae.getActionCommand();
            if ("Run".equals(action)) {

                System.out.println("RUN");
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
                sortPanel.setList(list);
            }
        }

        public OptionsPanel() {
            setBorder(BorderFactory.createTitledBorder("Algoritmo nustatymai"));
            setPreferredSize(new Dimension(330, 600));
            Algo A = new Algo();
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            JButton sound = new JButton("Sound On/Off");
            sound.setVisible(false);
            JButton run = new JButton("Run");
            JButton reset = new JButton("Reset");
            JLabel amount = new JLabel("Amount:");
            JSlider slideA = new JSlider(JSlider.HORIZONTAL);
            JButton generate = new JButton("Generate");
            JLabel speed = new JLabel("Speed:");
            JSlider slideS = new JSlider(JSlider.HORIZONTAL);
            String[] algorithms = {A.getBubble().getPavad(), A.getHeap().getPavad(), A.getSelection().getPavad(),
                A.getMerge().getPavad(), A.getQuick().getPavad(),
                A.getCombo().getPavad(), A.getInsertion().getPavad(), A.getShell().getPavad(), A.getCoctail().getPavad()};
            JComboBox algo = new JComboBox(algorithms);
            JTextArea text = new JTextArea();
            text.setLineWrap(true);
            text.setWrapStyleWord(true);
            text.setPreferredSize(new Dimension(20, 20));

            run.addActionListener(this);
            reset.addActionListener(this);

            ActionListener cbActionListener;
            cbActionListener = (ActionEvent e) -> {
                String s = (String) algo.getSelectedItem();//get the selected item

                switch (s) {//check for a match
                    case "Bubble sort":
                        text.setText(A.getBubble().getApras());
                        break;
                    case "Heap sort":
                        text.setText(A.getHeap().getApras());
                        break;
                    case "Selection sort":
                        text.setText(A.getSelection().getApras());
                        break;
                    case "Merge sort":
                        text.setText(A.getMerge().getApras());
                        break;
                    case "Quick sort":
                        text.setText(A.getQuick().getApras());
                        break;
                    case "Combo sort":
                        text.setText(A.getCombo().getApras());
                        break;
                    case "Insertion sort":
                        text.setText(A.getInsertion().getApras());
                        break;
                    case "Shell sort":
                        text.setText(A.getShell().getApras());
                        break;
                    case "Coctail sort":
                        text.setText(A.getCoctail().getApras());
                        break;
                    default:
                        text.setText("aaaaaaaaaaaaa");
                        break;
                }
            }; //add actionlistner to listen for change

            algo.addActionListener(cbActionListener);

            //duomenu kiekio slideBar action listeneris. duomenys kinta nuo 0 iki 100
            ChangeListener a = new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent ce) {
                    JSlider source = (JSlider) ce.getSource();
                    if (!source.getValueIsAdjusting()) {
                        int kiekis = (int) source.getValue();
                        System.out.println("slideA (duomenu kiekio) reiksme: " + kiekis);
                    }
                }

            };
            ChangeListener s = new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent ce) {
                    JSlider source = (JSlider) ce.getSource();
                    if (!source.getValueIsAdjusting()) {
                        int kiekis = (int) source.getValue();
                        System.out.println("slideS (rikiavimo greicio) reiksme: " + kiekis);
                    }
                }

            };

            slideA.addChangeListener(a);
            slideS.addChangeListener(s);

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

            add(Box.createRigidArea(new Dimension(0, 20)));
            add(sound);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(run);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(reset);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(amount);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(slideA);
            add(Box.createRigidArea(new Dimension(0, 30)));
            add(generate);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(speed);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(slideS);
            add(Box.createRigidArea(new Dimension(0, 30)));
            add(algo);
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(text);

            Hashtable labelTable = new Hashtable();
        labelTable.put(0, new JLabel("0"));
        labelTable.put(100, new JLabel("300"));
        slideA.setLabelTable(labelTable);

        slideA.setPaintLabels(true);
        add(slideA);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(generate);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(speed);
        add(Box.createRigidArea(new Dimension(0, 10)));
        Hashtable labelTable1 = new Hashtable();
        labelTable1.put(0, new JLabel("Slow"));
        labelTable1.put(100, new JLabel("Fast"));
        slideS.setLabelTable(labelTable1);
        slideS.setPaintLabels(true);
        add(slideS);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(algo);
        add(Box.createRigidArea(new Dimension(0, 20)));

        JScrollPane sp = new JScrollPane(text);
        sp.setPreferredSize(new Dimension(100, 200));
        add(sp);
            
        }
    }

}
