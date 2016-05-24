package model;

import java.awt.Color;
import java.awt.Point;

public abstract class Shape {
	public final static int RECTANGLE = 1;
	public final static int CIRCLE = 2;
	public final static int LINE = 3;
	public final static int CURVE = 4;
	
	private int id;								//  1: 사각형, 2: 원, 3: 직선, 4: 곡
	private Point startPoint;
	private Point endPoint;
	private Color color;
	private int border;
	
	public int getWidth() {
		int width = 0;
		return width;
	}
	public int getHeight() {
		int height = 0;
		return height;
	}
	
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
	public int getBorder() {
		return border;
	}
	protected void setColor(Color color) {
		this.color = color;
	}
	protected void setBorder(int border) {
		this.border = border;
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
	
	
}
