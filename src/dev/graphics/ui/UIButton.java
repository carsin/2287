package dev.graphics.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class UIButton extends UIObject {

	private Color buttonColor;
	private ClickListener clickListener;
	private String text;

	public UIButton(int x, int y, int width, int height, Color buttonColor, String text, ClickListener clickListener) {
		this.buttonColor = buttonColor;
		this.clickListener = clickListener;
		this.text = text;
		bounds = new Rectangle(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {

		g.setColor(buttonColor);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		g.setColor(Color.BLACK);
		g.drawString(text, bounds.x + 5, bounds.y + 15);

	}

	@Override
	public void tick() {

	}

	@Override
	public void onClick() {
		clickListener.onClick();
	}

}
