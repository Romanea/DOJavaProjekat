package strategy.open;

import java.awt.Color;
import java.awt.event.MouseEvent;

import model.ShapeModel;
import shapes.point.Point;
import shapes.point.UpdatePoint;
import shapes.Shape;
import shapes.circle.*;
import shapes.line.*;
import shapes.rectangle.*;
import shapes.square.*;
import shapes.hexagon.*;
import app.MainFrame;
import hexagon.Hexagon;

public class LogDecoder {		
		public void lineLogDecoding(MainFrame drawingFrame, ShapeModel drawingModel, int tempLog ) {
			String fileLine = drawingModel.getLogList().get(tempLog);
			String[] parts = fileLine.split(";");

			int x = Integer.parseInt(parts[0].substring(parts[0].indexOf("(")+1, parts[0].indexOf(",")));
			int y = Integer.parseInt(parts[0].substring(parts[0].indexOf(",")+1, parts[0].indexOf(")")));
			System.out.println(fileLine);
			if(fileLine.contains("Point")) {
			
				String[] color = parts[1].split(":");
				
				Point point  = new Point(x,y, Color.decode(color[1]));
				if(fileLine.contains("Add")) {
					drawingFrame.getCanvasController().draw(point);
				} else if (fileLine.contains("Update")) {
					UpdatePoint updatePointCommand = new UpdatePoint((Point)drawingModel.getSelectedShapes().get(0), point);
					updatePointCommand.execute();
					drawingModel.getUndoStack().offerLast(updatePointCommand);
				} else {
					checkFileLineCommand(point, drawingFrame, fileLine, parts);
				}
			} else if (fileLine.contains("Line")) {
			
				int endX = Integer.parseInt(parts[1].substring(parts[1].indexOf("(")+1, parts[1].indexOf(",")));
				int endY = Integer.parseInt(parts[1].substring(parts[1].indexOf(",")+1, parts[1].indexOf(")")));
				String[] color = parts[2].split(":");
				
				Line line = new Line(new Point(x, y), new Point(endX, endY), Color.decode(color[1]));
				if(fileLine.contains("Add")) {
					drawingFrame.getCanvasController().draw(line);
				} else if (fileLine.contains("Update")) {
					UpdateLine updateLineCommand = new UpdateLine((Line)drawingModel.getSelectedShapes().get(0), line);
					updateLineCommand.execute();
					drawingModel.getUndoStack().offerLast(updateLineCommand);
				} else {
					checkFileLineCommand(line, drawingFrame, fileLine, parts);
				}
				
			} else if (fileLine.contains("Circle")) {
				
				
				String[] radius = parts[1].split(":");
				String[] outerColor = parts[2].split(":");
				String[] insideColor = parts[3].split(":");
				
				
				
			
			
				Circle circle = new Circle(new Point(x,y), Integer.parseInt(radius[1]), Color.decode(outerColor[1]), Color.decode(insideColor[1]));
				if(fileLine.contains("Add")) {
					drawingFrame.getCanvasController().draw(circle);
				}  else if (fileLine.contains("Update")) {
					System.out.println(drawingModel.getSelectedShapes().get(0));
					
					UpdateCircle updateCircleCommand = new UpdateCircle((Circle)drawingModel.getSelectedShapes().get(0), circle);
					updateCircleCommand.execute();
					drawingModel.getUndoStack().offerLast(updateCircleCommand);
					
				} else {
					checkFileLineCommand(circle, drawingFrame, fileLine, parts);
				}
				
			} else if (fileLine.contains("Square")) {
			
				
				String[] lenght = parts[1].split(":");
				String[] outerColor = parts[2].split(":");
				String[] insideColor = parts[3].split(":");
			
				Square square = new Square(new Point(x,y), Integer.parseInt(lenght[1]), Color.decode(outerColor[1]), Color.decode(insideColor[1]));
				if(fileLine.contains("Add")) {
					drawingFrame.getCanvasController().draw(square);
				}  else if (fileLine.contains("Update")) {
					UpdateSquare updateSquareCommand = new UpdateSquare((Square)drawingModel.getSelectedShapes().get(0), square);
					updateSquareCommand.execute();
					drawingModel.getUndoStack().offerLast(updateSquareCommand);
				} else {
					checkFileLineCommand(square, drawingFrame, fileLine, parts);
				}
				
			} else if (fileLine.contains("Rectangle")) {
				
				
				String[] lenght = parts[1].split(":");
				String[] width = parts[2].split(":");
				String[] outerColor = parts[3].split(":");
				String[] insideColor = parts[4].split(":");
			
				Rectangle rectangle = new Rectangle(new Point(x,y), Integer.parseInt(lenght[1]), Integer.parseInt(width[1]), Color.decode(outerColor[1]), Color.decode(insideColor[1])); 
				if(fileLine.contains("Add")) {
					drawingFrame.getCanvasController().draw(rectangle);
				}  else if (fileLine.contains("Update")) {
					UpdateRectangle updateRectangleCommand = new UpdateRectangle((Rectangle)drawingModel.getSelectedShapes().get(0), rectangle);
					updateRectangleCommand.execute();
					drawingModel.getUndoStack().offerLast(updateRectangleCommand);
				} else { checkFileLineCommand(rectangle, drawingFrame, fileLine, parts);
					
				}
				
			}  else if (fileLine.contains("Hexagon")) {

				
				String[] radius = parts[1].split(":");
				
				String[] outerColor = parts[2].split(":");
				String[] insideColor = parts[3].split(":");
			
		
				HexagonAdapter hexagon = new HexagonAdapter(new Hexagon(x,y, Integer.parseInt(radius[1])), Color.decode(outerColor[1]), Color.decode(insideColor[1]));
				if(fileLine.contains("Add")) {
					drawingFrame.getCanvasController().draw(hexagon);
				} else if (fileLine.contains("Update")) {
					UpdateHexagonAdapter updateHexagonCommand = new UpdateHexagonAdapter((HexagonAdapter)drawingModel.getSelectedShapes().get(0), hexagon);
					updateHexagonCommand.execute();
					drawingModel.getUndoStack().offerLast(updateHexagonCommand);
				} else {
					checkFileLineCommand(hexagon, drawingFrame, fileLine, parts);
				}
			} 
			
			
			
			
		}
		
		public void checkFileLineCommand(Shape shape, MainFrame drawingFrame, String fileLine, String[] parts) {
			System.out.println("check " + fileLine);
			if (fileLine.contains("Undo")) {
				drawingFrame.getToolsController().handleUndo();
				
			} else if (fileLine.contains("Remove")) {
				drawingFrame.getToolsController().handleDelete(shape);
			}  else if (fileLine.contains("To back")) {
				drawingFrame.getToolsController().handleSendToBack();
				
			} else if (fileLine.contains("To front")) {
				drawingFrame.getToolsController().handleSendToFront();
				
			}  else if (fileLine.contains("Bring to back")) {
				drawingFrame.getToolsController().handleBringToBack();
				
			} else if (fileLine.contains("Bring to front")) {
				drawingFrame.getToolsController().handleBringToFront();
				
			} else if (fileLine.contains("Select")) {
				String[] selectedCoordinates;
				if (shape instanceof Rectangle) {
					selectedCoordinates =  parts[5].split(": ");
				} else if (shape instanceof Line){
					selectedCoordinates =  parts[3].split(": ");
				
				} else if (shape instanceof Point){
					selectedCoordinates =  parts[2].split(": ");
				}
				else {
					selectedCoordinates =  parts[4].split(": ");
				}
				int Sx = Integer.parseInt(selectedCoordinates[1].substring(selectedCoordinates[1].indexOf("(")+1, selectedCoordinates[1].indexOf(",")));
				int Sy = Integer.parseInt(selectedCoordinates[1].substring(selectedCoordinates[1].indexOf(",")+1, selectedCoordinates[1].indexOf(")")));
				drawingFrame.getToolsController().handleSelection(new MouseEvent(drawingFrame, Sx, Sy, Sy, Sy, Sy, Sy, false));
			} else if (fileLine.contains("Unselect")) {
				drawingFrame.getToolsController().handeDeselection();
			} 
		} 
}