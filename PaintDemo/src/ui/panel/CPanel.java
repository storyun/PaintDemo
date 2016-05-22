package ui.panel;

import java.awt.Dimension;

import javax.swing.JPanel;

import ui.PaintForm;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.Color;

public class CPanel extends JPanel implements ActionListener {
	
	private Canvas canvas;
	private JButton colorButton;
	
	private Color currentColor;
	
	public CPanel() {
		super();
		this.setSize(new Dimension(800, 600));
		setLayout(null);
		currentColor = Color.BLACK;
		
		canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(10, 10, 624, 580);
		add(canvas);
		
		colorButton = new JButton("Color");
		int reserveColor = currentColor.getRGB();
		reserveColor ^= 0x00FFFFFF;
		colorButton.setForeground(new Color(reserveColor));
		colorButton.setBackground(currentColor);
		colorButton.setBounds(640, 10, 117, 29);
		colorButton.setOpaque(true);
		colorButton.setBorderPainted(false);
		colorButton.addActionListener(this);
		
		add(colorButton);
		
		
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource() == colorButton) {
			currentColor = JColorChooser.showDialog(this, "색을 선택하세요", currentColor);
			int reserveColor = currentColor.getRGB();
			reserveColor ^= 0x00FFFFFF;
			colorButton.setForeground(new Color(reserveColor));
			colorButton.setBackground(currentColor);
		}
	}
}
