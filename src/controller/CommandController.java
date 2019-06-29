package controller;

import app.MainFrame;
import dialogs.*;
import model.CommandModel;
import model.ShapeModel;
import shapes.point.Point;
import shapes.point.UpdatePoint;
import shapes.Command;
import shapes.Shape;
import shapes.circle.*;
import shapes.line.*;
import shapes.point.*;
import shapes.rectangle.*;
import shapes.square.*;
import view.LoggerView;
import shapes.hexagon.*;

public class CommandController {
	private CommandModel model = new CommandModel();
	private MainFrame frame;
	private LoggerView log;
	
	public CommandController(CommandModel model, MainFrame frame, LoggerView log) {
		this.model = model;
		this.frame = frame;
		this.log = log;
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
	
	public Command generateUpdateCommand(Shape shape, ShapeModel shapeModel)
	{
		if(shape instanceof Point) 
			{
			UpdatePointDialog updatePoint = new UpdatePointDialog((Point) shape);
			if (updatePoint.getPoint() != null) {
				return new UpdatePoint((Point) shape, updatePoint.getPoint());
			}
			
			}
		else if(shape instanceof Line) {
			UpdateLineDialog updateLine = new UpdateLineDialog((Line) shape);
			if(updateLine.getLine() != null) {
				return new UpdateLine((Line)shape, updateLine.getLine());
			}
		}
		else if(shape instanceof Circle) {
			UpdateCircleDialog updateCircle = new UpdateCircleDialog((Circle) shape);
			if(updateCircle.getCircle() != null) {
				return new UpdateCircle((Circle)shape, updateCircle.getCircle());
			}
		}
		else if(shape instanceof Rectangle) {
			UpdateRectangleDialog updateRectangle = new UpdateRectangleDialog((Rectangle) shape);
			if(updateRectangle.getRectangle() != null) {
				return new UpdateRectangle((Rectangle)shape, updateRectangle.getRectangle());
			}		
		}
		else if(shape instanceof Square) {
			UpdateSquareDialog updateSquare = new UpdateSquareDialog((Square) shape);
			if(updateSquare.getSquare() != null) {
				return new UpdateSquare((Square)shape, updateSquare.getSquare());
			}	
		}
		else if(shape instanceof HexagonAdapter) {
			UpdateHexagonDialog updateHexagon = new UpdateHexagonDialog((HexagonAdapter) shape);
			if(updateHexagon.getHexagon() != null) {
				return new UpdateHexagonAdapter((HexagonAdapter)shape, updateHexagon.getHexagon());
			}		}
		return null;
	}
	
	
}
