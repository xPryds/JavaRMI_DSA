package main;

import java.io.Serializable;

import main.server.model.Player;

public class GameManager implements Serializable {
    private static final long serialVersionUID = 1L;
	private Player player;
	private String message;
	private String soundPlaying;
	private boolean gameStarted;
	
	public GameManager(){
		this.player = new Player();
		this.message = "[Server] Jogo iniciado!";
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public void setSoundPlaying(String sound) {
		this.soundPlaying = sound;
	}

	public String getSoundPlaying() {
		return soundPlaying;
	}

	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
		
	}

	
}
