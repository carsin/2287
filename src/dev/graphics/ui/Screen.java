package dev.graphics.ui;

import java.awt.Color;
import java.awt.Graphics;

public class Screen {

	public String[] history;

	public Screen() {
		history = new String[256];
	}

	public void render(Graphics g) {

		for (int i = history.length - 1; i >= 0; i--) {

			if (history[i] != null) {
//				g.setColor(new Color(255, 255, 255, (int) Math.min(Math.max((int) Math.pow(i, -i / 10) * 255, 0), 255)));
				g.setColor(new Color(255, 255, 255, Math.max(Math.min(255 - i * 16, 255), 0)));
				g.drawString(history[i], 10, (i * 20) + 20);
			}

		}

	}

	public void print(String text) {
		for (int i = history.length - 1; i >= 0; i--) {
			try {
				if (history[i - 1] != null)
					history[i] = history[i - 1];
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}
		}
		history[0] = text;
	}

	public void println(String text) {
		print(text + "\n");
	}

}
