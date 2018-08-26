package model;

import java.util.ArrayList;

import shapes.Shape;

public class ShapeModel {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<Shape> selectedShapes = new ArrayList<>();

	
	
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
	
	public int countSelectedShapes() {
		selectedShapes.clear();
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).isSelected()) {
				selectedShapes.add(shapes.get(i));
			}
		}
		
		return selectedShapes.size();
	}

}
