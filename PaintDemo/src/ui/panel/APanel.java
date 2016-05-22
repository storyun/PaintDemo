package ui.panel;

import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import ui.PaintForm;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class APanel extends JPanel {
	int x1,y1; //���콺 Ŭ�� ���� ����
	int x2, y2; 
	public APanel() {
		this.setSize(new Dimension(800, 600));
		setLayout(null);
		Graphics2D g2;
		
		Canvas canvas = new Canvas();
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("click x : "+ e.getX());
				System.out.println("click y : "+ e.getY());
			}
		});
		canvas.setBounds(10, 10, 743, 580);
		canvas.setBackground(Color.white);
		add(canvas);
	}
}
