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
		
		//Se comando for invalidar, inicia exemplo de teste de validação
		if(input.equals("invalidar")){	
			System.out.println("[DSA] Iniciando Exemplo de Assinatura Inválida...\n"); 
		
	        //Destinatário recebe mensagem alterada
			System.out.println("[DSA] EXEMPLO 1:\nDestinatário recebe mensagem alterada"); 
	        String input2 = "Exemplo de um comando alterado!";
	        destinatarioAssiDig.recebeMensagem(pubKey, input2, assinatura);
	
	        //Criando outra Assinatura
	        byte[] assinatura2 = remetenteAssiDig.geraAssinatura(input2);
	        //Guarda Chave Pública para ser Enviada ao Destinatário
	        PublicKey pubKey2 = remetenteAssiDig.getPubKey();
	
	        //Destinatário recebe outra assinatura
			System.out.println("[DSA] EXEMPLO 2:\nDestinatário recebe outra assinatura"); 
	        destinatarioAssiDig.recebeMensagem(pubKey, input, assinatura2);
	        
	        //Destinatário recebe outra chave pública
			System.out.println("[DSA] EXEMPLO 3:\nDestinatário recebe outra chave pública"); 
	        destinatarioAssiDig.recebeMensagem(pubKey2, input, assinatura);
			
	        isValid = destinatarioAssiDig.recebeMensagem(pubKey2, input, assinatura2);
			System.out.println("[DSA] Fim dos exemplos de assinatura inválida \n\n"); 
		}else{
			isValid = destinatarioAssiDig.recebeMensagem(pubKey, input, assinatura);
		}
		
		if(!isValid){
			gameManager.setMessage("Erro de validação de assinatura!");
			return gameManager;
		}

		System.out.println("[" + gameManager.getPlayer().getName() + "]" + " [DSA] Assinatura válida!"); 
		ICommand command = CommandParser.Parse(input);
		gameManager = command.Execute(gameManager);
		System.out.println("[" + gameManager.getPlayer().getName() + "]" + " Executando comando: " + input + "\n");
		String message = gameManager.getMessage();
		message+= " - [DSA] Esta menságem foi validada";
		gameManager.setMessage(message);
		return gameManager;
	} 
}
