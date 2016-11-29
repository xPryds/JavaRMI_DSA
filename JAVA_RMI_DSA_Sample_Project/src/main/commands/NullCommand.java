package main.commands;

import main.GameManager;

public class NullCommand implements ICommand {

	@Override
	public GameManager Execute(GameManager gameManager) {
		gameManager.setMessage("\nComando inv�lido. Escreva help para exibir a lista de comandos");
		return gameManager;
	}

}
