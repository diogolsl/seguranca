import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CriptografiaROT13 {
    private static String criptografar(String texto) {
        String cifra = "";

        for (int i = 0; i < texto.length(); i++) {
            int letraOriginal = texto.charAt(i);
            int letraCifrada = letraOriginal;

            if (letraOriginal >= 97 && ( letraOriginal <= 109)) {
                letraCifrada = (letraOriginal + 13);
            } else if ((letraOriginal >= 110) && (letraOriginal <= 122)) {
                letraCifrada = (letraOriginal - 13);
            }
            cifra += ((char) letraCifrada);
            }
        return cifra;
        }

    public static void main(String[] args) {
        // declarar variaveis
        BufferedReader leitor = new BufferedReader(
                new InputStreamReader(System.in));
        String texto = "";
        String cifra = "";

        //Entrada de dados
        try {
            System.out.print("Digite um texto: ");
            texto = leitor.readLine();
        } catch (Exception e) {}

        // Processamento
        cifra = criptografar(texto);
        texto = criptografar(cifra);

        // Saída de dados
        System.out.println(cifra);
        System.out.println(texto);
    }
}








