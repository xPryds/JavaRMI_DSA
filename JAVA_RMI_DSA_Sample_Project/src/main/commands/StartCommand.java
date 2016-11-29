package main.commands;
import main.GameManager;

public class StartCommand implements ICommand {


	@Override
	public GameManager Execute(GameManager gameManager) {
		gameManager.setGameStarted(true);
		gameManager.setMessage("Jogo iniciado, o que irá fazer?");
		return gameManager;
	}

}
