package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

import shapes.point.Point;
import app.MainFrame;
import model.ShapeModel;

public class CanvasController implements MouseClickedObserver{
	private MainFrame frame;
	private ShapeModel model;

	public CanvasController(ShapeModel model, MainFrame frame ) {
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		model.add(new Point(e.getX(), e.getY(), Color.PINK));
		
	}
	

}
