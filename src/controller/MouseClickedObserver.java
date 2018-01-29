package controller;
import java.awt.event.MouseEvent;

import shapes.Shape;

public interface MouseClickedObserver {
	
		void mouseClicked(MouseEvent e);

		void mouseClicked(MouseEvent e, Shape shape);

}

