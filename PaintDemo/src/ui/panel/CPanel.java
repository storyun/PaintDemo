package ui.panel;

import java.awt.Dimension;

import javax.swing.JPanel;

import ui.PaintForm;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.Color;

public class CPanel extends JPanel {
	public CPanel() {
		super();
		this.setSize(new Dimension(800, 600));
		setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(10, 10, 624, 580);
		add(canvas);
		
		this.setVisible(true);
	}
}
