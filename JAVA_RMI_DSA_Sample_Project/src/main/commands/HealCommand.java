package main.commands;

import main.GameManager;
import main.server.model.Player;

public class HealCommand implements ICommand {

	@Override
	public GameManager Execute(GameManager gameManager) {
		Player player = gameManager.getPlayer();
		if(!player.inBattle()){
			gameManager.setMessage("Comando inv�lido.");
			return gameManager;
		}
		int healedHP = player.usePotion();
		if(healedHP == -1){
			gameManager.setMessage("Voc� n�o possui nenhuma po��o!");
		} else{
			gameManager.setMessage("Voc� usou uma po��o! Sua vida aumentou para " + healedHP);
		}
		gameManager.setPlayer(player);
		return gameManager;
	}

}
