package main;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.rmi.Remote; 
import java.rmi.RemoteException; 
   
public interface ConsoleGame extends Remote 
{ 
	GameManager executeCommand(GameManager player, String input, PublicKey key, byte[] assinatura) throws RemoteException, InvalidKeyException, NoSuchAlgorithmException, SignatureException; 
}