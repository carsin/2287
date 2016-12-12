package dev.broystudios.towngame.graphics.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIHandler {

	private ArrayList<UIObject> uiObjects;
	
	public UIHandler() {
		uiObjects = new ArrayList<UIObject>();
	}
	
	public void tick() {
		for(UIObject uiObject : uiObjects) {
			uiObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(UIObject uiObject : uiObjects) {
			uiObject.render(g);
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		for(UIObject uiObject : uiObjects) {
			uiObject.mouseMoved(e);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		for(UIObject uiObject : uiObjects) {
			uiObject.mousePressed(e);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		for(UIObject uiObject : uiObjects) {
			uiObject.mouseReleased(e);
		}
	}
	
	public void add(UIObject uiObject) {
		uiObjects.add(uiObject);
	}
	
}
