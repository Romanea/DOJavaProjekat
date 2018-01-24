package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import utilities.ColorChooserButton;




public class OptionsView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ColorChooserButton btnBorderColorPicker;
	JLabel lblBorderColorPicker;
	private ColorChooserButton btnInnerColorPicker;
	JLabel lblInnerColorPicker;
	private JComboBox<String> cmbShapePicker;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gbc_shapePicker;
	private GridBagConstraints gbc_lblShapePicker;
	private GridBagConstraints gbc_lblBorderColor;
	private GridBagConstraints gbc_btnBorderColor;
	private GridBagConstraints gbc_lblInnerColor;
	private GridBagConstraints gbc_btnInnerColor;
	public static Color pBorderColor = Color.BLACK;
	public static Color pInnerColor = Color.WHITE;

	

	public OptionsView()
	{
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
	//OPTIONS:
			// combo box for picking shape
			JLabel lblShapePicker = new JLabel("Shape:");
			lblShapePicker.setFont(new Font("SansSerif", Font.PLAIN, 15));
			gbc_lblShapePicker = new GridBagConstraints();
			gbc_lblShapePicker.fill = GridBagConstraints.VERTICAL;
			gbc_lblShapePicker.insets = new Insets(0, 0, 0, 5);
			gbc_lblShapePicker.gridx = 0;
			gbc_lblShapePicker.gridy = 0;
			add(lblShapePicker, gbc_lblShapePicker);
			
			cmbShapePicker = new JComboBox<>();
			cmbShapePicker.setModel(new DefaultComboBoxModel<String>(new String[] {"Point", "Line", "Circle", "Square", "Rectangle", "Hexagon"}));
			gbc_shapePicker = new GridBagConstraints();
			gbc_shapePicker.fill = GridBagConstraints.VERTICAL;
			gbc_shapePicker.insets = new Insets(0, 0, 0, 5);
			gbc_shapePicker.gridx = 1;
			gbc_shapePicker.gridy = 0;
			add(cmbShapePicker, gbc_shapePicker);
			
			// colors
			lblBorderColorPicker = new JLabel("Border color:");
			lblBorderColorPicker.setFont(new Font("SansSerif", Font.PLAIN, 15));
			gbc_lblBorderColor = new GridBagConstraints();
			gbc_lblBorderColor.fill = GridBagConstraints.VERTICAL;
			gbc_lblBorderColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblBorderColor.gridx = 5;
			gbc_lblBorderColor.gridy = 0;
			add(lblBorderColorPicker, gbc_lblBorderColor);
			
			btnBorderColorPicker = new ColorChooserButton(Color.BLACK);
			gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.fill = GridBagConstraints.VERTICAL;
			gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnBorderColor.gridx = 6;
			gbc_btnBorderColor.gridy = 0;
			add(btnBorderColorPicker, gbc_btnBorderColor);
			
			
			
			lblInnerColorPicker = new JLabel("Inner color:");
			lblInnerColorPicker.setFont(new Font("SansSerif", Font.PLAIN, 15));
			gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.fill = GridBagConstraints.VERTICAL;
			gbc_lblInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblInnerColor.gridx = 10;
			gbc_lblInnerColor.gridy = 0;
			add(lblInnerColorPicker, gbc_lblInnerColor);
			
			btnInnerColorPicker = new ColorChooserButton(Color.WHITE);
			btnInnerColorPicker.setEnabled(false);
			gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.fill = GridBagConstraints.VERTICAL;
			gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnInnerColor.gridx = 11;
			gbc_btnInnerColor.gridy = 0;
			add(btnInnerColorPicker, gbc_btnInnerColor);
			
			

	}



	public ColorChooserButton getBtnBorderColorPicker() {
		return btnBorderColorPicker;
	}



	public void setBtnBorderColorPicker(ColorChooserButton btnBorderColorPicker) {
		this.btnBorderColorPicker = btnBorderColorPicker;
	}



	public ColorChooserButton getBtnInnerColorPicker() {
		return btnInnerColorPicker;
	}



	public void setBtnInnerColorPicker(ColorChooserButton btnInnerColorPicker) {
		this.btnInnerColorPicker = btnInnerColorPicker;
	}



	public static Color getpBorderColor() {
		return pBorderColor;
	}



	public static void setpBorderColor(Color pBorderColor) {
		OptionsView.pBorderColor = pBorderColor;
	}



	public static Color getpInnerColor() {
		return pInnerColor;
	}



	public static void setpInnerColor(Color pInnerColor) {
		OptionsView.pInnerColor = pInnerColor;
	}



	public JComboBox<String> getCmbShapePicker() {
		return cmbShapePicker;
	}
	
	
}
