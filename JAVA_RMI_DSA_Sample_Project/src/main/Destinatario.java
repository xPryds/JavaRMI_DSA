package main;
import java.security.InvalidKeyException;
  import java.security.NoSuchAlgorithmException;
  import java.security.PublicKey;
  import java.security.Signature;
  import java.security.SignatureException;
   
public class Destinatario {
	 public boolean recebeMensagem(PublicKey pubKey, String mensagem, byte[] assinatura) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
         Signature clientSig = Signature.getInstance("DSA");  
         clientSig.initVerify(pubKey);  
         clientSig.update(mensagem.getBytes());  
           
         if (clientSig.verify(assinatura)) {  
             //Mensagem corretamente assinada
            System.out.println("[Server].recebeMensagem(): A Mensagem recebida foi assinada corretamente.");
         } else {
             //Mensagem não pode ser validada
            System.out.println("[Server].recebeMensagem(): A Mensagem recebida NÃO pode ser validada.");
            return false;
         }  
         return true;
     }
}
