package main.commands;

import main.GameManager;
import main.server.model.Player;

public class HealCommand implements ICommand {

	@Override
	public GameManager Execute(GameManager gameManager) {
		Player player = gameManager.getPlayer();
		if(!player.inBattle()){
			gameManager.setMessage("Comando inválido.");
			return gameManager;
		}
		int healedHP = player.usePotion();
		if(healedHP == -1){
			gameManager.setMessage("Você não possui nenhuma poção!");
		} else{
			gameManager.setMessage("Você usou uma poção! Sua vida aumentou para " + healedHP);
		}
		gameManager.setPlayer(player);
		return gameManager;
	}

}
