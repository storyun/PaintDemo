package ui.panel;

import java.awt.Dimension;

import javax.swing.JPanel;

import ui.PaintForm;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class APanel extends JPanel {
	int x1,y1; //마우스 클릭 시작 지점
	int x2, y2; 
	public APanel() {
		this.setSize(new Dimension(800, 600));
		setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("click x : "+ e.getX());
				System.out.println("click y : "+ e.getY());
			}
		});
		canvas.setBounds(10, 10, 743, 580);
		add(canvas);
	}
}
