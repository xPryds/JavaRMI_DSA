package main.server;
import main.commands.*;

public class CommandParser {
	public static ICommand Parse(String commandString) { 
		String commandParts[] = commandString.split(" ");
		String commandName = commandParts[0];

		/*if(commandParts.length > 1)
        	String args = commandParts[1];
    	*/
		switch(commandName)
		{
		case "iniciar": 
			return new StartCommand();	
		case "batalhar": 
			return new BattleCommand();
		case "fugir":
			return new RunCommand();
		case "atacar":
			return new AttackCommand();
		case "curar":
			return new HealCommand();
		case "comprarCura":
			return new BuyPotionCommand();
		case "help":
			return new HelpCommand();
		}
		return new NullCommand();


	}
}
