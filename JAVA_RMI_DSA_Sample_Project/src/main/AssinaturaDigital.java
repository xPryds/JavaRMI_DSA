package main;
  import java.security.InvalidKeyException;
  import java.security.NoSuchAlgorithmException;
  import java.security.PublicKey;
  import java.security.SignatureException;
   
public class AssinaturaDigital {
	  public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
          //Remetente Gera Assinatura Digital para uma Mensagem
          Remetente remetenteAssiDig = new Remetente();
          String mensagem = "Exemplo de mensagem.";
          byte[] assinatura = remetenteAssiDig.geraAssinatura(mensagem);
          //Guarda Chave P�blica para ser Enviada ao Destinat�rio
          PublicKey pubKey = remetenteAssiDig.getPubKey();
         
          //Destinat�rio recebe dados correto
          Destinatario destinatarioAssiDig = new Destinatario();
          destinatarioAssiDig.recebeMensagem(pubKey, mensagem, assinatura);
          
          //Destinat�rio recebe mensagem alterada
          String msgAlterada = "Exemplo de mensagem alterada.";
          destinatarioAssiDig.recebeMensagem(pubKey, msgAlterada, assinatura);

          //Criando outra Assinatura
            String mensagem2 = "Exemplo de outra mensagem.";  
          byte[] assinatura2 = remetenteAssiDig.geraAssinatura(mensagem2);
          //Guarda Chave P�blica para ser Enviada ao Destinat�rio
          PublicKey pubKey2 = remetenteAssiDig.getPubKey();

          //Destinat�rio recebe outra assinatura
          destinatarioAssiDig.recebeMensagem(pubKey, mensagem, assinatura2);
          
          //Destinat�rio recebe outra chave p�blica
          destinatarioAssiDig.recebeMensagem(pubKey2, mensagem, assinatura);


      }
}
