package main.commands;

import main.GameManager;
import main.server.model.Player;

public class BuyPotionCommand implements ICommand {

	@Override
	public GameManager Execute(GameManager gameManager) {
		Player player = gameManager.getPlayer();		
		if(!player.inBattle()){
			gameManager.setMessage("Comando inv�lido.");
			return gameManager;
		}
		int totalPotions = player.buyPotion();
		if(totalPotions == -1){
			gameManager.setMessage("Voc� precisa de 50Gold para comprar uma po��o!");
		} else{
			gameManager.setMessage("Voc� comprou uma po��o! Total: " + totalPotions );
		}
		gameManager.setPlayer(player);
		return gameManager;
	}

}
