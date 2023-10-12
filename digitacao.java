package digitacao;
import java.util.Scanner;

public class digitacao {
    
    Scanner tcl = new Scanner (System.in);

    /** texto **/
    public String text(String msg){
        System.out.println(msg);
        String dado = tcl.nextLine();
        return dado;
    }
		/** inteiros **/
    public int inteiro(String mensagem,
                        String msgErro,
                        boolean repetir){
        int dado = 0;
        boolean erro = false;
        do{
            String aux = text(mensagem);
            try{
                dado = Integer.parseInt(aux);
                erro = false;
            }
            catch(RuntimeException e){
                System.out.println(msgErro);
                erro = repetir;
            }
        }while (erro);
        return dado;
    }
		/** decimais **/
    public double decimal(String msg) throws Exception{
        double dado = 0.0;
        String aux = text(msg);
        aux = aux.replaceAll(",",".");
        try{
            dado = Double.parseDouble(aux);           
        }catch (Exception e){
            throw new Exception("Erro de digitação");
        }
        return dado;
    }
}