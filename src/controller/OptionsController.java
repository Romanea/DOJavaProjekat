package controller;

import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import hexagon.Hexagon;
import shapes.*;
import shapes.circle.Circle;
import shapes.hexagon.HexagonAdapter;
import shapes.line.Line;
import shapes.point.Point;
import shapes.rectangle.Rectangle;
import shapes.square.Square;
import strategy.open.LogDecoder;
import strategy.open.OpenDrawing;
import strategy.open.OpenLog;
import strategy.open.OpenManager;
import strategy.save.SaveDrawing;
import strategy.save.SaveLog;
import strategy.save.SaveManager;
import view.LoggerView;
import view.OptionsView;
import app.MainFrame;
public class OptionsController {

	private Shape shape;
	private boolean isEndLinePoint = false;
	private Point pStartLinePoint;
	private MainFrame frame;
	private SaveManager saveManager;
	private int tempLog;
	private OpenManager openManager;
	private LogDecoder decodingLog = new LogDecoder();
	private boolean isFirstLine = true;
	
	
	public Shape getShapeOptions(MouseEvent e)
	{
		String shapeName = frame.getOptionsView().getCmbShapePicker().getSelectedItem().toString();
		switch(shapeName)
		{
		case "Point": 
			shape =   new Point(e.getX(), e.getY(), frame.getOptionsView().getBtnBorderColorPicker().getSelectedColor())
			; break;
		
		
		case "Line": {
			if(!isEndLinePoint) {
				pStartLinePoint = new Point(e.getX(), e.getY(), frame.getOptionsView().getBtnBorderColorPicker().getSelectedColor());
				isEndLinePoint = true;
				shape = pStartLinePoint;
				if(this.isFirstLine) {
					JOptionPane.showMessageDialog(null, "Click on the line ending point!");
					this.isFirstLine = false;
				}
				
			}
			else {
				shape = new Line(pStartLinePoint, new Point(e.getX(), e.getY(), frame.getOptionsView().getBtnBorderColorPicker().getSelectedColor()), frame.getOptionsView().getBtnBorderColorPicker().getSelectedColor());
				frame.getView().getModel().remove(pStartLinePoint);
				isEndLinePoint = false;
			}
		};break;
		
		case "Rectangle": 
			{
				
				try {
					if(Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption1().getText())>0
							&& Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption2().getText())>0)
					{
						shape = new Rectangle(new Point(e.getX(), e.getY()),
								Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption1().getText()),
								Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption2().getText()),
								frame.getOptionsView().getBtnBorderColorPicker().getSelectedColor(),
								frame.getOptionsView().getBtnInnerColorPicker().getSelectedColor()
								);
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid input!");
						
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Side length has to be a number.");
				}
				
			}
			;break;
		
		case "Square": 
		{
			try {
				if(Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption1().getText())>0
						&& Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption2().getText())>0)
				{
					shape = new Square(new Point(e.getX(), e.getY()),
							Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption1().getText()),
							frame.getOptionsView().getBtnBorderColorPicker().getSelectedColor(),
							frame.getOptionsView().getBtnInnerColorPicker().getSelectedColor()
							);
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid input!");
					
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Side length has to be a number.");
			}
			
		};break;
		
		case "Circle":{
			try {
				if(Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption1().getText())>0
						&& Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption2().getText())>0)
				{
					shape = new Circle(new Point(e.getX(), e.getY()),
							Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption1().getText()),
							frame.getOptionsView().getBtnBorderColorPicker().getSelectedColor(),
							frame.getOptionsView().getBtnInnerColorPicker().getSelectedColor()
							);
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid input!");
					
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "R length has to be a number.");
			}
		}
			;break;
		
		case "Hexagon":{
			try {
				if(Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption1().getText())>0
						&& Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption2().getText())>0)
				{
					Hexagon hexagon = new Hexagon(0, 0, 0);
					hexagon.setR(Integer.parseInt(frame.getOptionsView().getTxtAdditionalOption1().getText()));
					hexagon.setAreaColor(frame.getOptionsView().getBtnInnerColorPicker().getSelectedColor());
					hexagon.setBorderColor(frame.getOptionsView().getBtnBorderColorPicker().getSelectedColor());
					hexagon.setX(e.getX());
					hexagon.setY(e.getY());
					
					shape = new HexagonAdapter(hexagon);
					//System.out.println(shape.toString());
					
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid input!");
					
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "R length has to be a number.");
			}
		};break;
		}
		return shape;
	
	}



	public void SetFrame(MainFrame frame) {
		this.frame=frame;
	}


	public void handleShapeChange() {
		// change options depending on type of shape
		String shapeName = frame.getOptionsView().getCmbShapePicker().getSelectedItem().toString();
		switch(shapeName)
		{
		case "Point": {
			frame.getOptionsView().getBtnInnerColorPicker().setEnabled(false);
			frame.getOptionsView().getLblAdditionalOption1().hide();
			frame.getOptionsView().getTxtAdditionalOption1().hide();
			
			frame.getOptionsView().getLblAdditionalOption2().hide();
			frame.getOptionsView().getTxtAdditionalOption2().hide();
		}
			
			;break;
		
		
		case "Line": {
			frame.getOptionsView().getBtnInnerColorPicker().setEnabled(false);
			frame.getOptionsView().getLblAdditionalOption1().hide();
			frame.getOptionsView().getTxtAdditionalOption1().hide();
			
			frame.getOptionsView().getLblAdditionalOption2().hide();
			frame.getOptionsView().getTxtAdditionalOption2().hide();
			
		};break;
		
		case "Rectangle": {	

			frame.getOptionsView().getBtnInnerColorPicker().setEnabled(true);
			frame.getOptionsView().getLblAdditionalOption1().show();
			frame.getOptionsView().getTxtAdditionalOption1().show();
			frame.getOptionsView().getLblAdditionalOption1().setText("Height: ");
			frame.getOptionsView().getTxtAdditionalOption1().setText("50");
			frame.getOptionsView().getTxtAdditionalOption1().setEditable(true);
				
			frame.getOptionsView().getLblAdditionalOption2().show();
			frame.getOptionsView().getTxtAdditionalOption2().show();
			frame.getOptionsView().getLblAdditionalOption2().setText("Width: ");
			frame.getOptionsView().getTxtAdditionalOption2().setText("50");
			frame.getOptionsView().getTxtAdditionalOption2().setEditable(true);
			
				
			}
			;break;
		
		case "Square": {
			frame.getOptionsView().getBtnInnerColorPicker().setEnabled(true);
			frame.getOptionsView().getLblAdditionalOption2().hide();
			frame.getOptionsView().getTxtAdditionalOption2().hide();
			
			frame.getOptionsView().getLblAdditionalOption1().setText("Side: ");
			frame.getOptionsView().getLblAdditionalOption1().show();
			frame.getOptionsView().getTxtAdditionalOption1().setText("50");
			frame.getOptionsView().getTxtAdditionalOption1().show();
			frame.getOptionsView().getTxtAdditionalOption1().setEditable(true);
			
			
			
		};break;
		
		case "Circle":	{
			frame.getOptionsView().getBtnInnerColorPicker().setEnabled(true);
			frame.getOptionsView().getLblAdditionalOption2().hide();
			frame.getOptionsView().getTxtAdditionalOption2().hide();
			
			frame.getOptionsView().getLblAdditionalOption1().setText("R: ");
			frame.getOptionsView().getLblAdditionalOption1().show();
			frame.getOptionsView().getTxtAdditionalOption1().setText("50");
			frame.getOptionsView().getTxtAdditionalOption1().show();
			frame.getOptionsView().getTxtAdditionalOption1().setEditable(true);
			
			
		} ;break;
		
		case "Hexagon": {
			frame.getOptionsView().getBtnInnerColorPicker().setEnabled(true);
			frame.getOptionsView().getLblAdditionalOption2().hide();
			frame.getOptionsView().getTxtAdditionalOption2().hide();
			
			frame.getOptionsView().getLblAdditionalOption1().setText("R: ");
			frame.getOptionsView().getLblAdditionalOption1().show();
			frame.getOptionsView().getTxtAdditionalOption1().setText("50");
			frame.getOptionsView().getTxtAdditionalOption1().show();
			frame.getOptionsView().getTxtAdditionalOption1().setEditable(true);
			
			
		};break;
		}
		
	
	
		
	}
	
public void saveLog() {
		
		if(frame.getLogView().getLogs().isEmpty()) {
			System.out.println("Log is empty");
			return;
		}

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "text");
		chooser.setFileFilter(filter);
		int answer = chooser.showSaveDialog(frame.getOptionsView().getBtnSaveLog());
				 if (answer == JFileChooser.APPROVE_OPTION) {
					    File file = chooser.getSelectedFile();
					 	String path = file.getAbsolutePath();		
						System.out.println(path);
						saveManager = new SaveManager(new SaveLog());
						saveManager.save(frame, file);
					
						
					} else if (answer == JFileChooser.CANCEL_OPTION) {
						return;
					} else if (answer == JFileChooser.ERROR_OPTION) {
						System.out.println("Error while saving log");
						
					}
		
			
	}
	
	public void saveDrawing() {
		saveManager = new SaveManager(new SaveDrawing());
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("ser","jpg", "jpeg", "png");
		chooser.setFileFilter(filter);
		int answer = chooser.showSaveDialog(frame.getOptionsView().getBtnSaveDrawing());

		if (answer == JFileChooser.APPROVE_OPTION) {

			File file = chooser.getSelectedFile();
			
			String path = file.getAbsolutePath();
			System.out.println(path);
			saveManager = new SaveManager(new SaveDrawing());
			saveManager.save(frame, file);
		}
		
	}
	
	public void importLog() {
		
		JFileChooser chooser = new JFileChooser();
		int answer = chooser.showSaveDialog(null);
		if (answer == JFileChooser.OPEN_DIALOG) {
			
			if(!frame.getView().getModel().getLogList().isEmpty()) {
				frame.getView().getModel().getLogList().clear();
				this.tempLog = 0;
			}

			File file = chooser.getSelectedFile();
		
			String path = file.getAbsolutePath();
			System.out.println(path);
			openManager = new OpenManager(new OpenLog());
			openManager.open(frame.getView().getModel(), frame, file);
		
			
		} else if (answer == JFileChooser.CANCEL_OPTION) {
			
		} else if (answer == JFileChooser.ERROR_OPTION) {
			
		}
				
	}
	
	public void importDrawing() {
		JFileChooser chooser = new JFileChooser();
		int answer = chooser.showSaveDialog(frame.getOptionsView().getBtnSaveDrawing());
		if (answer == JFileChooser.OPEN_DIALOG) {
			
			if(!frame.getView().getModel().getLogList().isEmpty()) {
				frame.getView().getModel().getLogList().clear();
				this.tempLog = 0;
			}

			File file = chooser.getSelectedFile();
		
			String path = file.getAbsolutePath();
			System.out.println(path);
			openManager = new OpenManager(new OpenDrawing());
			openManager.open(frame.getView().getModel(), frame, file);
			frame.repaint();
		
			
		} else if (answer == JFileChooser.CANCEL_OPTION) {
			
		} else if (answer == JFileChooser.ERROR_OPTION) {
			
		}
		
	}
	
	//LOG NEXT LINE
	public void logNextLine() {
		
		if(tempLog < frame.getView().getModel().getLogList().size()) {
			
			decodingLog.lineLogDecoding(frame, frame.getView().getModel(), tempLog);
			tempLog++;
		}
		
	}
}
