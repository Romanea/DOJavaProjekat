package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import controller.CanvasController;
import controller.CommandController;
import controller.OptionsController;
import controller.ToolsController;
import model.CommandModel;
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
	private ToolsController toolsController;
	private ToolsView toolsView= new ToolsView();
	private CommandController commandController; 
	private boolean selectionMode;
	
	public MainFrame() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// position on center of the screen
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - getWidth() / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - getHeight() / 2);
		setTitle("Design Patterns Project - Romanic Andrea IT20-2015");
		optionsController.setOptionsView(optionsView);
		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(optionsView, BorderLayout.NORTH);
		getContentPane().add(toolsView, BorderLayout.WEST);
		view.setBackground(Color.WHITE);
		
		events();
		
		
	}
	
	private void events()
	{
		selectionMode=false;

		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(!selectionMode)
				{
				canvasController.mousePressed(arg0, optionsController.getShapeOptions(arg0));
				repaint();
				}
			}
		});
		
		optionsView.getCmbShapePicker().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						optionsController.handleShapeChange();
					}
				});
		
		toolsView.getTglbtnSelect().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent ie) {
				if( ie.getStateChange() == ItemEvent.SELECTED)
				{
					selectionMode = true;
					toolsView.getLblInfo().setText("Mode: Selection");
					toolsView.getBtnDeleteAll().setEnabled(false);
						view.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent arg0) {
								if(selectionMode)
								toolsController.handleSelection(arg0);
							}
						});
					}
				else if( ie.getStateChange() == ItemEvent.DESELECTED)
				{
					toolsController.handeDeselection();
					toolsView.getLblInfo().setText("Mode: Drawing");
					selectionMode = false;
					
				}
				
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

	public CommandController getCommandController() {
		return commandController;
	}

	public void setCommandController(CommandController commandController) {
		this.commandController = commandController;
	}

	public ToolsController getToolsController() {
		return toolsController;
	}

	public void setToolsController(ToolsController toolsController) {
		this.toolsController = toolsController;
	}

	
	

	
	
}
