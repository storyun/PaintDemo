package model;

import java.awt.Color;
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
	
	
}
