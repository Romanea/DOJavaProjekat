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
import view.LoggerView;
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
	private LoggerView logView = new LoggerView();

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
		getContentPane().add(logView, BorderLayout.SOUTH);

		view.setBackground(Color.WHITE);
		
		events();
		
		
	}
	
	private void events()
	{
		selectionMode=false;
		
		// CANVAS DRAWING

		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(!selectionMode){
				canvasController.mousePressed(arg0, optionsController.getShapeOptions(arg0));
				repaint();
				}
				else {
					toolsController.handleSelection(arg0);
				}
			}
		});
		
		//SHAPE PICKER
		
		optionsView.getCmbShapePicker().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						optionsController.handleShapeChange();
					}
				});
		
		//SELECT
		
		toolsView.getTglbtnSelect().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent ie) {
				if( ie.getStateChange() == ItemEvent.SELECTED)
				{
					selectionMode = true;
					//toolsController.handleSelection();
					toolsView.getLblInfo().setText("Mode: Selection");
					getOptionsView().setEnabled(false);
					toolsView.getBtnDeleteAll().setEnabled(false);
					toolsView.getBtnDelete().setEnabled(true);
					toolsView.getBtnModify().setEnabled(true);
					toolsView.getBtnBringToBack().setEnabled(true);
					toolsView.getBtnBringToFront().setEnabled(true);
					toolsView.getBtnSendToBack().setEnabled(true);
					toolsView.getBtnSendToFront().setEnabled(true);



					
				}
				else if( ie.getStateChange() == ItemEvent.DESELECTED)
				{
					toolsController.handeDeselection();
					toolsView.getLblInfo().setText(" Mode:  Drawing");
					getOptionsView().setEnabled(true);
					toolsView.getBtnDelete().setEnabled(false);
					toolsView.getBtnModify().setEnabled(false);
					toolsView.getBtnDeleteAll().setEnabled(true);
					toolsView.getBtnBringToBack().setEnabled(false);
					toolsView.getBtnBringToFront().setEnabled(false);
					toolsView.getBtnSendToBack().setEnabled(false);
					toolsView.getBtnSendToFront().setEnabled(false);
					selectionMode = false;
					
				}
				
			}
		});
		
		//MODIFY
		toolsView.getBtnModify().addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				toolsController.handleModify();
				
			}
			
		});
		
		//DELETE
		toolsView.getBtnDelete().addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				toolsController.handleDelete();
				
			}
			
		});
		
		//DELETE ALL
				toolsView.getBtnDeleteAll().addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						toolsController.handleDeleteAll();	
					}
					
				});
				
		// BRING TO FRONT
				toolsView.getBtnBringToFront().addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						toolsController.handleBringToFront();	
					}
					
				});
		// BRING TO BACK
				toolsView.getBtnBringToBack().addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						toolsController.handleBringToBack();	
					}
					
				});
				
		// SEND TO FRONT
				toolsView.getBtnSendToFront().addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						toolsController.handleSendToFront();	
					}
					
				});
		// SEND TO BACK
				toolsView.getBtnSendToBack().addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						toolsController.handleSendToBack();	
					}
					
				});
				
		// UNDO
				
				toolsView.getBtnUndo().addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						toolsController.handleUndo();	
					}
					
				});
				
				
		//REDO
				
				toolsView.getBtnRedo().addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						toolsController.handleRedo();	
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

	public LoggerView getLogView() {
		return this.logView;
	}
	

	
	
}
