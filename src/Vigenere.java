import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Vigenere {
    private static String encriptar(String texto, String chave) {
        String cifra = "";

        for (int i = 0; i < texto.length(); i++) {
            int charTexto = texto.charAt(i);
            int charChave = chave.charAt((i % chave.length()));
            int charCifra = (charTexto ^ charChave);

            // conversao hexadecimal
            String temp = Integer.toHexString(0xFF & charCifra);
            if (temp.length() == 1) temp = "0" + temp;
            
            cifra += temp;
        }
        
        return cifra;
    }
    private static String decriptar(String cifra, String chave) {
        String texto = "";

        for (int i = 0; i < cifra.length(); i+= 2 ) {
            int charCifra = Integer.parseInt(cifra.substring(i, i +2),16);
            int charChave = chave.charAt((i/2) % chave.length());
            int charTexto = (charCifra ^ charChave);

            texto += ((char) charTexto);
        }
        
        return texto;
    }

    public static void main(String[] args) {
        BufferedReader leitor = new BufferedReader(
                                new InputStreamReader(System.in));
        String texto = "";
        String chave = "";
        String cifra = "";

        try {
            System.out.println("Digite um texto: ");
            texto = leitor.readLine();

            System.out.println("Digite uma chave: ");
            chave = leitor.readLine();


            cifra = encriptar(texto , chave);
            System.out.println(cifra);

            texto = decriptar(cifra, chave);
            System.out.println(texto);

        } catch (Exception erro) {
            System.out.println("FUDEU  " + erro);
        }
        
    }
}
