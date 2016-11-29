package main.commands;

import main.GameManager;

public class HelpCommand implements ICommand {

	@Override
	public GameManager Execute(GameManager gameManager) {
		if(gameManager.getPlayer().inBattle())
			gameManager.setMessage("\n============================"
							 	+ "\n=   Comandos poss�veis     =" +
							 	"\n============================\n\n" +
							 	"fugir: tenta fugir da batalha \n\natacar: ataca o inimigo \n\ncurar: usar uma Pocao \n\ncomprarCura: comprar 1x Pocao (50G) \n\nhelp: mostra todos comandos dispon�veis no momento"+ "");
		else if(gameManager.isGameStarted())
			gameManager.setMessage("\n============================"
							 	+ "\n=   Comandos poss�veis     =" +
							 	"\n============================\n\n" +
							 	"batalhar: Inicia uma nova batalha\n\nhelp: mostra todos comandos dispon�veis no momento\n\n");
		else{
			gameManager.setMessage("\n============================"
				 	+ "\n=   Comandos poss�veis     =" +
				 	"\n============================\n\n" +
				 	"iniciar: Inicia um novo jogo\n\nhelp: mostra todos comandos dispon�veis no momento\n\n");

		}
		return gameManager;
	}

}
