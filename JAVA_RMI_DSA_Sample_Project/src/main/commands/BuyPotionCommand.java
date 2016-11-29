package main.commands;

import main.GameManager;
import main.server.model.Player;

public class BuyPotionCommand implements ICommand {

	@Override
	public GameManager Execute(GameManager gameManager) {
		Player player = gameManager.getPlayer();		
		if(!player.inBattle()){
			gameManager.setMessage("Comando inválido.");
			return gameManager;
		}
		int totalPotions = player.buyPotion();
		if(totalPotions == -1){
			gameManager.setMessage("Você precisa de 50Gold para comprar uma poção!");
		} else{
			gameManager.setMessage("Você comprou uma poção! Total: " + totalPotions );
		}
		gameManager.setPlayer(player);
		return gameManager;
	}

}
