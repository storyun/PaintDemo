package model;

import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape {

	public Circle(Point startPoint, Point endPoint, Color color, int border) {
		
		setId(Shape.CIRCLE); 		// 
		setStartPoint(startPoint);
		setEndPoint(endPoint);
		setColor(color);
		setBorder(border);

	}
	@Override
	public void move(Point point) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub

	}

}
