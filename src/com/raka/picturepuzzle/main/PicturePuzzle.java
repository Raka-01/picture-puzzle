package com.raka.picturepuzzle.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PicturePuzzle implements ActionListener {

	private JFrame frame;
	private JButton tiles[];
	private Icon iconImage, iconStar, iconOne, iconTwo, iconThree, iconFour, iconFive, iconSix, iconSeven, iconEight, iconNine;
	private JButton instruction;
	private List<Icon> icons;
	

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
		headline.setBackground(Color.CYAN);
		frame.getContentPane().add(headline, BorderLayout.NORTH);
		
		JButton restart = new JButton("Restart");
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.shuffle(icons);
				
				for(int i = 0; i < tiles.length; i++) {
					tiles[i].setIcon(icons.get(i));
				}
			}
		});
		headline.add(restart);
		
		JButton previewImage = new JButton("Preview");
		previewImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, iconImage, "Puzzle Preview", JOptionPane.PLAIN_MESSAGE);
			}
		});
		headline.add(previewImage);
		
		instruction = new JButton("Instructions");
		instruction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Icon rulesIcon = new ImageIcon("./resources/rules/rules.jpg");
				JOptionPane.showMessageDialog(null, rulesIcon, "Puzzle Instructions", JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		headline.add(instruction);
		
		JPanel puzzlePanel = new JPanel();
		puzzlePanel.setBackground(Color.cyan);
		frame.getContentPane().add(puzzlePanel, BorderLayout.CENTER);
		
		JPanel tilesPanel = new JPanel();
		
		JLabel headLabel = new JLabel("SOLVE THE PUZZLE");
		GroupLayout gl_puzzlePanel = new GroupLayout(puzzlePanel);
		gl_puzzlePanel.setHorizontalGroup(
			gl_puzzlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_puzzlePanel.createSequentialGroup()
					.addGroup(gl_puzzlePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_puzzlePanel.createSequentialGroup()
							.addGap(188)
							.addComponent(headLabel))
						.addGroup(gl_puzzlePanel.createSequentialGroup()
							.addGap(90)
							.addComponent(tilesPanel, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		gl_puzzlePanel.setVerticalGroup(
			gl_puzzlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_puzzlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(headLabel)
					.addGap(37)
					.addComponent(tilesPanel, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		puzzlePanel.setLayout(gl_puzzlePanel);
		
		initializeIcon();
		tilesPanel.setLayout(null);
		
		icons = new ArrayList<Icon>();
		icons.add(iconOne);
		icons.add(iconTwo);
		icons.add(iconThree);
		icons.add(iconFour);
		icons.add(iconFive);
		icons.add(iconSix);
		icons.add(iconSeven);
		icons.add(iconEight);
		icons.add(iconStar);
		
		Collections.shuffle(icons);
		
		tiles = new JButton[icons.size()];
		for(int i = 0; i < tiles.length; i++) {
			tiles[i] = new JButton();
			tiles[i].setBounds(((i%3)*100), ((i/3)*100), 99, 99);
			tiles[i].addActionListener(this);
			tiles[i].setIcon(icons.get(i));
			tilesPanel.add(tiles[i]);
		}
		
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
		iconStar = new ImageIcon("./resources/images/star.jpg");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tiles[0]) {
			Icon tempIcon = tiles[0].getIcon();
			if(tiles[1].getIcon() == iconStar) {
				tiles[0].setIcon(iconStar);
				tiles[1].setIcon(tempIcon);
			}
			if(tiles[3].getIcon() == iconStar) {
				tiles[0].setIcon(iconStar);
				tiles[3].setIcon(tempIcon);
			}
		}
		else if(e.getSource() == tiles[1]) {
			Icon tempIcon = tiles[1].getIcon();
			if(tiles[0].getIcon() == iconStar) {
				tiles[1].setIcon(iconStar);
				tiles[0].setIcon(tempIcon);
			}
			if(tiles[2].getIcon() == iconStar) {
				tiles[1].setIcon(iconStar);
				tiles[2].setIcon(tempIcon);
			}
			if(tiles[4].getIcon() == iconStar) {
				tiles[1].setIcon(iconStar);
				tiles[4].setIcon(tempIcon);
			}
		}
		else if(e.getSource() == tiles[2]) {
			Icon tempIcon = tiles[2].getIcon();
			if(tiles[1].getIcon() == iconStar) {
				tiles[2].setIcon(iconStar);
				tiles[1].setIcon(tempIcon);
			}
			if(tiles[5].getIcon() == iconStar) {
				tiles[2].setIcon(iconStar);
				tiles[5].setIcon(tempIcon);
			}
		}
		else if(e.getSource() == tiles[3]) {
			Icon tempIcon = tiles[3].getIcon();
			if(tiles[0].getIcon() == iconStar) {
				tiles[3].setIcon(iconStar);
				tiles[0].setIcon(tempIcon);
			}
			if(tiles[4].getIcon() == iconStar) {
				tiles[3].setIcon(iconStar);
				tiles[4].setIcon(tempIcon);
			}
			if(tiles[6].getIcon() == iconStar) {
				tiles[3].setIcon(iconStar);
				tiles[6].setIcon(tempIcon);
			}
		}
		else if(e.getSource() == tiles[4]) {
			Icon tempIcon = tiles[4].getIcon();
			if(tiles[1].getIcon() == iconStar) {
				tiles[4].setIcon(iconStar);
				tiles[1].setIcon(tempIcon);
			}
			if(tiles[3].getIcon() == iconStar) {
				tiles[4].setIcon(iconStar);
				tiles[3].setIcon(tempIcon);
			}
			if(tiles[5].getIcon() == iconStar) {
				tiles[4].setIcon(iconStar);
				tiles[5].setIcon(tempIcon);
			}
			if(tiles[7].getIcon() == iconStar) {
				tiles[4].setIcon(iconStar);
				tiles[7].setIcon(tempIcon);
			}
		}
		else if(e.getSource() == tiles[5]) {
			Icon tempIcon = tiles[5].getIcon();
			if(tiles[2].getIcon() == iconStar) {
				tiles[5].setIcon(iconStar);
				tiles[2].setIcon(tempIcon);
			}
			if(tiles[4].getIcon() == iconStar) {
				tiles[5].setIcon(iconStar);
				tiles[4].setIcon(tempIcon);
			}
			if(tiles[8].getIcon() == iconStar) {
				tiles[5].setIcon(iconStar);
				tiles[8].setIcon(tempIcon);
			}
		}
		else if(e.getSource() == tiles[6]) {
			Icon tempIcon = tiles[6].getIcon();
			if(tiles[3].getIcon() == iconStar) {
				tiles[6].setIcon(iconStar);
				tiles[3].setIcon(tempIcon);
			}
			if(tiles[7].getIcon() == iconStar) {
				tiles[6].setIcon(iconStar);
				tiles[7].setIcon(tempIcon);
			}
		}
		else if(e.getSource() == tiles[7]) {
			Icon tempIcon = tiles[7].getIcon();
			if(tiles[4].getIcon() == iconStar) {
				tiles[7].setIcon(iconStar);
				tiles[4].setIcon(tempIcon);
			}
			if(tiles[6].getIcon() == iconStar) {
				tiles[7].setIcon(iconStar);
				tiles[6].setIcon(tempIcon);
			}
			if(tiles[8].getIcon() == iconStar) {
				tiles[7].setIcon(iconStar);
				tiles[8].setIcon(tempIcon);
			}
		}
		else if(e.getSource() == tiles[8]) {
			Icon tempIcon = tiles[8].getIcon();
			if(tiles[5].getIcon() == iconStar) {
				tiles[8].setIcon(iconStar);
				tiles[5].setIcon(tempIcon);
				checkPuzzleCompletion();
			}
			if(tiles[7].getIcon() == iconStar) {
				tiles[8].setIcon(iconStar);
				tiles[7].setIcon(tempIcon);
				checkPuzzleCompletion();
			}
		}
		
	}

	private void checkPuzzleCompletion() {
		if(tiles[0].getIcon() == iconOne &&
				tiles[1].getIcon() == iconTwo &&
				tiles[2].getIcon() == iconThree &&
				tiles[3].getIcon() == iconFour &&
				tiles[4].getIcon() == iconFive &&
				tiles[5].getIcon() == iconSix &&
				tiles[6].getIcon() == iconSeven &&
				tiles[7].getIcon() == iconEight) {
			
			tiles[8].setIcon(iconNine);
			JOptionPane.showMessageDialog(null, "Congratulations, You won!");
		}
		
	}
}
