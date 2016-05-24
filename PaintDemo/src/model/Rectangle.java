package model;

import java.awt.Color;
import java.awt.Point;

public class Rectangle extends Shape {
	
	private int width;
	private int height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point startPoint, Point endPoint, Color color, int border) {
		setId(Shape.RECTANGLE); 		// 사각형
		setStartPoint(startPoint);
		setEndPoint(endPoint);
		setColor(color);
		setBorder(border);
		
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
	
	

}
