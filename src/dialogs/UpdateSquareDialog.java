package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.circle.Circle;
import shapes.line.Line;
import shapes.point.Point;
import shapes.square.Square;
import utilities.ColorChooserButton;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;


public class UpdateSquareDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Square square;
	private JTextField txtToX;
	private JTextField txtForX;
	private JTextField txtBX;
	private JTextField txtToY;
	private JTextField txtForY;
	private JTextField txtBY;
	private JTextField txtBLength;
	private JComboBox cmbSquare;
	private JTextField txtForLength;
	private JTextField txtToLength;
	private ColorChooserButton btnOutlineColor;
	private ColorChooserButton btnInteriorColor;
	private Color changedOutlineColor;
	private Color changedInteriorColor;

	public UpdateSquareDialog(Square sqr) {
		setTitle("Update square");
		square=new Square(sqr.getUpperLeft(), sqr.getSideLength(), sqr.getBorderColor(), sqr.getClrInnerColor());
		changedInteriorColor=square.getClrInnerColor();
		changedOutlineColor=square.getBorderColor();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblMove = new JLabel("Update:");
			GridBagConstraints gbc_lblMove = new GridBagConstraints();
			gbc_lblMove.insets = new Insets(0, 0, 5, 5);
			gbc_lblMove.gridx = 1;
			gbc_lblMove.gridy = 1;
			contentPanel.add(lblMove, gbc_lblMove);
		}
		{
			cmbSquare = new JComboBox();
			
			GridBagConstraints gbc_cmbSquare = new GridBagConstraints();
			gbc_cmbSquare.insets = new Insets(0, 0, 5, 5);
			gbc_cmbSquare.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbSquare.gridx = 3;
			gbc_cmbSquare.gridy = 1;
			contentPanel.add(cmbSquare, gbc_cmbSquare);
		}
		{
			JLabel lblCoordinateX = new JLabel("Coordinate Center X:");
			GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
			gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateX.gridx = 3;
			gbc_lblCoordinateX.gridy = 2;
			contentPanel.add(lblCoordinateX, gbc_lblCoordinateX);
		}
		{
			JLabel lblCoordinateY = new JLabel("Coordinate Center Y:");
			GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
			gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateY.gridx = 5;
			gbc_lblCoordinateY.gridy = 2;
			contentPanel.add(lblCoordinateY, gbc_lblCoordinateY);
		}
		{
			JLabel lblLength = new JLabel("Length:");
			GridBagConstraints gbc_lblLength = new GridBagConstraints();
			gbc_lblLength.insets = new Insets(0, 0, 5, 0);
			gbc_lblLength.gridx = 7;
			gbc_lblLength.gridy = 2;
			contentPanel.add(lblLength, gbc_lblLength);
		}
		{
			JLabel lblTo = new JLabel("Move to:");
			GridBagConstraints gbc_lblTo = new GridBagConstraints();
			gbc_lblTo.insets = new Insets(0, 0, 5, 5);
			gbc_lblTo.gridx = 1;
			gbc_lblTo.gridy = 3;
			contentPanel.add(lblTo, gbc_lblTo);
		}
		{
			txtToX = new JTextField();
			GridBagConstraints gbc_txtToX = new GridBagConstraints();
			gbc_txtToX.insets = new Insets(0, 0, 5, 5);
			gbc_txtToX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtToX.gridx = 3;
			gbc_txtToX.gridy = 3;
			contentPanel.add(txtToX, gbc_txtToX);
			txtToX.setColumns(10);
		}
		{
			txtToY = new JTextField();
			GridBagConstraints gbc_txtToY = new GridBagConstraints();
			gbc_txtToY.insets = new Insets(0, 0, 5, 5);
			gbc_txtToY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtToY.gridx = 5;
			gbc_txtToY.gridy = 3;
			contentPanel.add(txtToY, gbc_txtToY);
			txtToY.setColumns(10);
		}
		{
			txtToLength = new JTextField();
			GridBagConstraints gbc_txtLength = new GridBagConstraints();
			gbc_txtLength.insets = new Insets(0, 0, 5, 0);
			gbc_txtLength.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtLength.gridx = 7;
			gbc_txtLength.gridy = 3;
			contentPanel.add(txtToLength, gbc_txtLength);
			txtToLength.setColumns(10);
		}
		{
			JLabel lblFor = new JLabel("Move for:");
			GridBagConstraints gbc_lblFor = new GridBagConstraints();
			gbc_lblFor.insets = new Insets(0, 0, 5, 5);
			gbc_lblFor.gridx = 1;
			gbc_lblFor.gridy = 4;
			contentPanel.add(lblFor, gbc_lblFor);
		}
		{
			txtForX = new JTextField();
			GridBagConstraints gbc_txtForX = new GridBagConstraints();
			gbc_txtForX.insets = new Insets(0, 0, 5, 5);
			gbc_txtForX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtForX.gridx = 3;
			gbc_txtForX.gridy = 4;
			contentPanel.add(txtForX, gbc_txtForX);
			txtForX.setColumns(10);
		}
		{
			txtForY = new JTextField();
			GridBagConstraints gbc_txtForY = new GridBagConstraints();
			gbc_txtForY.insets = new Insets(0, 0, 5, 5);
			gbc_txtForY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtForY.gridx = 5;
			gbc_txtForY.gridy = 4;
			contentPanel.add(txtForY, gbc_txtForY);
			txtForY.setColumns(10);
		}
		{
			txtForLength = new JTextField();
			GridBagConstraints gbc_txtForLength = new GridBagConstraints();
			gbc_txtForLength.insets = new Insets(0, 0, 5, 0);
			gbc_txtForLength.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtForLength.gridx = 7;
			gbc_txtForLength.gridy = 4;
			contentPanel.add(txtForLength, gbc_txtForLength);
			txtForLength.setColumns(10);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 5;
			contentPanel.add(label, gbc_label);
		}
		{
			JLabel lblBasicUpdate = new JLabel("Basic update:");
			GridBagConstraints gbc_lblBasicUpdate = new GridBagConstraints();
			gbc_lblBasicUpdate.insets = new Insets(0, 0, 5, 5);
			gbc_lblBasicUpdate.gridx = 1;
			gbc_lblBasicUpdate.gridy = 6;
			contentPanel.add(lblBasicUpdate, gbc_lblBasicUpdate);
		}
		{
			txtBX = new JTextField();
			GridBagConstraints gbc_txtBX = new GridBagConstraints();
			gbc_txtBX.insets = new Insets(0, 0, 5, 5);
			gbc_txtBX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBX.gridx = 3;
			gbc_txtBX.gridy = 6;
			contentPanel.add(txtBX, gbc_txtBX);
			txtBX.setColumns(10);
		}
		{
			txtBY = new JTextField();
			GridBagConstraints gbc_txtBY = new GridBagConstraints();
			gbc_txtBY.insets = new Insets(0, 0, 5, 5);
			gbc_txtBY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBY.gridx = 5;
			gbc_txtBY.gridy = 6;
			contentPanel.add(txtBY, gbc_txtBY);
			txtBY.setColumns(10);
		}
		{
			txtBLength = new JTextField();
			GridBagConstraints gbc_txtBLength = new GridBagConstraints();
			gbc_txtBLength.insets = new Insets(0, 0, 5, 0);
			gbc_txtBLength.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBLength.gridx = 7;
			gbc_txtBLength.gridy = 6;
			contentPanel.add(txtBLength, gbc_txtBLength);
			txtBLength.setColumns(10);
		}
		{
			JLabel lblColors = new JLabel("Colors: ");
			GridBagConstraints gbc_lblColors = new GridBagConstraints();
			gbc_lblColors.insets = new Insets(0, 0, 0, 5);
			gbc_lblColors.gridx = 1;
			gbc_lblColors.gridy = 7;
			contentPanel.add(lblColors, gbc_lblColors);
		}
		{
			btnOutlineColor = new ColorChooserButton(changedOutlineColor);
			GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
			gbc_btnOutlineColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnOutlineColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnOutlineColor.gridx = 3;
			gbc_btnOutlineColor.gridy = 7;
			contentPanel.add(btnOutlineColor, gbc_btnOutlineColor);
		}
		{
			btnInteriorColor= new ColorChooserButton(changedInteriorColor);
			GridBagConstraints gbc_btnInteriorColor = new GridBagConstraints();
			gbc_btnInteriorColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnInteriorColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnInteriorColor.gridx = 5;
			gbc_btnInteriorColor.gridy = 7;
			contentPanel.add(btnInteriorColor, gbc_btnInteriorColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						if(cmbSquare.getSelectedItem().toString().equals("Move for") && (txtForX.getText().isEmpty() || txtForY.getText().isEmpty()) ) {
						
								JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
										JOptionPane.WARNING_MESSAGE);
							
						} else if(cmbSquare.getSelectedItem().toString().equals("Move to") && (txtToX.getText().isEmpty() || txtToY.getText().isEmpty())){
							JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
									JOptionPane.WARNING_MESSAGE);
						} else if(cmbSquare.getSelectedItem().toString().equals("Basic update") && (txtBX.getText().isEmpty() || txtBY.getText().isEmpty() || txtBLength.getText().isEmpty())) {
							
								JOptionPane.showMessageDialog(null, "Fill empty spaces!", "Error!",
										JOptionPane.WARNING_MESSAGE);
						} 
						else {
							try {
							
							Object[] option = { "Yes", "No" };
							int answer = JOptionPane.showOptionDialog(null,
									"Are you sure that you want to update this object?",
									"Choose one option:", JOptionPane.YES_NO_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);
							if (answer == 0) {
								
								if (cmbSquare.getSelectedItem().toString().equals("Basic update")) {
									square.getUpperLeft().setX(Integer.parseInt(txtBX.getText()));
									square.getUpperLeft().setY(Integer.parseInt(txtBY.getText()));
									square.setSideLength(Integer.parseInt(txtBLength.getText()));
									
									
								}

								if (cmbSquare.getSelectedItem().toString().equals("Move for")) {
									square.moveBy(Integer.parseInt(txtForX.getText()), Integer.parseInt(txtForY.getText()));
		
								} 
								
								if (cmbSquare.getSelectedItem().toString().equals("Move to")) {
									square.moveTo(Integer.parseInt(txtToX.getText()), Integer.parseInt(txtToY.getText()));
		
								}
								
								square.setBorderColor(btnOutlineColor.getSelectedColor());
								square.setClrInnerColor(btnInteriorColor.getSelectedColor());
								setVisible(false);
							}
							
							}
							catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Only numbers are allowed!", "Error",
										JOptionPane.ERROR_MESSAGE);

							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int answer = JOptionPane.showConfirmDialog(null, "Are you sure that you want to cancel?",
								"Choose one option:",
								JOptionPane.INFORMATION_MESSAGE);
						if (answer == JOptionPane.OK_OPTION) {
							setVisible(false);
							cancel();
							dispose();
						}

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);			}
		}
		cmbSquare.setModel(new DefaultComboBoxModel(new String[] {"Basic update", "Move to", "Move for"}));
		txtForX.setEditable(false);
		txtForY.setEditable(false);
		txtBX.setEditable(true);
		txtBY.setEditable(true);
		txtToLength.setEditable(false);
		txtBLength.setEditable(true);
		txtForLength.setEditable(false);
		txtToX.setEditable(false);
		txtToY.setEditable(false);
		
		txtToX.setText(String.valueOf(this.square.getUpperLeft().getX()));
		txtToY.setText(String.valueOf(this.square.getUpperLeft().getY()));
		txtToLength.setText(String.valueOf(this.square.getSideLength()));
		txtForX.setText(String.valueOf(this.square.getUpperLeft().getX()));
		txtForY.setText(String.valueOf(this.square.getUpperLeft().getY()));
		txtForLength.setText(String.valueOf(this.square.getSideLength()));
		txtBX.setText(String.valueOf(this.square.getUpperLeft().getX()));
		txtBY.setText(String.valueOf(this.square.getUpperLeft().getY()));
		txtBLength.setText(String.valueOf(this.square.getSideLength()));

		cmbSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cmbSquare.getSelectedItem().toString().equals("Move for")) {
					txtToX.setEditable(false);
					txtToY.setEditable(false);
					txtBX.setEditable(false);
					txtBY.setEditable(false);
					txtForX.setEditable(true);
					txtForY.setEditable(true);
					txtBLength.setEditable(false);
					txtToLength.setEditable(false);
					txtForLength.setEditable(false);
				} else if(cmbSquare.getSelectedItem().toString().equals("Move to")){
					txtToX.setEditable(true);
					txtToY.setEditable(true);
					txtBX.setEditable(false);
					txtBY.setEditable(false);
					txtForX.setEditable(false);
					txtForY.setEditable(false);
					txtBLength.setEditable(false);
					txtToLength.setEditable(false);
					txtForLength.setEditable(false);
				} else {
				
					txtToX.setEditable(false);
					txtToY.setEditable(false);
					txtBX.setEditable(true);
					txtBY.setEditable(true);
					txtForX.setEditable(false);
					txtForY.setEditable(false);
					txtBLength.setEditable(true);
					txtToLength.setEditable(false);
					txtForLength.setEditable(false);
				}
				
				
			}
		});
		
		
	
		
	
		pack();
		setVisible(true);
		
	}

	public Square getSquare() {
		return square;
	}
	
	public void cancel() {
		square = null;
	}
}
