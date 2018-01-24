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




public class ToolsView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1555776200132795865L;
	private JToggleButton tglbtnSelect;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnDeleteAll;
	private JLabel lblInfo;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gbc_select;
	private GridBagConstraints gbc_modify;
	private GridBagConstraints gbc_delete;
	private GridBagConstraints gbc_deleteAll;
	private GridBagConstraints gbc_info;

	public ToolsView() {
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_info.gridy = 4;
		add(lblInfo, gbc_info);
		lblInfo.setText("Mode: Drawing");
		
	
		
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
	
	
	
	

}
