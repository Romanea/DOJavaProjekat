package controller;

import app.MainFrame;
import model.CommandModel;
import model.ShapeModel;
import shapes.Command;
import shapes.Shape;
import shapes.circle.*;
import shapes.line.*;
import shapes.point.*;
import shapes.rectangle.*;
import shapes.square.*;
import shapes.hexagon.*;

public class CommandController {
	private CommandModel model = new CommandModel();
	private MainFrame frame;
	
	public CommandController(CommandModel model, MainFrame frame) {
		this.model = model;
		this.frame = frame;
	}
	
	public Command generateAddCommand(Shape shape, ShapeModel shapeModel)
	{
		if(shape instanceof Point) return new AddPoint(shapeModel, (Point)shape);
		else if(shape instanceof Line) return new AddLine(shapeModel, (Line)shape);
		else if(shape instanceof Circle) return new AddCircle(shapeModel, (Circle)shape);
		else if(shape instanceof Rectangle) return new AddRectangle(shapeModel, (Rectangle)shape);
		else if(shape instanceof Square) return new AddSquare(shapeModel, (Square)shape);
		else if(shape instanceof HexagonAdapter) return new AddHexagonAdapter(shapeModel, (HexagonAdapter)shape);
		return null;
	
	}
	
	public Command generateRemoveCommand(Shape shape, ShapeModel shapeModel)
	{
		if(shape instanceof Point) return new RemovePoint(shapeModel, (Point)shape);
		else if(shape instanceof Line) return new RemoveLine(shapeModel, (Line)shape);
		else if(shape instanceof Circle) return new RemoveCircle(shapeModel, (Circle)shape);
		else if(shape instanceof Rectangle) return new RemoveRectangle(shapeModel, (Rectangle)shape);
		else if(shape instanceof Square) return new RemoveSquare(shapeModel, (Square)shape);
		else if(shape instanceof HexagonAdapter) return new RemoveHexagonAdapter(shapeModel, (HexagonAdapter)shape);
		return null;
	}
	
	
}
