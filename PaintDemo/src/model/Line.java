package model;

import java.awt.Color;
import java.awt.Point;

public class Line extends Shape {
	
	public Line(Point startPoint, Point endPoint, Color color, int border) {
		setId(Shape.LINE); 		// 직
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
