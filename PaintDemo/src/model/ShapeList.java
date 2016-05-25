package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ShapeList implements Serializable{
	
	private ArrayList<Shape> shapeList;
	
	public ShapeList() {
		shapeList = new ArrayList<Shape>();
		
	}

	public ArrayList<Shape> getShapeList() {
		return shapeList;
	}

	public void setShapeList(ArrayList<Shape> shapeList) {
		this.shapeList = shapeList;
	}
	
	public void clear() {
		shapeList = new ArrayList<Shape>();
	}
	
	public void addShape(Shape s) {
		shapeList.add(s);
	}
	
	public int size() {
		return shapeList.size();
	}
	
	public Shape get(int i) {
		return shapeList.get(i);
	}
}
