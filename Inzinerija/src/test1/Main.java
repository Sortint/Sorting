
package test1;

/**
 *
 * @author marius940716
 */


import javax.swing.*;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Visualization and Comparison of Sorting Algorithms

public class Main extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private  SortPanel sortPanel;
	private static final int size = 100;
	private final int sleepTime = 1;


	public Main() {
            super();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setBorder(null);

        setSize(640,500);

        setLocation(0, 0);
                
		int width = 640 /*/ 3*/;
		int height = 500/* / 3*/;
                sortPanel= (new MergeSortPanel(" Merge Sort ", sleepTime, width, height));
		sortPanel.setLayout(new  GridLayout(0, 3, 0, 0));
		sortPanel.setBackground(Color.BLACK);
		sortPanel.setForeground(Color.BLACK);
		sortPanel.setVisible(false);	
		add(sortPanel);

                setSize(new Dimension(640, 500));

		
	
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

	
	public void beginAnimation(String animationName, int[] list) {
		try {
			
			sortPanel.setList(list);
			sortPanel.setVisible(true);
			ExecutorService executor = Executors.newFixedThreadPool(1/*sortPanel.size()*/);
			executor.execute(sortPanel);
			executor.shutdown();
			while(!executor.isTerminated()) {
				Thread.sleep(100);
			}	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args ) {
            
            
		Main main = new Main();
		
	}
}