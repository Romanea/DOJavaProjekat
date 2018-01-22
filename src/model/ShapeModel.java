package model;

import java.util.ArrayList;

import shapes.Shape;

public class ShapeModel {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	
	public void add(Shape s) {
		shapes.add(s);
	}

	public boolean remove(Shape s) {
		return shapes.remove(s);
	}

	public int getShapeIndex(Shape s) {
		return shapes.indexOf(s);
	}
	
	public Shape getShape(int index) {
		return shapes.get(index);
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

}
