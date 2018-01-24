package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import controller.CanvasController;
import controller.MouseClickedObserver;
import view.CanvasView;
import view.OptionsView;
import view.ToolsView;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CanvasView view = new CanvasView();
	private CanvasController controller;
	private MouseClickedObserver observer;
	private OptionsView optionsView = new OptionsView();
	private ToolsView toolsView= new ToolsView();
	
	public MainFrame() {
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				observer.mouseClicked(arg0);
			}
		});
		
		
		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(optionsView, BorderLayout.NORTH);
		getContentPane().add(toolsView, BorderLayout.WEST);
		view.setBackground(Color.WHITE);
		
	}
	
	public CanvasView getView() {
		return view;
	}
	
	public void setController(CanvasController controller) {
		this.controller = controller;
	}
	
	public void setMouseClickedObserver(MouseClickedObserver observer) {
		this.observer = observer;
	}
	

	
	
}
