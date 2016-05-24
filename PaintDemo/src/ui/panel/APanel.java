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
import java.awt.event.MouseMotionAdapter;

public class APanel extends JPanel{
	Point startP= null;
	Point lastP = null;
	
	
	
	public APanel() {
		this.setSize(new Dimension(800, 600));
		setLayout(null);
		
		testCanvas canvas = new testCanvas();
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				canvas.x=e.getX();
				canvas.y=e.getY();
				canvas.repaint();
				System.out.println(e.getX());
			}
		});
		
		
		canvas.setBounds(119, 114, 560, 350);		
		canvas.setBackground(Color.white);
		add(canvas);
		
		
	}
}

class testCanvas extends Canvas{
	int width=10;
	int height=10;//선의 두께 
	int x=-20; int y=-20;  //그리는 선의 위치 초기값을 마이너스로 잡아서 안보이게 처리
	Color color=Color.black;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		paint(g);
	}
}
