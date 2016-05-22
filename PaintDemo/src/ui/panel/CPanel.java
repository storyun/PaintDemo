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
		this.setSize(new Dimension(800, 600));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(65, 77, 61, 16);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("1");
			}
		});
		btnNewButton.setBounds(66, 105, 117, 29);
		add(btnNewButton);
		
		
		
		
	}
}
