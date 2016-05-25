package ui.panel;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class BPanel extends JPanel{
	
	Color color = Color.black;
	
	public BPanel() {
		this.setSize(new Dimension(800, 600));
		setLayout(new BorderLayout(0, 0));
		
		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				Graphics g = getGraphics();
				g.setColor(color);
				g.drawLine(e.getX(), e.getY(), e.getX()+1, e.getY()+1);
				canvas.repaint();
			}
		});
		canvas.setBackground(color.white);
		
		Panel panel = new Panel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(10, 2, 0, 0));
		
		JButton btnRed = new JButton("Red");
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.red;
			}
		});
		panel.add(btnRed);
		
		JButton btnBlue = new JButton("Blue");
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.blue;
			}
		});
		panel.add(btnBlue);
		
		JButton btnGreen = new JButton("Green");
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.green;
			}
		});
		panel.add(btnGreen);
		
		JButton btnBlack = new JButton("Black");
		btnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.black;
			}
		});
		panel.add(btnBlack);
	}
}