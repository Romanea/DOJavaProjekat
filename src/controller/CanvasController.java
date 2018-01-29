package controller;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import shapes.Command;
import shapes.Shape;
import app.MainFrame;
import model.ShapeModel;

public class CanvasController  {
	private MainFrame frame;
	private ShapeModel model;
	private Command command;

	public CanvasController(ShapeModel model, MainFrame frame ) {
		this.frame = frame;
		this.model = model;
	}

	
	public void mousePressed(MouseEvent e, Shape shape) {
		frame.getCommandController().generateAddCommand(shape, model).execute();
		
	}
	
	
	

}
