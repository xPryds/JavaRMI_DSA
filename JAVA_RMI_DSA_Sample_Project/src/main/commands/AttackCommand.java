package main.commands;

import main.GameManager;
import main.server.model.Pair;
import main.server.model.Player;

public class AttackCommand implements ICommand {

	@Override
	public GameManager Execute(GameManager gameManager) {
		Player player = gameManager.getPlayer();
		if(!player.inBattle()){
			gameManager.setMessage("Comando inválido.");
			return gameManager;
		}
		Pair<Integer,Integer> attackResult = player.attackEnemy();
		
		StringBuilder builder = new StringBuilder("\n\nVocê atacou " + player.getCurrentEnemy().getName());
		builder.append("\nVocê fez um dano de ").append(player.getDamage());
		builder.append("\n\nO inimigo te atacou");
		builder.append("\nEle fez um dano de ").append(player.getCurrentEnemy().getDamage()).append("\n");
		
		builder.append("\nSua vida: ").append(attackResult.getRight());
		builder.append("\nVida do seu inimigo: ").append(attackResult.getLeft());
		
		
		if(player.getCurrentEnemy().isDead()){
			player.increaseMoney(50);
			builder.append("\nO inimigo morreu! \n");
			builder.append("\nVocê ganhou").append(player.getCurrentEnemy().getExp()).append(" pontos de experiência");
			builder.append("\nVocê conseguiu ").append(50).append(" gold.");
			builder.append("\nFim da batalha");
			player.finishBattle();
		}
		gameManager.setMessage(builder.toString());
		
		gameManager.setPlayer(player);
		return gameManager;
	}

}
