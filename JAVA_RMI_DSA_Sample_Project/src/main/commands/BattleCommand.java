package main.commands;

import main.GameManager;
import main.server.model.Monster;
import main.server.model.Player;

public class BattleCommand implements ICommand {

	@Override
	public GameManager Execute(GameManager gameManager) {
		Player player = gameManager.getPlayer();
		if(player.inBattle()){
			gameManager.setMessage("Comando inválido.");
			return gameManager;
		}
		Monster monster = new Monster(100, 0, 15, 100, 8, "Demogorgon");
		player.startBattle(monster);
		gameManager.setPlayer(player);
		gameManager.setMessage("\n==========================="
							  +"\n=    Batalha iniciada!    ="
							  +"\n===========================" +"\n\n"
							  +"\n Você se deparou com um " + monster.getName() 
							  +"\n O que fará agora!??");
		return gameManager;
	}

}