package main.commands;

import main.GameManager;

public interface ICommand {
	GameManager Execute(GameManager player);
}
