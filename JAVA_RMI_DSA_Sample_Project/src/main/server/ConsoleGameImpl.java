package main.server;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;

import main.ConsoleGame;
import main.Destinatario;
import main.GameManager;
import main.Remetente;
import main.commands.ICommand;
import main.server.model.Player; 

public class ConsoleGameImpl extends UnicastRemoteObject implements ConsoleGame {
	
	public ConsoleGameImpl() throws RemoteException  
	{ 
		super(); 
	} 
	
	@Override
	public GameManager executeCommand(GameManager gameManager, String input, PublicKey pubKey, byte[] assinatura) throws RemoteException, InvalidKeyException, NoSuchAlgorithmException, SignatureException {
		Destinatario destinatarioAssiDig = new Destinatario();
		boolean isValid = false;
		
		System.out.println("[" + gameManager.getPlayer().getName() + "]" + " [DSA] Validando assinatura..."); 
		Remetente remetenteAssiDig = new Remetente();
		
		//Se comando for invalidar, inicia exemplo de teste de valida��o
		if(input.equals("invalidar")){	
			System.out.println("[DSA] Iniciando Exemplo de Assinatura Inv�lida...\n"); 
		
	        //Destinat�rio recebe mensagem alterada
			System.out.println("[DSA] EXEMPLO 1:\nDestinat�rio recebe mensagem alterada"); 
	        String input2 = "Exemplo de um comando alterado!";
	        destinatarioAssiDig.recebeMensagem(pubKey, input2, assinatura);
	
	        //Criando outra Assinatura
	        byte[] assinatura2 = remetenteAssiDig.geraAssinatura(input2);
	        //Guarda Chave P�blica para ser Enviada ao Destinat�rio
	        PublicKey pubKey2 = remetenteAssiDig.getPubKey();
	
	        //Destinat�rio recebe outra assinatura
			System.out.println("[DSA] EXEMPLO 2:\nDestinat�rio recebe outra assinatura"); 
	        destinatarioAssiDig.recebeMensagem(pubKey, input, assinatura2);
	        
	        //Destinat�rio recebe outra chave p�blica
			System.out.println("[DSA] EXEMPLO 3:\nDestinat�rio recebe outra chave p�blica"); 
	        destinatarioAssiDig.recebeMensagem(pubKey2, input, assinatura);
			
	        isValid = destinatarioAssiDig.recebeMensagem(pubKey2, input, assinatura2);
			System.out.println("[DSA] Fim dos exemplos de assinatura inv�lida \n\n"); 
		}else{
			isValid = destinatarioAssiDig.recebeMensagem(pubKey, input, assinatura);
		}
		
		if(!isValid){
			gameManager.setMessage("Erro de valida��o de assinatura!");
			return gameManager;
		}

		System.out.println("[" + gameManager.getPlayer().getName() + "]" + " [DSA] Assinatura v�lida!"); 
		ICommand command = CommandParser.Parse(input);
		gameManager = command.Execute(gameManager);
		System.out.println("[" + gameManager.getPlayer().getName() + "]" + " Executando comando: " + input + "\n");
		String message = gameManager.getMessage();
		message+= " - [DSA] Esta mens�gem foi validada";
		gameManager.setMessage(message);
		return gameManager;
	} 
}
