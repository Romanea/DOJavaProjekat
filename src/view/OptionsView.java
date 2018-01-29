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
import javax.swing.JTextField;
import javax.swing.UIManager;
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
	private JLabel lblAdditionalOption1;
	private JTextField txtAdditionalOption1;
	private GridBagConstraints gbc_AdditionalOption1;
	private GridBagConstraints gbc_txtAdditionalOption1;
	private JLabel lblAdditionalOption2;
	private GridBagConstraints gbc_AdditionalOption2;
	private JTextField txtAdditionalOption2;
	private GridBagConstraints gbc_txtAdditionalOption2;
	public static Color pBorderColor = Color.BLACK;
	public static Color pInnerColor = Color.WHITE;

	

	@SuppressWarnings("deprecation")
	public OptionsView()
	{
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0,0,0,0};
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
	//OPTIONS:
			// combo box for picking shape
			JLabel lblShapePicker = new JLabel("Shape:");
			lblShapePicker.setFont(new Font("SansSerif", Font.PLAIN, 15));
			gbc_lblShapePicker = new GridBagConstraints();
			gbc_lblShapePicker.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblShapePicker.insets = new Insets(0, 0, 0, 5);
			gbc_lblShapePicker.gridx = 0;
			gbc_lblShapePicker.gridy = 0;
			add(lblShapePicker, gbc_lblShapePicker);
			
			cmbShapePicker = new JComboBox<>();
			cmbShapePicker.setModel(new DefaultComboBoxModel<String>(new String[] {"Point", "Line", "Circle", "Square", "Rectangle", "Hexagon"}));
			gbc_shapePicker = new GridBagConstraints();
			gbc_shapePicker.fill = GridBagConstraints.HORIZONTAL;
			gbc_shapePicker.insets = new Insets(0, 0, 0, 5);
			gbc_shapePicker.gridx = 1;
			gbc_shapePicker.gridy = 0;
			add(cmbShapePicker, gbc_shapePicker);
			
			// colors
			lblBorderColorPicker = new JLabel("Border color:");
			lblBorderColorPicker.setFont(new Font("SansSerif", Font.PLAIN, 15));
			gbc_lblBorderColor = new GridBagConstraints();
			gbc_lblBorderColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblBorderColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblBorderColor.gridx = 2;
			gbc_lblBorderColor.gridy = 0;
			add(lblBorderColorPicker, gbc_lblBorderColor);
			
			btnBorderColorPicker = new ColorChooserButton(Color.BLACK);
			gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnBorderColor.gridx = 3;
			gbc_btnBorderColor.gridy = 0;
			add(btnBorderColorPicker, gbc_btnBorderColor);
			
			
			
			lblInnerColorPicker = new JLabel("Inner color:");
			lblInnerColorPicker.setFont(new Font("SansSerif", Font.PLAIN, 15));
			gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblInnerColor.gridx = 4;
			gbc_lblInnerColor.gridy = 0;
			add(lblInnerColorPicker, gbc_lblInnerColor);
			
			btnInnerColorPicker = new ColorChooserButton(Color.WHITE);
			btnInnerColorPicker.setEnabled(false);
			gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnInnerColor.gridx = 5;
			gbc_btnInnerColor.gridy = 0;
			add(btnInnerColorPicker, gbc_btnInnerColor);
			
			lblAdditionalOption1 = new JLabel("first");
			lblAdditionalOption1.setFont(new Font("SansSerif", Font.PLAIN, 15));
			lblAdditionalOption1.hide();
			gbc_AdditionalOption1 = new GridBagConstraints();
			gbc_AdditionalOption1.fill = GridBagConstraints.HORIZONTAL;
			gbc_AdditionalOption1.insets = new Insets(0, 0, 0, 5);
			gbc_AdditionalOption1.gridx = 6;
			gbc_AdditionalOption1.gridy = 0;
			add(lblAdditionalOption1, gbc_AdditionalOption1);
			
			txtAdditionalOption1 = new JTextField("50");
			txtAdditionalOption1.setEnabled(true);
			txtAdditionalOption1.hide();
			gbc_txtAdditionalOption1 = new GridBagConstraints();
			gbc_txtAdditionalOption1.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAdditionalOption1.insets = new Insets(0, 0, 0, 5);
			gbc_txtAdditionalOption1.gridx = 7;
			gbc_txtAdditionalOption1.gridy = 0;
			add(txtAdditionalOption1, gbc_txtAdditionalOption1);
			
			lblAdditionalOption2 = new JLabel("second");
			lblAdditionalOption2.setFont(new Font("SansSerif", Font.PLAIN, 15));
			lblAdditionalOption2.hide();
			gbc_AdditionalOption2 = new GridBagConstraints();
			gbc_AdditionalOption2.fill = GridBagConstraints.HORIZONTAL;
			gbc_AdditionalOption2.insets = new Insets(0, 0, 0, 5);
			gbc_AdditionalOption2.gridx = 8;
			gbc_AdditionalOption2.gridy = 0;
			add(lblAdditionalOption2, gbc_AdditionalOption2);
			
			txtAdditionalOption2 = new JTextField("50");
			txtAdditionalOption2.setEnabled(true);
			txtAdditionalOption2.hide();
			gbc_txtAdditionalOption2 = new GridBagConstraints();
			gbc_txtAdditionalOption2.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAdditionalOption2.insets = new Insets(0, 0, 0, 5);
			gbc_txtAdditionalOption2.gridx = 9;
			gbc_txtAdditionalOption2.gridy = 0;
			add(txtAdditionalOption2, gbc_txtAdditionalOption2);
			
			

	}

	public void setEnabled(boolean setEnabled)
	{
		//TODO implement
	}

	public JLabel getLblAdditionalOption1() {
		return lblAdditionalOption1;
	}



	public void setLblAdditionalOption1(JLabel lblAdditionalOption1) {
		this.lblAdditionalOption1 = lblAdditionalOption1;
	}



	public JTextField getTxtAdditionalOption1() {
		return txtAdditionalOption1;
	}



	public void setTxtAdditionalOption1(JTextField txtAdditionalOption1) {
		this.txtAdditionalOption1 = txtAdditionalOption1;
	}



	public JLabel getLblAdditionalOption2() {
		return lblAdditionalOption2;
	}



	public void setLblAdditionalOption2(JLabel lblAdditionalOption2) {
		this.lblAdditionalOption2 = lblAdditionalOption2;
	}



	public JTextField getTxtAdditionalOption2() {
		return txtAdditionalOption2;
	}



	public void setTxtAdditionalOption2(JTextField txtAdditionalOption2) {
		this.txtAdditionalOption2 = txtAdditionalOption2;
	}



	public void setCmbShapePicker(JComboBox<String> cmbShapePicker) {
		this.cmbShapePicker = cmbShapePicker;
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
