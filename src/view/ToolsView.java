package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;




public class ToolsView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1555776200132795865L;
	private JToggleButton tglbtnSelect;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnDeleteAll;
	private JButton btnBringToBack;
	private JButton btnSendToFront;
	private JButton btnBringToFront;
	private JButton btnSendToBack;
	private JButton btnUndo;
	private JButton btnRedo;
	private JLabel lblInfo;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gbc_select;
	private GridBagConstraints gbc_modify;
	private GridBagConstraints gbc_delete;
	private GridBagConstraints gbc_deleteAll;
	private GridBagConstraints gbc_bringToFront;
	private GridBagConstraints gbc_bringToBack;
	private GridBagConstraints gbc_sendToFront;
	private GridBagConstraints gbc_sendToBack;
	private GridBagConstraints gbc_undo;
	private GridBagConstraints gbc_redo;
	private GridBagConstraints gbc_info;

	public ToolsView() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0,0.0,0.0,0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		tglbtnSelect = new JToggleButton("Select");
		gbc_select = new GridBagConstraints();
		gbc_select.fill = GridBagConstraints.HORIZONTAL;
		gbc_select.insets = new Insets(0, 0, 0, 5);
		gbc_select.gridx = 0;
		gbc_select.gridy = 0;
		add(tglbtnSelect, gbc_select);
		
		btnModify = new JButton("Modify");
		btnModify.setEnabled(false);
		gbc_modify = new GridBagConstraints();
		gbc_modify.fill = GridBagConstraints.HORIZONTAL;
		gbc_modify.insets = new Insets(0, 0, 0, 5);
		gbc_modify.gridx = 0;
		gbc_modify.gridy = 1;
		add(btnModify, gbc_modify);
		
		
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		gbc_delete = new GridBagConstraints();
		gbc_delete.fill = GridBagConstraints.HORIZONTAL;
		gbc_delete.insets = new Insets(0, 0, 0, 5);
		gbc_delete.gridx = 0;
		gbc_delete.gridy = 2;
		add(btnDelete, gbc_delete);

		btnDeleteAll = new JButton("Delete all");
		gbc_deleteAll = new GridBagConstraints();
		gbc_deleteAll.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteAll.insets = new Insets(0, 0, 0, 5);
		gbc_deleteAll.gridx =0;
		gbc_deleteAll.gridy =3;
		add(btnDeleteAll, gbc_deleteAll);

		
		
		lblInfo = new JLabel("");
		lblInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInfo.setBackground(Color.LIGHT_GRAY);
		gbc_info = new GridBagConstraints();
		gbc_info.insets = new Insets(0, 0, 0, 5);
		gbc_info.gridx = 0;
		gbc_info.gridy = 9;
		add(lblInfo, gbc_info);
		lblInfo.setText("Mode: Drawing");
		
		btnBringToFront = new JButton("Bring to front");
		btnBringToFront.setEnabled(false);
		gbc_bringToFront = new GridBagConstraints();
		gbc_bringToFront.fill = GridBagConstraints.HORIZONTAL;
		gbc_bringToFront.insets = new Insets(0, 0, 0, 5);
		gbc_bringToFront.gridx =0;
		gbc_bringToFront.gridy =4;
		add(btnBringToFront, gbc_bringToFront);
		
		btnBringToBack = new JButton("Bring to back");
		btnBringToBack.setEnabled(false);
		gbc_bringToBack = new GridBagConstraints();
		gbc_bringToBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_bringToBack.insets = new Insets(0, 0, 0, 5);
		gbc_bringToBack.gridx =0;
		gbc_bringToBack.gridy =5;
		add(btnBringToBack, gbc_bringToBack);
		
		btnSendToFront = new JButton("Send to front");
		btnSendToFront.setEnabled(false);
		gbc_sendToFront = new GridBagConstraints();
		gbc_sendToFront.fill = GridBagConstraints.HORIZONTAL;
		gbc_sendToFront.insets = new Insets(0, 0, 0, 5);
		gbc_sendToFront.gridx =0;
		gbc_sendToFront.gridy =6;
		add(btnSendToFront, gbc_sendToFront);
		
		btnSendToBack = new JButton("Send to back");
		btnSendToBack.setEnabled(false);
		gbc_sendToBack = new GridBagConstraints();
		gbc_sendToBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_sendToBack.insets = new Insets(0, 0, 0, 5);
		gbc_sendToBack.gridx =0;
		gbc_sendToBack.gridy =7;
		add(btnSendToBack, gbc_sendToBack);
		
		btnUndo = new JButton("Undo");
		gbc_undo = new GridBagConstraints();
		gbc_undo.fill = GridBagConstraints.HORIZONTAL;
		gbc_undo.insets = new Insets(0, 0, 0, 5);
		gbc_undo.gridx =0;
		gbc_undo.gridy =11;
		add(btnUndo, gbc_undo);
		
		btnRedo = new JButton("Redo");
		gbc_redo = new GridBagConstraints();
		gbc_redo.fill = GridBagConstraints.HORIZONTAL;
		gbc_redo.insets = new Insets(0, 0, 0, 5);
		gbc_redo.gridx =0;
		gbc_redo.gridy =12;
		add(btnRedo, gbc_redo);
		
	
		
	}

	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}

	public JButton getBtnSendToFront() {
		return btnSendToFront;
	}

	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}

	public JButton getBtnSendToBack() {
		return btnSendToBack;
	}

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

	public JLabel getLblInfo() {
		return lblInfo;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnDeleteAll() {
		return btnDeleteAll;
	}
	
	
	
	

}
