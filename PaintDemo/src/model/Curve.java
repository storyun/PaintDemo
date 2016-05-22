package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Curve extends Shape{
	
	private ArrayList<Point> pointList;
	
	public Curve(Point startPoint, Color color, int border) {
		
		setId(Shape.CURVE); 		//곡선 
		setStartPoint(startPoint);
		setColor(color);
		setBorder(border);
		
		pointList = new ArrayList<Point>();
		pointList.add(startPoint);
	}

	@Override
	public void move(Point point) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}
	
	// 곡선 점 계속 추가하는 함
	public void addPoint(Point point, boolean isEnd) {
		pointList.add(point);
		
		// 마지막 입력 값이면 끝점에 표기
		if(isEnd) {
			setEndPoint(point);
		} 
	}
}
