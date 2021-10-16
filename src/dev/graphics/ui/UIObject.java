package dev.graphics.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;


public abstract class UIObject {

	protected boolean hovering;
	protected Rectangle bounds;

	public abstract void tick();

	public abstract void render(Graphics g);

	public boolean getHovering() {
		return hovering;
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
		onClick();
	}
	
	public void mouseMoved(MouseEvent e) {
		if(bounds.contains(e.getX(), e.getY())) {
			hovering = true;
		} else {
			hovering = false;
		}
	}
	
	public abstract void onClick();

}
