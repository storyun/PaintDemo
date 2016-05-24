package ui.panel;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.MouseInputListener;

import model.Circle;
import model.Curve;
import model.Line;
import model.Shape;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class CPanel extends JPanel implements ActionListener, MouseInputListener {
	
	private MyCanvas canvas;
	
	private JButton colorButton;
	private JSpinner borderSpinner;
	private JToggleButton rectangleButton;
	private JToggleButton circleButton;
	private JToggleButton lineButton;
	private JToggleButton curveButton;
	private ButtonGroup buttonGroup;
	
	private Color currentColor;
	private float currentStroke;
	private int drawID;
	
	private Point startPoint;
	private Point endPoint;
	private model.Rectangle rectangle;
	private Circle circle;
	private Line line;
	private Curve curve;
	private ArrayList<Point> curvePoint;
	
	private ArrayList<Shape> shapeList;
	
	public CPanel() {
		super();
		this.setSize(new Dimension(800, 600));
		setLayout(null);
		
		// 변수 초기
		currentColor = Color.BLACK;
		drawID = Shape.RECTANGLE;
		startPoint = new Point();
		endPoint = new Point();
		shapeList = new ArrayList<Shape>();
		
		// UI
		canvas = new MyCanvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(10, 10, 661, 580);
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		add(canvas);
		
		colorButton = new JButton("Color");
		int reserveColor = currentColor.getRGB();
		reserveColor ^= 0x00FFFFFF;
		colorButton.setForeground(new Color(reserveColor));
		colorButton.setBackground(currentColor);
		colorButton.setBounds(677, 10, 117, 29);
		colorButton.setOpaque(true);
		colorButton.setBorderPainted(false);
		colorButton.addActionListener(this);
		
		add(colorButton);
		
		buttonGroup = new ButtonGroup();
		rectangleButton = new JToggleButton("ㅁ");
		buttonGroup.add(rectangleButton);
		rectangleButton.setBounds(new Rectangle(677, 75, 60, 60));
		add(rectangleButton);
		buttonGroup.add(rectangleButton);
		rectangleButton.setSelected(true);
		
		circleButton = new JToggleButton("ㅇ");
		buttonGroup.add(circleButton);
		circleButton.setBounds(new Rectangle(735, 75, 60, 60));
		add(circleButton);
		buttonGroup.add(circleButton);
		
		lineButton = new JToggleButton("/");
		buttonGroup.add(lineButton);
		lineButton.setBounds(new Rectangle(677, 133, 60, 60));
		add(lineButton);
		buttonGroup.add(lineButton);
		
		curveButton = new JToggleButton("~");
		buttonGroup.add(curveButton);
		curveButton.setBounds(new Rectangle(735, 133, 60, 60));
		add(curveButton);
		buttonGroup.add(circleButton);
		
		rectangleButton.addActionListener(this);
		circleButton.addActionListener(this);
		lineButton.addActionListener(this);
		curveButton.addActionListener(this);
		
		JLabel lblBorder = new JLabel("Border ");
		lblBorder.setBounds(676, 51, 61, 16);
		add(lblBorder);
		
		borderSpinner = new JSpinner();
		borderSpinner.setBounds(721, 46, 73, 26);
		borderSpinner.setModel(new SpinnerNumberModel((float)1, (float)0, (float)10, (float)1));
		add(borderSpinner);
		
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
		else if(e.getSource() == rectangleButton) {
			drawID = Shape.RECTANGLE;
		}
		else if(e.getSource() == circleButton) {
			drawID = Shape.CIRCLE;
		}
		else if(e.getSource() == lineButton) {
			drawID = Shape.LINE;
		}
		else if(e.getSource() == curveButton) {
			drawID = Shape.CURVE;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		startPoint = new Point();
		endPoint = new Point();
		startPoint.setLocation(e.getX(), e.getY());
		
		if(drawID == Shape.CURVE) {
			curvePoint = new ArrayList<Point>();
			curvePoint.add(startPoint);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		endPoint.setLocation(e.getX(), e.getY());
		canvas.repaint();
		
		if(drawID == Shape.RECTANGLE) {
			if(startPoint.getX() > endPoint.getX() && startPoint.getY() > endPoint.getY() ) return;
			
			rectangle = new model.Rectangle(startPoint, endPoint, currentColor, currentStroke);
			shapeList.add(rectangle);
		}
		else if(drawID == Shape.CIRCLE) {
			if(startPoint.getX() > endPoint.getX() && startPoint.getY() > endPoint.getY() ) return;
			
			circle = new Circle(startPoint, endPoint, currentColor, currentStroke);
			shapeList.add(circle);
		}
		else if(drawID == Shape.LINE) {
			line = new Line(startPoint, endPoint, currentColor, currentStroke);
			shapeList.add(line);
			
		}
		else if(drawID == Shape.CURVE) {
			curve = new Curve(curvePoint, currentColor, currentStroke);
			shapeList.add(curve);
		}
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
		endPoint.setLocation(e.getX(), e.getY());
		
		if(drawID == Shape.CURVE) {
			curvePoint.add(endPoint);
			endPoint = new Point();
		}
		
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	//부모페인트

	}

	private class MyCanvas extends Canvas {
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Graphics2D g2 = (Graphics2D)canvas.getGraphics();
			
			// 이전까지 그렸던 도형 그림
			for(int i=0; i<shapeList.size(); i++) {
				Shape s = shapeList.get(i);
				g2.setColor(s.getColor());
				g2.setStroke(s.getStroke());
				if(s.getId() == Shape.RECTANGLE) {
					g2.drawRect(s.getStartPoint().x, s.getStartPoint().y, s.getWidth(), s.getHeight());
				}
				else if(s.getId() == Shape.CIRCLE) {
					g2.drawOval(s.getStartPoint().x, s.getStartPoint().y, s.getWidth(), s.getHeight());
				}
				else if(s.getId() == Shape.LINE) {
					g2.drawLine(s.getStartPoint().x, s.getStartPoint().y, s.getEndPoint().x, s.getEndPoint().y);
				}
				else if(s.getId() == Shape.CURVE) {
					for(int j=0; j<s.getPointList().size()-1; j++) {
						Point p1 = s.getPointList().get(j);
						Point p2 = s.getPointList().get(j+1);
						g2.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
					}
				}
			}
			
			// 
			if( startPoint == null && endPoint == null ) return;
			
			// 현재 그리고 있는 도형 그림
			g2.setColor(currentColor);
			String s = borderSpinner.getValue().toString();
			currentStroke = Float.valueOf(s).floatValue();
			g2.setStroke(new BasicStroke(currentStroke));
			if(drawID == Shape.RECTANGLE) {
				
				g2.drawRect(startPoint.x, startPoint.y, endPoint.x - startPoint.x, endPoint.y - startPoint.y);
			}
			else if(drawID == Shape.CIRCLE) {
				g2.drawOval(startPoint.x, startPoint.y, endPoint.x - startPoint.x, endPoint.y - startPoint.y);
			}
			else if(drawID == Shape.LINE) {
				g2.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
			}
			else if(drawID == Shape.CURVE) {
				for(int i=0; i<curvePoint.size()-1; i++) {
					Point p1 = curvePoint.get(i);
					Point p2 = curvePoint.get(i+1);
					g2.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
				}
			}
		}
	}
}
