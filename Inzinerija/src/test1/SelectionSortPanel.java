/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

/**
 *
 * @author marius940716
 */
//package net.bohush.sorting;

import java.awt.Color;
import java.awt.Graphics;

public class SelectionSortPanel extends SortPanel {
	private static final long serialVersionUID = 1L;
	private int blueColumn = -1;
	private int redColumn = -1;
	private int greenColumn = -1;
	
	public SelectionSortPanel(String name, int sleepTime, int width, int height) {
		super(name, sleepTime, width, height);
	}

	@Override
	public void reset() {
		blueColumn = -1;
		redColumn = -1;
		greenColumn = -1;		
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < list.length - 1; i++) {
				int currentMinIndex = i;
				blueColumn = currentMinIndex;
				for (int j = i + 1; j < list.length; j++) {
					redColumn = j;
					repaint();
					Thread.sleep(4 * sleepTime);
					if (list[currentMinIndex] > list[j]) {
						currentMinIndex = j;
						blueColumn = currentMinIndex;
						repaint();
					}
				}

				if (currentMinIndex != i) {
					int tmp = list[currentMinIndex];
					list[currentMinIndex] = list[i];
					list[i] = tmp;
					repaint();
					Thread.sleep(4 * sleepTime);
				}
				greenColumn++;
				repaint();
			}
			greenColumn++;
			blueColumn = -1;
			redColumn = -1;
		} catch (InterruptedException e) {
		}
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int columnWidth = (getWidth() - 4 * BORDER_WIDTH) / size;
		int columnHeight = (getHeight() - 4 * BORDER_WIDTH) / size;
		for (int i = (greenColumn == -1 ? 0 : greenColumn); i < list.length; i++) {
			g.setColor(Color.WHITE);
			g.fillRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
			g.setColor(Color.BLACK);
			g.drawRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);			
		}
		for (int i = 0; i <= greenColumn; i++) {
			g.setColor(Color.GREEN);
			g.fillRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
			g.setColor(Color.BLACK);
			g.drawRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);			
		}
		if(blueColumn != -1) {
			g.setColor(Color.BLUE);
			g.fillRect(2 * BORDER_WIDTH + columnWidth * blueColumn, getHeight() - list[blueColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blueColumn] * columnHeight);
			g.setColor(Color.BLACK);
			g.drawRect(2 * BORDER_WIDTH + columnWidth * blueColumn, getHeight() - list[blueColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blueColumn] * columnHeight);
		}
		if(redColumn != -1) {
			g.setColor(Color.RED);
			g.fillRect(2 * BORDER_WIDTH + columnWidth * redColumn, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
			g.setColor(Color.BLACK);
			g.drawRect(2 * BORDER_WIDTH + columnWidth * redColumn, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
		}

	}

}
