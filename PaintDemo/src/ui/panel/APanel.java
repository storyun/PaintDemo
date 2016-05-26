package ui.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JToolBar;

import ui.PaintForm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.event.MouseInputListener;

import model.Circle;
import model.Curve;
import model.Line;
import model.Shape;
import model.ShapeList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

public class APanel extends JPanel implements ActionListener, MouseInputListener{
	Point startP= null;
	Point lastP = null;
	private model.Rectangle rectangle;
	private Circle circle;
	private Line line;
	private Curve curve;
	private JToolBar toolbar;
	private ArrayList<Shape> shapeList;	
	
	
	public APanel() {
		this.setSize(new Dimension(800, 600));
		setLayout(null);
		shapeList=null;
		testCanvas canvas = new testCanvas();
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				canvas.x=e.getX();
				canvas.y=e.getY();
				canvas.repaint();
				
			}
		});
		
		
		canvas.setBounds(154, 217, 560, 350);		
		canvas.setBackground(Color.white);
		add(canvas);
		
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	private class testCanvas extends Canvas{
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
}


