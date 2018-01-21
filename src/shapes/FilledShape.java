package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class FilledShape extends Shape {
	private String strInnerColor = "white";
	private Color clrInnerColor = Color.WHITE;
	
	public abstract void fill(Graphics g);

	public String getStrInnerColor() {
		return strInnerColor;
	}

	public void setStrInnerColor(String strInnerColor) {
		this.strInnerColor = strInnerColor;
	}

	public Color getClrInnerColor() {
		return clrInnerColor;
	}

	public void setClrInnerColor(Color clrInnerColor) {
		this.clrInnerColor = clrInnerColor;
	}



	
	
	


}
