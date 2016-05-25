package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public abstract class Shape {
	public final static int RECTANGLE = 1;
	public final static int CIRCLE = 2;
	public final static int LINE = 3;
	public final static int CURVE = 4;
	
	private int id;								//  1: 사각형, 2: 원, 3: 직선, 4: 곡
	private Point startPoint;
	private Point endPoint;
	private Color color;
	private BasicStroke stroke;
	
	public int getWidth() {
		int width = 0;
		return width;
	}
	public int getHeight() {
		int height = 0;
		return height;
	}
	
	public abstract void draw(Graphics2D g2);
	public abstract void move(Point point);		// 도형 움직이는 함수
	public abstract void rotate();				// 도형 회전시키는 함수
	
	
	// getter, setter--------------------------------------------------
	public int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	public Color getColor() {
		return color;
	}
	public BasicStroke getStroke() {
		return stroke;
	}
	protected void setColor(Color color) {
		this.color = color;
	}
	protected void setStroke(float stroke) {
		this.stroke = new BasicStroke(stroke);
	}
	protected void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	protected void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	public Point getStartPoint() {
		return startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public ArrayList<Point> getPointList() {
		ArrayList<Point> pointList = null;
		return pointList;
	}

	public void setPointList(ArrayList<Point> pointList) {
	}
	
	
}
