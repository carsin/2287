package dev.broystudios.towngame;

import dev.broystudios.towngame.graphics.Display;
import dev.broystudios.towngame.graphics.ui.Screen;

public class InstanceHandler {

	private static Game game;
	
	public static void init(Game game) {
		InstanceHandler.game = game;
	}
	
	public static Game getGame() {
		return game;
	}
	
	public static Time getTime() {
		return game.getTime();
	}
	
	public static Display getDisplay() {
		return game.getDisplay();
	}
	
	public static Screen getScreen() {
		return getDisplay().getScreen();
	}
	
}
