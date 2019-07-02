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

	private OptionsView optionsView;
	private Shape shape;
	private boolean isEndLinePoint = false;
	private Point pStartLinePoint;
	private LoggerView logView;
	private MainFrame frame;
	private SaveManager saveManager;
	private int tempLog;
	private OpenManager openManager;
	private LogDecoder decodingLog = new LogDecoder();
	
	
	public Shape getShapeOptions(MouseEvent e)
	{
		String shapeName = optionsView.getCmbShapePicker().getSelectedItem().toString();
		switch(shapeName)
		{
		case "Point": 
			shape =   new Point(e.getX(), e.getY(), optionsView.getBtnBorderColorPicker().getSelectedColor())
			; break;
		
		
		case "Line": {
			if(!isEndLinePoint) {
				pStartLinePoint = new Point(e.getX(), e.getY(), optionsView.getBtnBorderColorPicker().getSelectedColor());
				isEndLinePoint = true;
				shape = pStartLinePoint;
				JOptionPane.showMessageDialog(null, "Click on the line ending point!");
				
			}
			else {
				shape = new Line(pStartLinePoint, new Point(e.getX(), e.getY(), optionsView.getBtnBorderColorPicker().getSelectedColor()), optionsView.getBtnBorderColorPicker().getSelectedColor());
				frame.getView().getModel().remove(pStartLinePoint);
				isEndLinePoint = false;
			}
		};break;
		
		case "Rectangle": 
			{
				
				try {
					if(Integer.parseInt(optionsView.getTxtAdditionalOption1().getText())>0
							&& Integer.parseInt(optionsView.getTxtAdditionalOption2().getText())>0)
					{
						shape = new Rectangle(new Point(e.getX(), e.getY()),
								Integer.parseInt(optionsView.getTxtAdditionalOption1().getText()),
								Integer.parseInt(optionsView.getTxtAdditionalOption2().getText()),
								optionsView.getBtnBorderColorPicker().getSelectedColor(),
								optionsView.getBtnInnerColorPicker().getSelectedColor()
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
				if(Integer.parseInt(optionsView.getTxtAdditionalOption1().getText())>0
						&& Integer.parseInt(optionsView.getTxtAdditionalOption2().getText())>0)
				{
					shape = new Square(new Point(e.getX(), e.getY()),
							Integer.parseInt(optionsView.getTxtAdditionalOption1().getText()),
							optionsView.getBtnBorderColorPicker().getSelectedColor(),
							optionsView.getBtnInnerColorPicker().getSelectedColor()
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
				if(Integer.parseInt(optionsView.getTxtAdditionalOption1().getText())>0
						&& Integer.parseInt(optionsView.getTxtAdditionalOption2().getText())>0)
				{
					shape = new Circle(new Point(e.getX(), e.getY()),
							Integer.parseInt(optionsView.getTxtAdditionalOption1().getText()),
							optionsView.getBtnBorderColorPicker().getSelectedColor(),
							optionsView.getBtnInnerColorPicker().getSelectedColor()
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
				if(Integer.parseInt(optionsView.getTxtAdditionalOption1().getText())>0
						&& Integer.parseInt(optionsView.getTxtAdditionalOption2().getText())>0)
				{
					Hexagon hexagon = new Hexagon(0, 0, 0);
					hexagon.setR(Integer.parseInt(optionsView.getTxtAdditionalOption1().getText()));
					hexagon.setAreaColor(optionsView.getBtnInnerColorPicker().getSelectedColor());
					hexagon.setBorderColor(optionsView.getBtnBorderColorPicker().getSelectedColor());
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


	public void setOptionsView(OptionsView optionsView) {
		this.optionsView = optionsView;
	}

	public void SetFrame(MainFrame frame) {
		this.frame=frame;
	}
	public void SetLogView(LoggerView logView) {
		this.logView=logView;
	}

	public void handleShapeChange() {
		// change options depending on type of shape
		String shapeName = optionsView.getCmbShapePicker().getSelectedItem().toString();
		switch(shapeName)
		{
		case "Point": {
			optionsView.getBtnInnerColorPicker().setEnabled(false);
			optionsView.getLblAdditionalOption1().hide();
			optionsView.getTxtAdditionalOption1().hide();
			
			optionsView.getLblAdditionalOption2().hide();
			optionsView.getTxtAdditionalOption2().hide();
		}
			
			;break;
		
		
		case "Line": {
			optionsView.getBtnInnerColorPicker().setEnabled(false);
			optionsView.getLblAdditionalOption1().hide();
			optionsView.getTxtAdditionalOption1().hide();
			
			optionsView.getLblAdditionalOption2().hide();
			optionsView.getTxtAdditionalOption2().hide();
			
		};break;
		
		case "Rectangle": {	

				optionsView.getBtnInnerColorPicker().setEnabled(true);
				optionsView.getLblAdditionalOption1().show();
				optionsView.getTxtAdditionalOption1().show();
				optionsView.getLblAdditionalOption1().setText("Height: ");
				optionsView.getTxtAdditionalOption1().setText("50");
				optionsView.getTxtAdditionalOption1().setEditable(true);
				
				optionsView.getLblAdditionalOption2().show();
				optionsView.getTxtAdditionalOption2().show();
				optionsView.getLblAdditionalOption2().setText("Width: ");
				optionsView.getTxtAdditionalOption2().setText("50");
				optionsView.getTxtAdditionalOption2().setEditable(true);
			
				
			}
			;break;
		
		case "Square": {
			optionsView.getBtnInnerColorPicker().setEnabled(true);
			optionsView.getLblAdditionalOption2().hide();
			optionsView.getTxtAdditionalOption2().hide();
			
			optionsView.getLblAdditionalOption1().setText("Side: ");
			optionsView.getLblAdditionalOption1().show();
			optionsView.getTxtAdditionalOption1().setText("50");
			optionsView.getTxtAdditionalOption1().show();
			optionsView.getTxtAdditionalOption1().setEditable(true);
			
			
			
		};break;
		
		case "Circle":	{
			optionsView.getBtnInnerColorPicker().setEnabled(true);
			optionsView.getLblAdditionalOption2().hide();
			optionsView.getTxtAdditionalOption2().hide();
			
			optionsView.getLblAdditionalOption1().setText("R: ");
			optionsView.getLblAdditionalOption1().show();
			optionsView.getTxtAdditionalOption1().setText("50");
			optionsView.getTxtAdditionalOption1().show();
			optionsView.getTxtAdditionalOption1().setEditable(true);
			
			
		} ;break;
		
		case "Hexagon": {
			optionsView.getBtnInnerColorPicker().setEnabled(true);
			optionsView.getLblAdditionalOption2().hide();
			optionsView.getTxtAdditionalOption2().hide();
			
			optionsView.getLblAdditionalOption1().setText("R: ");
			optionsView.getLblAdditionalOption1().show();
			optionsView.getTxtAdditionalOption1().setText("50");
			optionsView.getTxtAdditionalOption1().show();
			optionsView.getTxtAdditionalOption1().setEditable(true);
			
			
		};break;
		}
		
	
	
		
	}
	
public void saveLog() {
		
		if(logView.getLogs().isEmpty()) {
			System.out.println("Log is empty");
			return;
		}

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "text");
		chooser.setFileFilter(filter);
		int answer = chooser.showSaveDialog(optionsView.getBtnSaveLog());
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
		int answer = chooser.showSaveDialog(optionsView.getBtnSaveDrawing());

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
