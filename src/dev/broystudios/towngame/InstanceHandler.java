package dev.broystudios.towngame;

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
	
}
