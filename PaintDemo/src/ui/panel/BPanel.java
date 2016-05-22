package ui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;

public class BPanel extends JPanel {
	public BPanel() {
		this.setSize(new Dimension(800, 600));
		setLayout(new BorderLayout(0, 0));
		
		JButton btnDfdf = new JButton("DFDF");
		add(btnDfdf, BorderLayout.CENTER);
	}

}
