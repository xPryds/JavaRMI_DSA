package main.commands;

import main.GameManager;
import main.server.model.Player;

public class RunCommand implements ICommand {

	@Override
	public GameManager Execute(GameManager gameManager) {
		Player player = gameManager.getPlayer();
		if(!player.inBattle()){
			gameManager.setMessage("Comando inv�lido.");
			return gameManager;
		}
		player.finishBattle();
		gameManager.setMessage("Voc� fugiu");
		return gameManager;
	}

}
