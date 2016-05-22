package ui.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import ui.PaintForm;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class APanel extends JPanel {
	Point startP= null;
	Point lastP = null;
	public APanel() {
		this.setSize(new Dimension(800, 600));
		setLayout(null);
		
		
		Canvas canvas = new Canvas();
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startP= e.getPoint();
				System.out.println(startP.getX());
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				lastP= e.getPoint();
				System.out.println(lastP.getX());
				Graphics g= getGraphics();
				g.drawLine(startP.x, startP.y, lastP.x, lastP.y);
				
			}
		});
		
		canvas.setBounds(144, 10, 743, 580);
		canvas.setBackground(Color.white);
		
		
		add(canvas);
		
		
	}
}
