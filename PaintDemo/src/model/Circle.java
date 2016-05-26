package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

public class Circle extends Shape implements Serializable{

	private int width;
	private int height;
	
	public Circle(Point startPoint, Point endPoint, Color color, float stroke) {
		
		setId(Shape.CIRCLE); 		// 
		setStartPoint(startPoint);
		setEndPoint(endPoint);
		setColor(color);
		setStroke(stroke);
		
		// width 구하기
		if( startPoint.getX() > endPoint.getX() ) {
			width = startPoint.x - endPoint.x;
		}
		else if( startPoint.getX() < endPoint.getX() ) {
			width = endPoint.x - startPoint.x;
		}
		
		// height 구하기
		if( startPoint.getY() > endPoint.getY() ) {
			height = startPoint.y - endPoint.y;
		}
		else if( startPoint.getX() < endPoint.getX() ) {
			height = endPoint.y - startPoint.y;
		}

	}
	@Override
	public void move(Point point) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub

	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawOval(getStartPoint().x, getStartPoint().y, getWidth(), getHeight());
	}

}
