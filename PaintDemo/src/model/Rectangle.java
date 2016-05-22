package model;

import java.awt.Color;
import java.awt.Point;

public class Rectangle extends Shape {
	
	private double width;
	private double height;
	
	public Rectangle(Point startPoint, Point endPoint, Color color, int border) {
		setId(Shape.RECTANGLE); 		// 사각형
		setStartPoint(startPoint);
		setEndPoint(endPoint);
		setColor(color);
		setBorder(border);
		
		// width 구하기
		if( startPoint.getX() > endPoint.getX() ) {
			width = startPoint.getX() - endPoint.getX();
		}
		else if( startPoint.getX() < endPoint.getX() ) {
			width = endPoint.getX() - startPoint.getX();
		}
		
		// height 구하기
		if( startPoint.getY() > endPoint.getY() ) {
			height = startPoint.getY() - endPoint.getY();
		}
		else if( startPoint.getX() < endPoint.getX() ) {
			height = endPoint.getY() - startPoint.getY();
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


	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	

}
