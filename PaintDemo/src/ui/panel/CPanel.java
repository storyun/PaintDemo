package ui.panel;

import java.awt.Dimension;

import javax.swing.JPanel;

import ui.PaintForm;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CPanel extends JPanel {
	public CPanel() {
		super();
		this.setSize(new Dimension(800, 600));
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(53, 67, 117, 29);
		add(btnNewButton);
		
		this.setVisible(true);
	}
}
