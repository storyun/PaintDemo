package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line extends Shape {
	
	public Line(Point startPoint, Point endPoint, Color color, float stroke) {
		setId(Shape.LINE); 		// 직
		setStartPoint(startPoint);
		setEndPoint(endPoint);
		setColor(color);
		setStroke(stroke);
	}
	
	@Override
	public void move(Point point) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawLine(getStartPoint().x, getStartPoint().y, getEndPoint().x, getEndPoint().y);
	}


}
