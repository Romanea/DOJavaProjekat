package controller;

import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import shapes.*;
import shapes.circle.Circle;
import shapes.hexagon.HexagonAdapter;
import shapes.line.Line;
import shapes.point.Point;
import shapes.rectangle.Rectangle;
import shapes.square.Square;
import view.OptionsView;

public class OptionsController {

	private OptionsView optionsView;
	private Shape shape;
	private boolean isEndLinePoint = false;
	private Point pStartLinePoint;
	
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
				pStartLinePoint = new Point(e.getX(), e.getY());
				isEndLinePoint = true;
				JOptionPane.showMessageDialog(null, "Click on the line ending point!");
				
			}
			else {
				shape = new Line(pStartLinePoint, new Point(e.getX(), e.getY()));
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
			/*try {
				/*if(Integer.parseInt(optionsView.getTxtAdditionalOption1().getText())>0
						&& Integer.parseInt(optionsView.getTxtAdditionalOption2().getText())>0)
				{
					shape = new HexagonAdapter(new Point(e.getX(), e.getY()),
							Integer.parseInt(optionsView.getTxtAdditionalOption1().getText()),
							optionsView.getBtnBorderColorPicker().getSelectedColor(),
							optionsView.getBtnInnerColorPicker().getSelectedColor()
							);
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid input!");
					
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "R length has to be a number.");
			}*/
		};break;
		}
		return shape;
	
	}


	public void setOptionsView(OptionsView optionsView) {
		this.optionsView = optionsView;
	}


	public void handleShapeChange() {
		// change options dependng on type of shape
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
}
