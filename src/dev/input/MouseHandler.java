package dev.broystudios.towngame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.broystudios.towngame.InstanceHandler;

public class MouseHandler implements MouseListener, MouseMotionListener {

	private int mouseX, mouseY;
	private boolean[] clicked;
	
	public MouseHandler() {
		clicked = new boolean[5];
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		InstanceHandler.getUIHandler().mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		try {
		InstanceHandler.getUIHandler().mouseMoved(e);
		} catch(Exception e1) {
		System.out.println(InstanceHandler.getUIHandler());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		clicked[e.getButton()] = true;
		InstanceHandler.getUIHandler().mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		clicked[e.getButton()] = false;
		InstanceHandler.getUIHandler().mouseReleased(e);
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}

}
