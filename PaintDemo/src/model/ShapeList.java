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
	
	
}
