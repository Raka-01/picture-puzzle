package com.raka.picturepuzzle.main;

import javax.swing.JFrame;

public class PicturePuzzle {

	private JFrame frame; 
	

	/**
	 * Create the application.
	 */
	public PicturePuzzle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
