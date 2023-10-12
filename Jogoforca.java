package jogoforca;
import digitacao.digitacao;

public class Jogoforca {
    static String[] vet1 = new String[8];
    static int erros = 0;
    static String[] vet2 = new String[11];
    static char usad[] = new char[6]; 
    static boolean cond = true; 
    static String palavras[]={"abacate","abacaxi","acerola","cacau","caqui","kiwi","carambola","cereja","pitaya","framboesa","goiaba","groselha","guarana","jabuticaba","laranja","manga","maracuja","melancia","morango","pitanga"};
    static digitacao tcl = new digitacao();
    static boolean ver = true; 
    
    public static void main(String[] args) {
        do{
        double aleatorizador = Math.random() * 20;
        int aleatorio = (int) aleatorizador;
        String palavra = palavras[aleatorio];
        
        String letra;
        String[] vet1 = new String[8];
        vet1[0]="+-------";
        vet1[1]="|      |";
        vet1[2]="|       ";
        vet1[3]="|       ";
        vet1[4]="|       ";
        vet1[5]="|       ";
        vet1[6]="__      ";
        vet1[7]="";
        mostrarForca(vet1);
        int tent = 6;
        boolean[] letrev = new boolean[palavra.length()]; 
        char[] letUsada = new char[26]; 
        int letUsadaCont = 0;
        boolean letJaUsada = false;
        
        while (cond == true && tent > 0) {
            palescondida(palavra, letrev);
            System.out.println();
            System.out.println("Letras usadas: ");
            for (int i = 0; i < letUsadaCont; i++) {               
                System.out.print(letUsada[i]+", ");
            }
            System.out.println();
            letra = tcl.text("Insira uma letra: ").toLowerCase();  
            System.out.println("------------------------------------");
            mostrarForca(vet1);
            
            if (letra.length() == 1 && letra.charAt(0)>='a' && letra.charAt(0)<='z') {
                char letins = letra.charAt(0);
                for (int i = 0; i < letUsada.length; i++) {
                    if (letins==letUsada[i]) {
                        System.out.println("Essa letra já foi utilizada, insira outra");
                    }
                }
                boolean letencont = false;
                for (int i = 0; i < palavra.length(); i++) {
                    char letpal = palavra.charAt(i);
                    if (letpal == letins) {
                        letrev[i] = true;
                        letencont = true;
                    }
                }
                if (!letencont) {
                    tent--;
                    erros++;
                    trocarForca(vet1);
                }
                for (int i = 0; i < letUsada.length; i++) {
                 if (letins==letUsada[i]) {
                    letJaUsada=true;
                    break;
                    }   
                }
                if(!letJaUsada){
                letUsada[letUsadaCont] = letins;
                letUsadaCont++;
                }
            } else {
                System.out.println("Por favor, insira uma única letra válida");
            }
            if (verificarVitoria(letrev)) {
                palescondida(palavra, letrev);
                System.out.println("Parabéns, você venceu! A palavra era: " + palavra);
                break;
            }
        }   
        if (tent <= 0) {
            palescondida(palavra, letrev);
            System.out.println("Você perdeu! A palavra era: " + palavra);
        }
            boolean respval = false;
            do{
            String resp = tcl.text("Você quer jogar novamente? (Y/N)").toUpperCase();
            
            if (resp.equals("Y")) {
                ver=true;
                respval=true;
            }else if(resp.equals("N")){
                ver=false;
                respval=true;
            }else{
                System.out.println("Responda Y para sim e N para não, por favor");
            }
          }while(!respval);
        }while(ver);
    }

public static void mostrarForca(String[] vet1) {
    for (int i = 0; i < vet1.length; i++) {
        System.out.println(vet1[i]);
        }
    }
public static void trocarForca(String[] vet1){
        vet2[0]="+-------";
        vet2[1]="|      |";
        vet2[2]="|      O";
        vet2[3]="|      | ";
        vet2[4]="|      |\\ ";
        vet2[5]="|     /|\\ ";
        vet2[6]="|     /    ";
        vet2[7]="|     / \\ ";
        vet2[8]="|       ";
        vet2[9]="__      ";
        vet2[10]="";
        if(erros==1){
        for (int i = 0; i < vet1.length; i++) {
            vet1[2]=vet2[2];
            System.out.println(vet1[i]);
        }
        }else if(erros==2){
        for (int i = 0; i < vet1.length; i++) {
            vet1[2]=vet2[2];
            vet1[3]=vet2[3];
            System.out.println(vet1[i]);
        }
        }else if(erros==3){
        for (int i = 0; i < vet1.length; i++) {
            vet1[2]=vet2[2];
            vet1[3]=vet2[4];
            System.out.println(vet1[i]);
        }
        }else if(erros==4){
        for (int i = 0; i < vet1.length; i++) {
            vet1[2]=vet2[2];
            vet1[3]=vet2[5];
            System.out.println(vet1[i]);
        }
        }else if(erros==5){
        for (int i = 0; i < vet1.length; i++) {
            vet1[2]=vet2[2];
            vet1[3]=vet2[5];
            vet1[4]=vet2[6];
            System.out.println(vet1[i]);
        }
        }else if(erros==6){
        for (int i = 0; i < vet1.length; i++) {
            vet1[2]=vet2[2];
            vet1[3]=vet2[5];
            vet1[4]=vet2[7];
            System.out.println(vet1[i]);
        }
    }
}

public static void palescondida(String palavra, boolean[] letrev) {
        for (int i = 0; i < palavra.length(); i++) {
            char letra = palavra.charAt(i);
            if (letrev[i]) {
                System.out.print(letra + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

public static boolean verificarVitoria(boolean[] letrev) {
        for (boolean revelada : letrev) {
            if (!revelada) {
                return false; 
            }
        }
        return true; 
    }
}