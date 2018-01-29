package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import controller.CanvasController;
import controller.MouseClickedObserver;
import controller.OptionsController;
import controller.ToolsController;
import view.CanvasView;
import view.OptionsView;
import view.ToolsView;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CanvasView view = new CanvasView();
	private CanvasController canvasController;
	private OptionsController optionsController = new OptionsController();
	private OptionsView optionsView = new OptionsView();
	private ToolsController toolsController = new ToolsController();
	private ToolsView toolsView= new ToolsView();
	
	public MainFrame() {
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// position on center of the screen
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - getWidth() / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - getHeight() / 2);
		setTitle("Design Patterns Project - Romanic Andrea IT20-2015");
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				canvasController.mouseClicked(arg0, optionsController.getShapeOptions(arg0));
				repaint();
			}
		});
		
		optionsController.setOptionsView(optionsView);
		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(optionsView, BorderLayout.NORTH);
		getContentPane().add(toolsView, BorderLayout.WEST);
		view.setBackground(Color.WHITE);
		
		optionsView.getCmbShapePicker().addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						optionsController.handleShapeChange();
						
					}
			
				});
		
	}
	
	public CanvasView getView() {
		return view;
	}
	
	
	

	public CanvasController getCanvasController() {
		return canvasController;
	}

	public void setCanvasController(CanvasController canvasController) {
		this.canvasController = canvasController;
	}

	public OptionsView getOptionsView() {
		return optionsView;
	}

	public ToolsView getToolsView() {
		return toolsView;
	}
	

	
	
}
