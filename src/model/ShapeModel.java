package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import shapes.observer.Subject;
import shapes.observer.Observer;
import shapes.Command;
import shapes.Shape;

public class ShapeModel implements Subject, Serializable{

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Deque<Command> redoStack = new LinkedList<>();
	private Deque<Command> undoStack = new LinkedList<>();
	private ArrayList<Shape> selectedShapes = new ArrayList<>();
	private ArrayList<String> logList  = new ArrayList<>();
	ArrayList<Observer> observers=new ArrayList<>();

	
	
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
	public ArrayList<Shape> getSelectedShapes() {
		selectedShapes.clear();
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).isSelected()) {
				selectedShapes.add(shapes.get(i));
			}
		}
		return selectedShapes;
	}

	public void removeAllShapes() {
		shapes.clear();
		redoStack.clear();
		undoStack.clear();
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
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void deleteObserver(Observer observer) {
		
		observers.remove(observer);
		
	}

	@Override
	public void notifyAllObservers() {
		
		for (Observer observer : observers) {
			countSelectedShapes();
			observer.update(selectedShapes.size());
		
		}
	
	}

	public Deque<Command> getRedoStack() {
		return redoStack;
	}

	public Deque<Command> getUndoStack() {
		return undoStack;
	}
	
	public ArrayList<String> getLogList() {
		return logList;
	}

	public void setLogList(ArrayList<String> logList) {
		this.logList = logList;
	}
	

	

}
