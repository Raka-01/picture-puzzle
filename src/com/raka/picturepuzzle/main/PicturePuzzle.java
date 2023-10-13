package com.raka.picturepuzzle.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PicturePuzzle {

	private JFrame frame; 
	private JButton tileOne, tileTwo, tileThree, tileFour, tileFive, tileSix, tileSeven, tileEight, tileNine;
	private Icon iconImage, iconOne, iconTwo, iconThree, iconFour, iconFive, iconSix, iconSeven, iconEight, iconNine;
	

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
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel headline = new JPanel();
		frame.getContentPane().add(headline, BorderLayout.NORTH);
		
		JLabel headLabel = new JLabel("Solve The Puzzle");
		headline.add(headLabel);
		
		JButton previewImage = new JButton("Preview");
		previewImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, iconImage, "PUzzle Preview", JOptionPane.PLAIN_MESSAGE);
			}
		});
		headline.add(previewImage);
		
		JPanel puzzlePanel = new JPanel();
		frame.getContentPane().add(puzzlePanel, BorderLayout.CENTER);
		
		JPanel tilesPanel = new JPanel();
		GroupLayout gl_puzzlePanel = new GroupLayout(puzzlePanel);
		gl_puzzlePanel.setHorizontalGroup(
			gl_puzzlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_puzzlePanel.createSequentialGroup()
					.addGap(72)
					.addComponent(tilesPanel, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		gl_puzzlePanel.setVerticalGroup(
			gl_puzzlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_puzzlePanel.createSequentialGroup()
					.addGap(53)
					.addComponent(tilesPanel, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(129, Short.MAX_VALUE))
		);
		
		initializeIcon();
		tilesPanel.setLayout(null);
		
		tileOne = new JButton();
		tileOne.setBounds(0, 0, 99, 99);
		tileOne.setIcon(iconOne);
		tilesPanel.add(tileOne);
		
		tileTwo = new JButton();
		tileTwo.setBounds(100, 0, 99, 99);
		tileTwo.setIcon(iconTwo);
		tilesPanel.add(tileTwo);
		
		tileThree = new JButton();
		tileThree.setBounds(199, 0, 99, 99);
		tileThree.setIcon(iconThree);
		tilesPanel.add(tileThree);
		
		tileFour = new JButton();
		tileFour.setBounds(0, 100, 99, 99);
		tileFour.setIcon(iconFour);
		tilesPanel.add(tileFour);
		
		tileFive = new JButton();
		tileFive.setBounds(100, 100, 99, 99);
		tileFive.setIcon(iconFive);
		tilesPanel.add(tileFive);
		
		tileSix = new JButton();
		tileSix.setBounds(199, 100, 99, 99);
		tileSix.setIcon(iconSix);
		tilesPanel.add(tileSix);
		
		tileSeven = new JButton();
		tileSeven.setBounds(0, 199, 99, 99);
		tileSeven.setIcon(iconSeven);
		tilesPanel.add(tileSeven);
		
		tileEight = new JButton();
		tileEight.setBounds(100, 199, 99, 99);
		tileEight.setIcon(iconEight);
		tilesPanel.add(tileEight);
		
		tileNine = new JButton();
		tileNine.setBounds(199, 199, 99, 99);
		tileNine.setIcon(iconNine);
		tilesPanel.add(tileNine);
		
		puzzlePanel.setLayout(gl_puzzlePanel);
	}
	
	private void initializeIcon() {
		iconImage = new ImageIcon("./resources/images/puzzle-pic.jpg");
		iconOne = new ImageIcon("./resources/images/tile1.jpg");
		iconTwo = new ImageIcon("./resources/images/tile2.jpg");
		iconThree = new ImageIcon("./resources/images/tile3.jpg");
		iconFour = new ImageIcon("./resources/images/tile4.jpg");
		iconFive = new ImageIcon("./resources/images/tile5.jpg");
		iconSix = new ImageIcon("./resources/images/tile6.jpg");
		iconSeven = new ImageIcon("./resources/images/tile7.jpg");
		iconEight = new ImageIcon("./resources/images/tile8.jpg");
		iconNine = new ImageIcon("./resources/images/tile9.jpg");
	}
}
