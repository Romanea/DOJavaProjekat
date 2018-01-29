package view;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import model.ShapeModel;
import shapes.Shape;

public class CanvasView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShapeModel model;
	
	public CanvasView() {
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (model != null) {
			Iterator<Shape> it = model.getShapes().iterator();
			while (it.hasNext()) {
				it.next().draw(g);
			}

		}
	}

	public void setModel(ShapeModel model) {
		this.model = model;
	}
}
