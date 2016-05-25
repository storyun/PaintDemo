package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Curve extends Shape{
	
	private ArrayList<Point> pointList;
	
	public Curve(ArrayList<Point> pointList, Color color, float stroke) {
		
		setId(Shape.CURVE); 		//곡선 
		setColor(color);
		setStroke(stroke);
		
		this.pointList = pointList;
	}

	@Override
	public void move(Point point) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Point> getPointList() {
		return pointList;
	}

	public void setPointList(ArrayList<Point> pointList) {
		this.pointList = pointList;
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		for(int j=0; j<getPointList().size()-1; j++) {
			Point p1 = getPointList().get(j);
			Point p2 = getPointList().get(j+1);
			g2.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
		}
	}
	
	
}
